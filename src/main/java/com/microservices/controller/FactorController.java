package com.microservices.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.beans.Factor;
import com.microservices.beans.LocationAttr;
import com.microservices.beans.Price;
import com.microservices.interfaces.Location;
import com.microservices.services.FactorService;

@RestController
public class FactorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FactorService factorService;
	
	@PostMapping("/factor-services")
	public ResponseEntity<LocationAttr> retrieveFactorResult(@RequestBody Factor factor) 
			throws ClientProtocolException, IOException{
		Price price = factorService.delegateCalculation(factor.getLocation());
		LocationAttr result = new LocationAttr(factor.getLocation(), price);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/smartratingservice")
	public ResponseEntity<Price> retrievePasigPrice() {
		Price price = factorService.determineLocPricing(Location.PASIG);

		return new ResponseEntity<>(price, HttpStatus.OK);
	}
	
	@PostMapping("/excellentratingservice")
	public ResponseEntity<Price> retrieveQCPrice() {
		Price price = factorService.determineLocPricing(Location.QC);
		
		return new ResponseEntity<>(price, HttpStatus.OK);
	}
	
	@PostMapping("/idoeverythingtratingservice")
	public ResponseEntity<Price> retrieveOthersPrice() {
		Price price = factorService.determineLocPricing("");
		
		return new ResponseEntity<>(price, HttpStatus.OK);
	}

}
