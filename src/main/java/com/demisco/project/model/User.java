package com.demisco.project.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.*;

/**
 * DynamicUpdate:
 * When the entity is annotated with the @DynamicUpdate annotation,
 * the PreparedStatement is going to include only
 * the columns whose values have been changed.
 */
@Entity
@DynamicUpdate
public class User {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private String userType;
    private Set<Orders> orders = new HashSet<>();

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUserId() {
        return userId;
    }

    private void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "user_name", unique = true, nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "user_type", nullable = false)
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(userType, user.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, userName, password, userType);
    }

    public void addOrder(Orders orders) {
        this.orders.add(orders);
    }
}