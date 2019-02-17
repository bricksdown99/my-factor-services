package com.microservices.imp;

import com.microservices.beans.Price;

public class OthersPricingImpl implements LocationPricing {

	@Override
	public Price calculateLocPrice() {
		
		//hard coded price
		Price price = new Price.PriceBuilder()
				.setGrossPrice(new Double("200"))
				.setNetPrice(new Double("100"))
				.setTechnicalPrice(new Double("50"))
				.build();

		return price;
	}

}
