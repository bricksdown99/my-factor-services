package com.microservices.beans;

public class Factor {

	private int floodFactor;
	
	private int buildingSafetyFactor;
	
	private String location;
	
	public Factor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFloodFactor() {
		return floodFactor;
	}

	public void setFloodFactor(int floodFactor) {
		this.floodFactor = floodFactor;
	}

	public int getBuildingSafetyFactor() {
		return buildingSafetyFactor;
	}

	public void setBuildingSafetyFactor(int buildingSafetyFactor) {
		this.buildingSafetyFactor = buildingSafetyFactor;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Factor [floodFactor=" + floodFactor + ", buildingSafetyFactor=" + buildingSafetyFactor + ", location="
				+ location + "]";
	}
	
	
	
	
	
}
