package com.mimi.FoodDelivery.repositories;

import com.mimi.FoodDelivery.entities.Burger;
import com.mimi.FoodDelivery.entities.Dessert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface DessertRepository extends JpaRepository<Dessert,Long> {

    @Query("SELECT d FROM Dessert d WHERE lower(d.dessertName) = :name ")
    Optional<Dessert> findByName(String name);

    @Query("SELECT d FROM Dessert d "+
            "WHERE lower(d.dessertName) "+
            "LIKE :#{#name==null || #name.isEmpty()? '%' : '%'+#name+'%'} ")
    Page<Dessert> findPageDessert(Pageable pageable, String name);

    @Query("SELECT d.price from Dessert d WHERE (d.id) = :id ")
    BigDecimal findPriceById(Long id);

    @Query("SELECT d.dessertName from Dessert d WHERE (d.id) = :id ")
    String getDessertName(Long id);
}
