package com.senior.Teste.Services;

import com.senior.Teste.Models.Item;
import com.senior.Teste.Models.Order;
import com.senior.Teste.Models.OrderItems;
import com.senior.Teste.Repositories.ItemRepository;
import com.senior.Teste.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public Order findOrderById(UUID id){
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow();
    }

    public Order updateOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrderById(UUID id){
        orderRepository.deleteById(id);
    }

    public List<Order> listAllOrders(){
        return orderRepository.findAll();
    }

    public Order closeOrder(Order order){
        return orderRepository.save(order);
    }
}
