package com.senior.Teste.Services;

import com.senior.Teste.Models.Order;
import com.senior.Teste.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }
}
