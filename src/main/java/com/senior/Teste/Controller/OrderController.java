package com.senior.Teste.Controller;

import com.senior.Teste.Models.Order;
import com.senior.Teste.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Controller
@CrossOrigin
@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        order.setTotalValue(0.0);
        order = orderService.createOrder(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("id").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable UUID id){
        Order order = orderService.findOrderById(id);
        return ResponseEntity.ok().body(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable UUID id, @RequestBody Order order){
        Order oldOrder = orderService.findOrderById(id);
        order.setId(oldOrder.getId());
        orderService.updateOrder(order);
        return ResponseEntity.ok().body(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable UUID id){
        orderService.deleteOrderById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public List<Order> listAllOrders(){
        return orderService.listAllOrders();
    }
}
