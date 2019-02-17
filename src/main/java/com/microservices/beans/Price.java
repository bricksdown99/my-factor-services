package com.microservices.beans;

public class Price {
	
	private Double grossPrice;	
	private Double technicalPrice;
	private Double netPrice;

	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Double getGrossPrice() {
		return grossPrice;
	}

	public void setGrossPrice(Double grossPrice) {
		this.grossPrice = grossPrice;
	}

	public Double getTechnicalPrice() {
		return technicalPrice;
	}

	public void setTechnicalPrice(Double technicalPrice) {
		this.technicalPrice = technicalPrice;
	}

	public Double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(Double netPrice) {
		this.netPrice = netPrice;
	}

	@Override
	public String toString() {
		return "Price [grossPrice=" + grossPrice + ", technicalPrice=" + technicalPrice + ", netPrice=" + netPrice
				+ "]";
	}
	
	private Price(PriceBuilder builder) {
		this.grossPrice = builder.grossPrice;
		this.technicalPrice = builder.technicalPrice;
		this.netPrice = builder.netPrice;
	}
	
	//Builder Class
	public static class PriceBuilder{

		private Double grossPrice;	
		private Double technicalPrice;
		private Double netPrice;
		
		public PriceBuilder(){
		}

		public PriceBuilder setGrossPrice(Double grossPrice) {
			this.grossPrice = grossPrice;
			return this;
		}

		public PriceBuilder setTechnicalPrice(Double technicalPrice) {
			this.technicalPrice = technicalPrice;
			return this;
		}
		
		public PriceBuilder setNetPrice(Double netPrice) {
			this.netPrice = netPrice;
			return this;
		}
		
		public Price build(){
			return new Price(this);
		}

	}
	
	

}
