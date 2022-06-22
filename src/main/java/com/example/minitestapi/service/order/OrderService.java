package com.example.minitestapi.service.order;

import com.example.minitestapi.model.OrderDetail;
import com.example.minitestapi.model.Order;
import com.example.minitestapi.service.GenaralService;

public interface OrderService extends GenaralService<Order> {
    Iterable<OrderDetail> findDetail (Long id);
}