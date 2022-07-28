package com.example.electrobayorder1.controller;

import com.example.electrobayorder1.dto.OrderDto;
import com.example.electrobayorder1.entity.Order;
import com.example.electrobayorder1.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/order")


public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/{id}")
    public Optional<OrderDto> findById(@PathVariable("id") String id){
        Optional<Order> optionalOrder = orderService.findById(id);
        OrderDto orderDto=null;
        if(optionalOrder.isPresent()){
            orderDto = new OrderDto();
            BeanUtils.copyProperties(optionalOrder.get(),orderDto);
        }
        return Optional.ofNullable(orderDto);
    }

    @PostMapping
    public OrderDto save(@RequestBody OrderDto orderDto){
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        Order returnOrder = orderService.save(order);
        OrderDto returnDto = new OrderDto();
        BeanUtils.copyProperties(returnOrder, returnDto);
        return returnDto;
    }
//
//    @GetMapping(value = "/user/{userId}")
//    public ArrayList<OrderDto> findByUserId(@PathVariable("userId") int userId){
//        ArrayList<Order> optionalOrder = orderService.findByUserId(userId);
////        OrderDto orderDto=null;
////        if(optionalOrder.isPresent()){
////            orderDto = new OrderDto();
////            BeanUtils.copyProperties(optionalOrder.get(),orderDto);
////        }
//        return OrderService;
   // }
//    @DeleteMapping(value = "/{id}")
//    public void delete(@PathVariable("id") String id){
//        orderService.delete(id);
//    }
@GetMapping(value = "/user/{userId}")
public ArrayList<OrderDto> findByUserId(@PathVariable("userId") Integer userId){
    ArrayList<Order> listOrders = orderService.findByUserId(userId);
    ArrayList<OrderDto> orderDtos=new ArrayList<>();
    for(Order order:listOrders){
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order, orderDto);
        orderDto.setUserId(order.getUserId());
        orderDto.setMerchantId(order.getMerchantId());
        orderDto.setProductId(order.getProductId());
        orderDtos.add(orderDto);
    }

    return orderDtos;
}
}

