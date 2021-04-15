package com.demisco.project.model;

import com.demisco.project.bean.CustomerAddress;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
public class Orders {
    private Integer orderId;
    private Date orderDate;
    private Double totalPrice;
    private User user;
    private CustomerAddress address;
    private Set<CartItem> cartItems = new HashSet<>();

    @Id
    @Column(name = "orders_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getOrderId() {
        return orderId;
    }

    private void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Column(name = "order_date", nullable = false)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name = "total_price", nullable = false)
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "province", column = @Column(name = "province", nullable = false)),
            @AttributeOverride(name = "city", column = @Column(name = "city", nullable = false)),
            @AttributeOverride(name = "street", column = @Column(name = "street", nullable = false)),
            @AttributeOverride(name = "postalCode", column = @Column(name = "postal_code", nullable = false)),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "phone_number", nullable = false))
    })
    public CustomerAddress getAddress() {
        return address;
    }

    public void setAddress(CustomerAddress address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Orders() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId.equals(orders.orderId) &&
                orderDate.equals(orders.orderDate) &&
                totalPrice.equals(orders.totalPrice) &&
                address.equals(orders.address) &&
                Objects.equals(cartItems, orders.cartItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate, totalPrice, address, cartItems);
    }

    public void addCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems.addAll(cartItems.values());
        for (CartItem item : cartItems.values())
            item.setOrders(this);
    }
}