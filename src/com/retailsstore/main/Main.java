package com.retailsstore.main;

import com.retailsstore.basesclass.Cart;
import com.retailsstore.basesclass.Product;
import com.retailsstore.basesclass.ProductItem;
import com.retailsstore.basesclass.ProductType;
import com.retailsstore.basesclass.User;
import com.retailsstore.basesclass.UserType;
import com.retailsstore.discount.ProductDiscountPolicy;
import com.retailsstore.discount.ThresholdDiscount;

public class Main {

	public static void main(String[] args) {

		User employee = new User(UserType.EMPLOYEE, "John");
		ProductItem groceryItem = new Product("Rice", 20, ProductType.GROCERY);
		ProductItem otherItem = new Product("TV", 222, ProductType.OTHER);
		ProductDiscountPolicy discountPolicy = new ThresholdDiscount();

        Cart cart = new Cart(employee, discountPolicy);
        cart.add(groceryItem, 4);
        cart.add(otherItem, 4);
        /*
         *  Total (20 * 4) + (222 * 4) = 968
         *  No discount on grocery items = 968 still
         *  After 30% discount on 4 other items totalling 888 = 701.6
         *  After 35 dollars off due to price over $700 = 666.59999 or 666.6
         */
        System.out.println(cart.total());
    }
		// TODO Auto-generated method stub

}
