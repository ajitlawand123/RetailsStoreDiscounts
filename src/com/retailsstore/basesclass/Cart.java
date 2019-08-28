package com.retailsstore.basesclass;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;

import com.retailsstore.discount.ProductDiscountPolicy;
import com.retailsstore.discounts.product.PromotionPricing;

public class Cart {

	private Map<ProductItem,Integer> productQuantities;

	private ProductDiscountPolicy productDiscountPolicy;

	private User user;

	public Cart(User user) {
		productQuantities = new LinkedHashMap<ProductItem, Integer>();
        this.user = user;
    }

	public Cart(User user, ProductDiscountPolicy discountPolicy) {
		productQuantities = new LinkedHashMap<ProductItem, Integer>();
        this.user = user;
        this.productDiscountPolicy = discountPolicy;
    }


	public double total() {

        double result = 0;
        for (ProductItem each : productQuantities.keySet()) {
            result += each.priceForItemQuantity(productQuantities.get(each));
        }

        if (productDiscountPolicy != null) {
        	result = productDiscountPolicy.applyDiscount(result);
        }

        return result;
    }


	public void add(ProductItem itemToBuy) {
        add(itemToBuy, 1);
    }


	 // To add multiple quantities of item
    public void add(ProductItem itemToBuy, int howMany) {
    	ProductItem item;

    	// Apply 30% discount in case of employee of store
    	if (user.getType() == UserType.EMPLOYEE) {
    		item = new PromotionPricing(itemToBuy, 30);
    	}
    	// Apply 10% discount in case of affiliate
    	else if (user.getType() == UserType.AFFILIATE) {
    		item = new PromotionPricing(itemToBuy, 10);
    	}

    	// If a user has been a customer for 2 or more years apply 5% discount
    	else if (user.getType() == UserType.SIMPLE &&
    			ChronoUnit.YEARS.between(user.getJoiningDate(), LocalDateTime.now()) >= 2) {
    		item = new PromotionPricing(itemToBuy, 5);
    	}

    	else {
    		item = itemToBuy;
    	}

        int previousQuantity = productQuantities.containsKey(item)
                ? productQuantities.get(item)
                : 0;
                productQuantities.put(item, previousQuantity + howMany);
    }
}
