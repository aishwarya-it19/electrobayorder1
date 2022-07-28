package com.example.electrobayorder1.repository;

import com.example.electrobayorder1.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    ArrayList<Order> findByUserId(int userId);
}
