package com.senior.Teste.Controller;

import com.senior.Teste.Models.Order;
import com.senior.Teste.Models.OrderItems;
import com.senior.Teste.Services.OrderItemsService;
import com.senior.Teste.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@CrossOrigin
@RestController
@RequestMapping("api/orders")
public class OrderItemsController {

    @Autowired
    OrderItemsService orderItemsService;


    @PostMapping("/{id}/items")
    public ResponseEntity<OrderItems> createOrderItems(@RequestBody OrderItems orderItems, @PathVariable UUID id){
        orderItems = orderItemsService.createOrdemItems(orderItems, id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("id").buildAndExpand(orderItems.getId()).toUri();
        return ResponseEntity.created(uri).body(orderItems);
    }

    @GetMapping("/{orderId}/items/{id}")
    public ResponseEntity<OrderItems> findOrderItems(@PathVariable UUID orderId, @PathVariable UUID id){
        OrderItems orderItems = orderItemsService.findOrderItems(orderId, id);
        return ResponseEntity.ok().body(orderItems);
    }

    @PutMapping("/{orderId}/items/{id}")
    public ResponseEntity<OrderItems> updateOrderItems(@PathVariable UUID orderId, @PathVariable UUID id, @RequestBody OrderItems orderItems){
        OrderItems oldOrderItems = orderItemsService.findOrderItems(orderId, id);
        orderItems.setId(oldOrderItems.getId());
        orderItems.setOrder(oldOrderItems.getOrder());
        orderItemsService.updateOrdemItems(orderItems);
        return ResponseEntity.ok().body(orderItems);
    }

    @DeleteMapping("/{orderId}/items/{id}")
    public ResponseEntity<Void> deleteOrdemItem(@PathVariable UUID orderId, @PathVariable UUID id){
        OrderItems orderItems = orderItemsService.findOrderItems(orderId, id);
        orderItemsService.deleteOrdemItem(orderItems);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderId}/items")
    public List<OrderItems> listAllOrderItems(@PathVariable UUID orderId){
        return orderItemsService.listAllOrderItems(orderId);
    }
}
