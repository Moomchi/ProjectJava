package com.mimi.FoodDelivery.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="city")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany()
    @JoinTable(name="city_deals",joinColumns = @JoinColumn(name="city_id"),
               inverseJoinColumns = @JoinColumn(name = "deals_id"))
    private Set<Deals> deals = new HashSet<>();

    public City() {
    }

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
