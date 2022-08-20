package com.senior.Teste.Controller;

import com.senior.Teste.Models.Item;
import com.senior.Teste.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping()
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        item = itemService.createItem(item);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("id").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findById(@PathVariable UUID id){
        Item item = itemService.findById(id);
        return ResponseEntity.ok().body(item);
    }

}
