package com.mimi.FoodDelivery.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name="orders")

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date")
    private String date;

    @Column(name="received")
    private Boolean received;

    @Column(name="order_list")
    private String orderList;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="total_price")
    private BigDecimal totalPrice;

    public Orders() {
    }

    public Orders(Long id, Boolean received, String orderList, String customerName, String date,BigDecimal totalPrice) {
        this.id = id;
        this.date = date;
        this.received = received;
        this.orderList = orderList;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() { return totalPrice; }

    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    public String getOrderList() {
        return orderList;
    }

    public void setOrderList(String orderList) {
        this.orderList = orderList;
    }
}
