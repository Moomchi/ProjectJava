package com.mimi.FoodDelivery.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "pizza_name")
    private String pizzaName;

    @Column(name= "price")
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn (name= "sauce_id")
    private Sauce sauce;

    public Pizza() {
    }

    public Pizza(Long id, String pizzaName, BigDecimal price,Sauce sauce) {
        this.id = id;
        this.pizzaName = pizzaName;
        this.price = price;
        this.sauce = sauce;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
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
