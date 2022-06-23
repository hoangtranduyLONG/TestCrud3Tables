package com.example.minitestapi.cotroller;

import com.example.minitestapi.model.Order;

import com.example.minitestapi.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity( orderService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Order order) {
        return new ResponseEntity( orderService.save(order), HttpStatus.CREATED);
    }

    @GetMapping("/find-all-create-at-between")
    public ResponseEntity findAllByCreateAtBetween(@RequestParam String from,@RequestParam String to) {
        return new ResponseEntity(orderService.findAllByCreateAtBetween(LocalDateTime.parse(from), LocalDateTime.parse(to)), HttpStatus.OK);
    }
    @GetMapping("/find-product-sell-between")
    public ResponseEntity findAllProductSellBetween(@RequestParam String from,@RequestParam String to) {
        return new ResponseEntity(orderService.reportByCreateTime(LocalDate.parse(from), LocalDate.parse(to)), HttpStatus.OK);
    }
}