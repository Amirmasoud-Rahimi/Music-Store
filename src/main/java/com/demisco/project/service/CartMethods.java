package com.demisco.project.service;

import com.demisco.project.model.*;
import com.demisco.project.bean.*;

import javax.servlet.http.HttpSession;

public class CartMethods {
    public static Orders completeOrder(Cart cart, Orders orders, CustomerAddress address, HttpSession session) {
        User user = (User) session.getAttribute("member");
        orders.addCartItems(cart.getCartItems());
        orders.setAddress(address);
        orders.setUser(user);
        user.addOrder(orders);
        return orders;
    }
}