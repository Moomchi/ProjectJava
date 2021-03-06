package com.mimi.FoodDelivery.repositories;

import com.mimi.FoodDelivery.entities.Salad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface SaladRepository extends JpaRepository<Salad,Long> {

    @Query("SELECT s FROM Salad s WHERE lower(s.saladName) = :name ")
    Optional<Salad> findByName(String name);

    @Query("SELECT s FROM Salad s " +
            "WHERE lower(s.saladName) " +
            "LIKE :#{#name==null || #name.isEmpty()? '%' : '%'+#name+'%'} ")
    Page<Salad> findPageSalad(Pageable pageable, String name);

    @Query("SELECT s.price from Salad s WHERE (s.id) = :id ")
    BigDecimal findPriceById(Long id);

    @Query("SELECT s.saladName from Salad s WHERE (s.id) = :id ")
    String getSaladName(Long id);
}
