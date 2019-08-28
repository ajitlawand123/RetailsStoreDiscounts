package com.retailsstore.discounts.product;

import com.retailsstore.basesclass.ProductItem;
import com.retailsstore.basesclass.ProductType;

public class PricingPolicy implements ProductItem{

	private final ProductItem baseItem;

	public PricingPolicy(ProductItem baseItem){

		this.baseItem = baseItem;
	}


	public double getItemUnitPrice(){

		return baseItem.getItemUnitPrice();
	}


	public String getName(){

		return baseItem.getName();
	}


	public ProductType getType(){

		return baseItem.getType();
	}

	public double priceForItemQuantity(int quantity){

		return baseItem.priceForItemQuantity(quantity);
	}

}
