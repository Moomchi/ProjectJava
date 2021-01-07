package com.mimi.FoodDelivery.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="dessert")

public class Dessert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="dessert_name")
    private String dessertName;

    @Column(name="price")
    private BigDecimal price;

    public Dessert() {
    }

    public Dessert(Long id, String dessertName, BigDecimal price) {
        this.id = id;
        this.dessertName = dessertName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
