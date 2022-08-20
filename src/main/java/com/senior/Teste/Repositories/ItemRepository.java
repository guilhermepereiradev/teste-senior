package com.senior.Teste.Repositories;

import com.senior.Teste.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ItemRepository  extends JpaRepository<Item, UUID> {
}
