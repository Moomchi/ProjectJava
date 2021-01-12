package com.mimi.FoodDelivery.entities;

import javax.persistence.*;


@Entity
@Table(name="orders")

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date")
    private String date;

    @Column(name="recieved")
    private Boolean recieved;

    @Column(name="order_list")
    private String orderList;

    @Column(name="customer_name")
    private String customerName;

    public Orders() {
    }

    public Orders(Long id, Boolean recieved, String orderList, String customerName, String date) {
        this.id = id;
        this.date = date;
        this.recieved = recieved;
        this.orderList = orderList;
        this.customerName = customerName;
    }

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
        return recieved;
    }

    public void setReceived(Boolean recieved) {
        this.recieved = recieved;
    }

    public String getOrderList() {
        return orderList;
    }

    public void setOrderList(String orderList) {
        this.orderList = orderList;
    }
}
