package ru.geekbrains.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.shop.persistence.entities.enums.ProductCategory;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String title;
    private String description;
    private Double price;
    private boolean available;
    private ProductCategory category;
}