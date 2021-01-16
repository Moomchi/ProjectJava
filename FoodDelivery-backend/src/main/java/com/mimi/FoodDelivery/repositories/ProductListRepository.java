package com.mimi.FoodDelivery.repositories;

import com.mimi.FoodDelivery.entities.Burger;
import com.mimi.FoodDelivery.entities.ProductsList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface ProductListRepository extends JpaRepository<ProductsList,Long> {

    @Query("SELECT p FROM ProductsList p WHERE (p.customerId) = :customerId ")
    ArrayList<ProductsList> getListByCustomerId(Integer customerId);

    @Query("SELECT p FROM ProductsList p "+
            "WHERE (p.customerId) = :customerId " )
    Page<ProductsList> findPageProductList(Pageable pageable, Integer customerId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProductsList p WHERE (p.customerId) = :customerId ")
    void deleteProductList(Integer customerId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProductsList p WHERE (p.id) = :id ")
    void deleteProductListById(Long id);
}
