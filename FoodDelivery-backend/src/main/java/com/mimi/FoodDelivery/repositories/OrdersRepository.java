package com.mimi.FoodDelivery.repositories;

import com.mimi.FoodDelivery.entities.Orders;
import com.mimi.FoodDelivery.entities.ProductsList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersRepository extends JpaRepository<Orders,Long> {

    @Query("SELECT o FROM Orders o "+
            "WHERE (o.id) = :id ")
    Page<Orders> findOrderPage(Pageable pageable, Long id);
}
