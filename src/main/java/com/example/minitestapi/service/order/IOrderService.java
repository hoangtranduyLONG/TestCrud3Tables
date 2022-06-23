package com.example.minitestapi.service.order;

import com.example.minitestapi.model.Order;
import com.example.minitestapi.service.GeneralService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService extends GeneralService<Order> {

    List<Order> findAllByCreateAtBetween(LocalDateTime from, LocalDateTime to);
    Iterable<Object[]> reportByCreateTime(LocalDate from, LocalDate to);
}