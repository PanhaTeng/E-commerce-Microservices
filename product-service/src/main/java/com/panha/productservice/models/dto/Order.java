package com.panha.productservice.models.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private Integer userId;
    private Double totalAmount;
    private String status;
    private Boolean isActive;
}
