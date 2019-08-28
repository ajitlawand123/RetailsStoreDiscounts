package com.retailsstore.discounts.product;

import com.retailsstore.basesclass.ProductItem;
import com.retailsstore.basesclass.ProductType;

public class PromotionPricing extends PricingPolicy{

	private final double priceFactor;

	public PromotionPricing(ProductItem baseItem, int percentPromotion){

		super(baseItem);

		if (percentPromotion < 0 || percentPromotion > 100 ) {
            throw new IllegalArgumentException("percentPromotion must be in [0,100]");
        }
        this.priceFactor = (100 - percentPromotion) / 100.0;
	}


	    public double priceForQuantity(int quantity) {
	    	// If Grocery then don't apply the percentage discount
	    	if (super.getType() == ProductType.GROCERY) {
	    		return super.priceForItemQuantity(quantity);
	    	}

	    	// else apply percentage discount
	        return (super.priceForItemQuantity(quantity) * priceFactor);
	    }

}
