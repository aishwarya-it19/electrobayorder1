package com.example.electrobayorder1.service;

import com.example.electrobayorder1.entity.Order;

import java.util.ArrayList;
import java.util.Optional;

public interface OrderService {
    Order getOrder(String id);
    Order save(Order order);
//    void delete(String id);
    Optional<Order> findById(String id);
    ArrayList<Order> findByUserId(int userId);
}
