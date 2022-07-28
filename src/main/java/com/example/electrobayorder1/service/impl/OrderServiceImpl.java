package com.example.electrobayorder1.service.impl;

import com.example.electrobayorder1.entity.Order;
import com.example.electrobayorder1.repository.OrderRepository;
import com.example.electrobayorder1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order getOrder(String id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.isPresent() ? optionalOrder.get() : null;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

//    @Override
//    public void delete(String id) {
//         orderRepository.deleteById(id);
//    }

    @Override
    public Optional<Order> findById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public ArrayList<Order> findByUserId(int userId) {
        return orderRepository.findByUserId(userId);
    }

//    @Override
//    public Optional<Order> deleteById(String id) {
//        return orderRepository.deleteById(id);
//    }
}

