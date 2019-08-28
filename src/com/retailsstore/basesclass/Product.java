package com.retailsstore.basesclass;

public class Product implements ProductItem{

	private final String name;
    private final double unitPrice;
    private final ProductType type;


    public Product(String name, double priceInDollars, ProductType type) {
        this.name = name;
        this.unitPrice = priceInDollars;
        this.type = type;
    }


    public double getItemUnitPrice() {
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    public double priceForItemQuantity(int quantity) {
        return unitPrice * quantity;
    }

    public ProductType getType() {
    	return type;
    }

}
