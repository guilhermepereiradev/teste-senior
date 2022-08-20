package com.senior.Teste.Controller;

import com.senior.Teste.Models.Item;
import com.senior.Teste.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
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
    public ResponseEntity<Item> findItemById(@PathVariable UUID id){
        Item item = itemService.findItemById(id);
        return ResponseEntity.ok().body(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item, @PathVariable UUID id){
        item.setId(id);
        itemService.updateItem(item);
        return ResponseEntity.ok().body(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable UUID id){
        itemService.deleteItemById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public List<Item> findAllItems(){
        return itemService.findAllItems();
    }
}
