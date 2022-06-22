package com.example.minitestapi.repository;

import com.example.minitestapi.model.OrderDetail;
import com.example.minitestapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "from OrderDetail where order.id = :id")
    Iterable<OrderDetail> findDetailByOrderId(@Param("id") Long id);
}