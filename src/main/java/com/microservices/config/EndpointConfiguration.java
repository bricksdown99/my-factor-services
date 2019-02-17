package com.microservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("endpoint")
public class EndpointConfiguration {
	
	private String locPasig;
	
	private String locQC;
	
	private String locOthers;

	public String getLocPasig() {
		return locPasig;
	}

	public void setLocPasig(String locPasig) {
		this.locPasig = locPasig;
	}

	public String getLocQC() {
		return locQC;
	}

	public void setLocQC(String locQC) {
		this.locQC = locQC;
	}

	public String getLocOthers() {
		return locOthers;
	}

	public void setLocOthers(String locOthers) {
		this.locOthers = locOthers;
	}
	
	

}
