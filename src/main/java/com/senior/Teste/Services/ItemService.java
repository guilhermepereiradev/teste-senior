package com.senior.Teste.Services;

import com.senior.Teste.Models.Item;
import com.senior.Teste.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item createItem(Item item){
        return itemRepository.save(item);
    }
}
