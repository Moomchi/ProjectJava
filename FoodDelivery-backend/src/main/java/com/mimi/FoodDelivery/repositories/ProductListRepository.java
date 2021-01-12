package com.mimi.FoodDelivery.repositories;

import com.mimi.FoodDelivery.entities.Burger;
import com.mimi.FoodDelivery.entities.Pizza;
import com.mimi.FoodDelivery.entities.ProductsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

public interface ProductListRepository extends JpaRepository<ProductsList,Long> {
    @Query("SELECT p FROM ProductsList p WHERE (p.customerId) = :customerId ")
    ArrayList<ProductsList> getListByCustomerId(Integer customerId);
}
