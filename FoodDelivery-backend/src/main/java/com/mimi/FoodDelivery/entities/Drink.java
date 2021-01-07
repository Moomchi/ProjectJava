package com.mimi.FoodDelivery.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="drink")

public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="drink_name")
    private String drinkName;

    @Column(name="price")
    private BigDecimal price;

    public Drink() {
    }

    public Drink(Long id, String drinkName, BigDecimal price) {
        this.id = id;
        this.drinkName = drinkName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
