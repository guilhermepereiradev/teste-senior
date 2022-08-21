package com.senior.Teste.Repositories;

import com.senior.Teste.Models.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, UUID> {

    @Query(value = "SELECT * FROM order_items WHERE id_order =:orderId AND id=:id", nativeQuery = true)
    Optional<OrderItems> findOrdemItem(UUID orderId, UUID id);

    @Query(value="SELECT * FROM order_items WHERE id_order=:orderId", nativeQuery = true)
    List<OrderItems> lisAllOrderItems(UUID orderId);
}
