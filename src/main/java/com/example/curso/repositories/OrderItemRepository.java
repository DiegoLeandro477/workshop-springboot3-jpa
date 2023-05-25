package com.example.curso.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curso.entities.OrderItem;
import com.example.curso.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}