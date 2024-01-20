package com.panha.orderservice.controllers;

import com.panha.orderservice.models.Order;
import com.panha.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/{id}")
    public Order findById(@PathVariable Integer id){
        return orderService.findById(id);
    }
    @GetMapping
    public List<Order> list(){
        return orderService.list();
    }
    @PostMapping
    public Order createProduct(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping
    public Order updateProduct( @RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping
    public Order deleteProduct(@RequestBody Order order) {
        return orderService.delete(order);
    }


}
