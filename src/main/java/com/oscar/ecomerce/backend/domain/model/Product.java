package com.oscar.ecomerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private String code;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String image;
    private Integer categoryId;
    private Integer userId;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
