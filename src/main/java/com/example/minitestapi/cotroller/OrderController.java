package com.example.minitestapi.cotroller;

import com.example.minitestapi.model.OrderDetail;
import com.example.minitestapi.model.Order;
import com.example.minitestapi.model.Product;
import com.example.minitestapi.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<Page<Order>> findAll(@PageableDefault(value = 4) Pageable pageable) {
        return new ResponseEntity<>(orderService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Order> create(@RequestBody Order orderr) {
        orderService.save(orderr);
        return new ResponseEntity<>(orderr, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order orderr) {
        Optional<Order> orderr1 = orderService.findById(id);
        if(!orderr1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderr.setId(orderr1.get().getId());
        orderService.save(orderr);
        return new ResponseEntity<>(orderr, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id) {
        orderService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<OrderDetail>> findDetail(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.findDetail(id), HttpStatus.OK);
    }
}