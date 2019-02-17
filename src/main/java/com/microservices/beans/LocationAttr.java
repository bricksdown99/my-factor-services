package com.microservices.beans;

public class LocationAttr {

	private String location;
	
	private Price price;
	
	public LocationAttr(String location, Price price) {
		super();
		this.location = location;
		this.price = price;
	}

	public LocationAttr() {
		super();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "LocationAttr [location=" + location + ", price=" + price + "]";
	}
	
	
	
	
}
