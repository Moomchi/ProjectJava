package com.mimi.FoodDelivery.repositories;

import com.mimi.FoodDelivery.entities.Burger;
import com.mimi.FoodDelivery.entities.Sauce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SauceRepository extends JpaRepository<Sauce,Long> {

    @Query("SELECT s FROM Sauce s WHERE lower(s.sauceName) = :name ")
    Optional<Sauce> findByName(String name);

    @Query("SELECT s FROM Sauce s "+
            "WHERE lower(s.sauceName) "+
            "LIKE :#{#name==null || #name.isEmpty()? '%' : '%'+#name+'%'} ")
    Page<Sauce> findPageSauce(Pageable pageable, String name);
}
