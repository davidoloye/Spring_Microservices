package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @org.springframework.data.annotation.Id
    private String Id;
    private String name;
    private String description;
    private BigDecimal price;
}
