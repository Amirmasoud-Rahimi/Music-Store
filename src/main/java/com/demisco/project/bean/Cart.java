package com.demisco.project.bean;

import com.demisco.project.model.*;

import java.util.*;

public class Cart {
    private Map<Integer, CartItem> cartItems = new HashMap<>();

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public Cart() {
    }

    public void addItem(MusicAlbum musicAlbum) {
        CartItem cartItem = new CartItem(1, musicAlbum);
        cartItems.put(musicAlbum.getAlbumId(), cartItem);
        musicAlbum.addCartItem(cartItem);
    }

    public void removeItem(Integer albumId, MusicAlbum musicAlbum) {
        cartItems.remove(albumId);
        musicAlbum.removeCartItem(cartItems.get(albumId));
    }

    public void updateQuantity(Integer albumId, Integer quantity, MusicAlbum musicAlbum) {
        musicAlbum.removeCartItem(cartItems.get(albumId));
        cartItems.get(albumId).setQuantity(quantity);
        musicAlbum.addCartItem(cartItems.get(albumId));
    }
}