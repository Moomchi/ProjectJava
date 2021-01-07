package com.mimi.FoodDelivery.entities;

import javax.persistence.*;

@Entity
@Table(name="district")

public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="district_name")
    private String districtName;

    @Column(name="time")
    private Integer time;

    @ManyToOne()
    @JoinColumn(name="city_id")
    private City city;

    public District() {
    }

    public District(Long id, String districtName, Integer time, City city) {
        this.id = id;
        this.districtName = districtName;
        this.time = time;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
