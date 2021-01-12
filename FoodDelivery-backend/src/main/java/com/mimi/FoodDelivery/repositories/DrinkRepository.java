package com.mimi.FoodDelivery.repositories;

import com.mimi.FoodDelivery.entities.Burger;
import com.mimi.FoodDelivery.entities.Drink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink,Long> {

    @Query("SELECT dr FROM Drink dr WHERE lower(dr.drinkName) = :name ")
    Optional<Drink> findByName(String name);

    @Query("SELECT dr FROM Drink dr "+
            "WHERE lower(dr.drinkName) "+
            "LIKE :#{#name==null || #name.isEmpty()? '%' : '%'+#name+'%'} ")
    Page<Drink> findPageDrink(Pageable pageable, String name);

    @Query("SELECT dr.price from Drink dr WHERE (dr.id) = :id ")
    BigDecimal findPriceById(Long id);
}
