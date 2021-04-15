package com.demisco.project.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart_item")
public class CartItem {
    private Integer cartItemId;
    private Integer quantity;
    private MusicAlbum musicAlbum;
    private Orders orders;

    @Id
    @Column(name = "cart_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCartItemId() {
        return cartItemId;
    }

    private void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    @Column(nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(name = "music_album_id", nullable = false)
    public MusicAlbum getMusicAlbum() {
        return musicAlbum;
    }

    public void setMusicAlbum(MusicAlbum musicAlbum) {
        this.musicAlbum = musicAlbum;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public CartItem() {
    }

    public CartItem(Integer quantity, MusicAlbum musicAlbum) {
        this.quantity = quantity;
        this.musicAlbum = musicAlbum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem item = (CartItem) o;
        return cartItemId.equals(item.cartItemId) &&
                quantity.equals(item.quantity) &&
                musicAlbum.equals(item.musicAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemId, quantity, musicAlbum);
    }
}