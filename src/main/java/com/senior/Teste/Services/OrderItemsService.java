package com.senior.Teste.Services;

import com.senior.Teste.Models.Item;
import com.senior.Teste.Models.Order;
import com.senior.Teste.Models.OrderItems;
import com.senior.Teste.Repositories.ItemRepository;
import com.senior.Teste.Repositories.OrderItemsRepository;
import com.senior.Teste.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemsService {

    @Autowired
    OrderItemsRepository orderItemsRepository;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    public OrderItems createOrdemItems(OrderItems orderItems, UUID id){
        Optional<Order> order = orderRepository.findById(id);
        Optional<Item> item = itemRepository.findById(orderItems.getItemId());

        orderItems.setOrder(order.get());
        orderItems.setItemId(item.get().getId());
        orderItems.calcTotalValue(item.get().getValue());
        orderItems.setTotalValue(item.get().getValue() * orderItems.getQuantity());

        return orderItemsRepository.save(orderItems);
    }

    public OrderItems findOrderItems(UUID orderId, UUID id){
        Optional<OrderItems> orderItems = orderItemsRepository.findOrdemItem(orderId, id);
        return orderItems.orElseThrow();
    }

    public OrderItems updateOrdemItems(OrderItems orderItems){
        Optional<Item> item = itemRepository.findById(orderItems.getItemId());
        orderItems.calcTotalValue(item.get().getValue());
        return orderItemsRepository.save(orderItems);
    }

    public void deleteOrdemItem(OrderItems orderItems){
        orderItemsRepository.delete(orderItems);
    }

    public List<OrderItems> listAllOrderItems(UUID orderId){
        return orderItemsRepository.lisAllOrderItems(orderId);
    }
}
