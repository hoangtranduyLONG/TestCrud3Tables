package com.example.minitestapi.service.order;

import com.example.minitestapi.model.Order;
import com.example.minitestapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(Order object) {
        return orderRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAllByCreateAtBetween(LocalDateTime from, LocalDateTime to){
        return orderRepository.findAllByCreateAtBetween(from, to);
    }


    public Iterable<Object[]> reportByCreateTime(LocalDate from, LocalDate to) {
        return orderRepository.reportByCreateTime(from, to);
    }
}
