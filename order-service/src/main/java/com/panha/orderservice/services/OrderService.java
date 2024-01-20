package com.panha.orderservice.services;

import com.panha.orderservice.models.Order;
import com.panha.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    //crud
    public Order save(Order order){
        return orderRepository.save(order);
    }
    public Order findById(Integer id){
        return orderRepository.findById(id).orElse(null);
    }
    public List<Order> list(){
        return orderRepository.findAll();
    }
    public Order update(Order order){
        var orderInDb = orderRepository.findById(order.getId()).orElse(null);
        orderInDb.setId(order.getId());
        orderInDb.setUserId(order.getUserId());
        orderInDb.setTotalAmount(order.getTotalAmount());
        orderInDb.setStatus(order.getStatus());
        orderInDb.setIsActive(order.getIsActive());
        return orderRepository.save(orderInDb);
    }
    public Order delete(Order order){
        orderRepository.deleteById(order.getId());
        return order;
    }

}
