package com.microservices.services;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.beans.Price;
import com.microservices.config.EndpointConfiguration;
import com.microservices.imp.LocationPricing;
import com.microservices.imp.OthersPricingImpl;
import com.microservices.imp.PasigPricingImpl;
import com.microservices.imp.QCPricingImpl;
import com.microservices.interfaces.Location;

@Component
public class FactorService {
	
	@Autowired
	private EndpointConfiguration endpointConfig;
	
	public Price determineLocPricing(String location) {
		
		LocationPricing locPricing = null;
		Price price = null;
		
		if(location.equalsIgnoreCase(Location.PASIG)) {
			locPricing = new PasigPricingImpl();
		}else if(location.equalsIgnoreCase(Location.QC)) {
			locPricing = new QCPricingImpl();			
		}else {
			locPricing = new OthersPricingImpl();
		}
		
		price = locPricing.calculateLocPrice();
		
		
		return price;
	}
	
	public Price delegateCalculation(String location) throws ClientProtocolException, IOException {
	    CloseableHttpClient client = HttpClients.createDefault();
	    HttpPost httpPost = null;

		if(location.equalsIgnoreCase(Location.PASIG)) {
			httpPost = new HttpPost(endpointConfig.getLocPasig());
		}else if(location.equalsIgnoreCase(Location.QC)) {
			httpPost = new HttpPost(endpointConfig.getLocQC());	
		}else {
			httpPost = new HttpPost(endpointConfig.getLocOthers());	
		}
	    
	    CloseableHttpResponse response = client.execute(httpPost);
	    HttpEntity entity=response.getEntity();
	    String result= EntityUtils.toString(entity,"UTF-8");
	    
	    Price price = new ObjectMapper().readValue(result, Price.class);
	    
	    client.close();			
		return price;
	}

}
