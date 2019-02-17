package com.microservices.imp;

import com.microservices.beans.Price;

public class PasigPricingImpl implements LocationPricing {

	@Override
	public Price calculateLocPrice() {
		
		//hard coded price
		Price price = new Price.PriceBuilder()
				.setGrossPrice(new Double("999.99"))
				.setNetPrice(new Double("777.77"))
				.setTechnicalPrice(new Double("888.88"))
				.build();
		
		return price;
	}

}
