package com.mimi.FoodDelivery.repositories;

import com.mimi.FoodDelivery.entities.Burger;
import com.mimi.FoodDelivery.entities.Pizza;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {

    @Query("SELECT p FROM Pizza p WHERE lower(p.pizzaName) = :name ")
    Optional<Pizza> findByName(String name);

    @Query("SELECT p FROM Pizza p "+
            "WHERE lower(p.pizzaName) "+
            "LIKE :#{#name==null || #name.isEmpty()? '%' : '%'+#name+'%'} ")
    Page<Pizza> findPagePizza(Pageable pageable, String name);

    @Query("SELECT p.price from Pizza p WHERE (p.id) = :id ")
    BigDecimal findPriceById(Long id);
}
