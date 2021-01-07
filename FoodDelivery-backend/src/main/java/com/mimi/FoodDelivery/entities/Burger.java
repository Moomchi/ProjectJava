package com.mimi.FoodDelivery.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="burger")

public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "burger_name")
    private String burgerName;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "sauce_id")
    private Sauce sauce;

    public Burger() {

    }

    public Burger(Long id, String burgerName, BigDecimal price, Sauce sauce) {
        this.id = id;
        this.burgerName = burgerName;
        this.price = price;
        this.sauce = sauce;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBurgerName() {
        return burgerName;
    }

    public void setBurgerName(String burgerName) {
        this.burgerName = burgerName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

}
