package com.mimi.FoodDelivery.repositories;

import com.mimi.FoodDelivery.entities.Burger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BurgerRepository extends JpaRepository<Burger,Long> {

    @Query("SELECT b FROM Burger b WHERE lower(b.burgerName) = :name ")
    Optional<Burger> findByName(String name);

    @Query("SELECT b FROM Burger b "+
            "WHERE lower(b.burgerName) "+
            "LIKE :#{#name==null || #name.isEmpty()? '%' : '%'+#name+'%'} ")
    Page<Burger> findPageBurger(Pageable pageable,String name);
}
