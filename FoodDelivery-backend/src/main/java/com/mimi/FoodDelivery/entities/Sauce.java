package com.mimi.FoodDelivery.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sauce")
public class Sauce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="sauce_name")
    private String sauceName;

    @Column(name="price")
    private BigDecimal price;

    public Sauce() {
    }

    public Sauce(Long id, String sauceName, BigDecimal price) {
        this.id = id;
        this.sauceName = sauceName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSauceName() {
        return sauceName;
    }

    public void setSauceName(String sauceName) {
        this.sauceName = sauceName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
