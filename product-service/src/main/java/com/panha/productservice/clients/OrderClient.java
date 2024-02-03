package com.panha.productservice.clients;

import com.panha.productservice.models.dto.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORDER-SERVICE", url = "${application.config.order-url}")
public interface OrderClient {
    @GetMapping("/{order-id}")
    Order findById(@PathVariable("order-id") Integer id);
}
