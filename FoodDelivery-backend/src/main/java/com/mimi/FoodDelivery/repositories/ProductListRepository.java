package com.mimi.FoodDelivery.repositories;

import com.mimi.FoodDelivery.entities.ProductsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface ProductListRepository extends JpaRepository<ProductsList,Long> {

    @Query("SELECT p FROM ProductsList p WHERE (p.customerId) = :customerId ")
    ArrayList<ProductsList> getListByCustomerId(Integer customerId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProductsList p WHERE (p.customerId) = :customerId ")
    void deleteProductList(Integer customerId);
}
