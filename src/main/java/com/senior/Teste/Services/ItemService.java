package com.senior.Teste.Services;

import com.senior.Teste.Models.Item;
import com.senior.Teste.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item createItem(Item item){
        return itemRepository.save(item);
    }

    public Item findItemById(UUID id){
        Optional<Item> item = itemRepository.findById(id);
        return item.orElseThrow();
    }

    public Item updateItem(Item item){
        return itemRepository.save(item);
    }

    public void deleteItemById(UUID id){
        itemRepository.deleteById(id);
    }

}
