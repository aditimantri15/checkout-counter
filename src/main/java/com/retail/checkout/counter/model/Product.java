package com.retail.checkout.counter.model;

import com.retail.checkout.counter.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product implements Serializable {

    private static final long serialVersionUID = -5684274730265510843L;

    private Long id;

    private String productName;

    private Double price;

    private String category;

    public Product(ProductEntity productEntity) {
        this.id = productEntity.getId();
        this.productName = productEntity.getProductName();
        this.price = productEntity.getPrice();
        this.category = productEntity.getProductCategory().getCategoryName();
    }
}
