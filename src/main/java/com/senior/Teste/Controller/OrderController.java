package com.senior.Teste.Controller;

import com.senior.Teste.Models.Order;
import com.senior.Teste.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@CrossOrigin
@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        order = orderService.createOrder(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("id").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }
}
