package com.suo.pojo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void addItem() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.addItem(new CartItem(2,"C++入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"C++入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.addItem(new CartItem(2,"C++入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"C++入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    void clear() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.addItem(new CartItem(2,"C++入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"C++入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.clear();

        System.out.println(cart);
    }

    @Test
    void updateCount() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.addItem(new CartItem(2,"C++入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"C++入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.updateCount(1,1);

        System.out.println(cart);
    }
}