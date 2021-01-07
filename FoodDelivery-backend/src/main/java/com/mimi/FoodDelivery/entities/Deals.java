package com.mimi.FoodDelivery.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name="deals")

public class Deals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="price")
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name ="pizza_id")
    private Pizza pizza;

    @ManyToOne()
    @JoinColumn(name ="burger_id")
    private Burger burger;

    @ManyToOne()
    @JoinColumn(name ="drink_id")
    private Drink drink;

    @ManyToOne()
    @JoinColumn(name ="dessert_id")
    private Dessert dessert;

    @ManyToOne()
    @JoinColumn(name ="salad_id")
    private Salad salad;



    public Deals() {
    }

    public Deals(Long id, BigDecimal price, Pizza pizza, Burger burger, Drink drink, Dessert dessert, Salad salad) {
        this.id = id;
        this.price = price;
        this.pizza = pizza;
        this.burger = burger;
        this.drink = drink;
        this.dessert = dessert;
        this.salad = salad;
    }

    public Burger getBurger() {
        return burger;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public Salad getSalad() {
        return salad;
    }

    public void setSalad(Salad salad) {
        this.salad = salad;
    }
}
