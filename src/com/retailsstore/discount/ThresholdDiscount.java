package com.retailsstore.discount;

public class ThresholdDiscount implements ProductDiscountPolicy{

public double applyDiscount(double totalAmount) {

		if (totalAmount < 100) {
			return totalAmount;
		}

		int discountFactor = (int) totalAmount / 100;
		double discount = discountFactor * 5;
		return totalAmount - discount;
	}

}
