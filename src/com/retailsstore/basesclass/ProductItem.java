package com.retailsstore.basesclass;

public interface ProductItem {

	double getItemUnitPrice();

	double priceForItemQuantity(int quantity);

	String getName();

	ProductType getType();

}
