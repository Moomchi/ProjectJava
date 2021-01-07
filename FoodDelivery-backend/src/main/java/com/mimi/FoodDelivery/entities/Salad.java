package com.mimi.FoodDelivery.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "salad")
public class Salad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="salad_name")
    private String saladName;

    @Column(name="price")
    private BigDecimal price;

    public Salad() {
    }

    public Salad(Long id, String saladName, BigDecimal price) {
        this.id = id;
        this.saladName = saladName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSaladName() {
        return saladName;
    }

    public void setSaladName(String saladName) {
        this.saladName = saladName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

