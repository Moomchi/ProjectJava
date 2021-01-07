package com.mimi.FoodDelivery.repositories;

import com.mimi.FoodDelivery.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {

}
