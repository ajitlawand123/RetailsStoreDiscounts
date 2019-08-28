package com.retailsstore.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.retailsstore.basesclass.Cart;
import com.retailsstore.basesclass.Product;
import com.retailsstore.basesclass.ProductItem;
import com.retailsstore.basesclass.ProductType;
import com.retailsstore.basesclass.User;
import com.retailsstore.basesclass.UserType;

public class TestWithoutDiscounts {

	private Cart cart;
    private ProductItem item;

    @Before
    public void setUp() {
    	User user = new User(UserType.SIMPLE, "John");
        cart = new Cart(user);
        item = new Product("something", 1000, ProductType.OTHER);
    }

    @Test
    public void test_emptyCartCostsZero() {
        assertEquals(0, cart.total(), 0.01);
    }


    @Test
    public void test_singleBasicItemCostsItsUnitPrice() {
        cart.add(item);
        assertEquals(item.getItemUnitPrice(), cart.total(), 0.01);
    }

    @Test
    public void test_multipleBasicItemsCostProportionally() {
        int howMany = 3;
        cart.add(item, howMany);
        assertEquals(howMany * item.getItemUnitPrice(), cart.total(), 0.01);
    }

    @Test
    public void test_separatelyAdding() {
        int howMany = 3;
        for (int i = howMany; i > 0; i--) {
            cart.add(item);
        }
        assertEquals(howMany * item.getItemUnitPrice(), cart.total(), 0.01);
    }

}
