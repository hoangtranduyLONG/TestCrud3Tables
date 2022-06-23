package com.example.minitestapi.cotroller;



import com.example.minitestapi.model.Order;
import com.example.minitestapi.model.OrderDetail;
import com.example.minitestapi.model.Product;

import com.example.minitestapi.service.order.IOrderService;
import com.example.minitestapi.service.order_detail.IOrderDetailService;
import com.example.minitestapi.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order-details")
public class OrderDetailController {

    @Autowired
    IOrderDetailService orderDetailService;
    @Autowired
    IProductService productService;
    @Autowired
    IOrderService orderService;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(orderDetailService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody OrderDetail orderDetail) {
        Product product = productService.findById(orderDetail.getProduct().getId()).get();
        Order order = orderService.findById(orderDetail.getOrder().getId()).get();
        product.setQuantity(product.getQuantity() - orderDetail.getQuantity());
        productService.save(product);
        order.setTotalPrice(order.getTotalPrice() + product.getQuantity() * product.getPrice());
        orderService.save(order);
        return new ResponseEntity(orderDetailService.save(orderDetail), HttpStatus.CREATED);
    }
}