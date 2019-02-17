package com.microservices.imp;

import com.microservices.beans.Price;

public class QCPricingImpl implements LocationPricing {

	@Override
	public Price calculateLocPrice() {
		
		//hard coded price
		Price price = new Price.PriceBuilder()
				.setGrossPrice(new Double("5000"))
				.setNetPrice(new Double("4000"))
				.setTechnicalPrice(new Double("3000"))
				.build();
		
		return price;
	}

}
