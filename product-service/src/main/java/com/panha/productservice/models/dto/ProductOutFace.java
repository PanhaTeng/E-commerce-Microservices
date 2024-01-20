package com.panha.productservice.models.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOutFace {
    private Integer id;
    private String name;
    private Double price;
    private Boolean isActive;
    private Integer orderId;
    private Order order;
}
