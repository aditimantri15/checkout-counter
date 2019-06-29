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
public class BilledProduct implements Serializable {

    private static final long serialVersionUID = -6185794662993063710L;

    private Long id;

    private String productName;

    private Double price;

    private String category;

    private int quantity;

    private Double taxPercent;

    private Double total;

    private Double totalTax;

    public BilledProduct(ProductEntity productEntity, CheckoutProduct checkoutProduct) {
        this.id = productEntity.getId();
        this.productName = productEntity.getProductName();
        this.price = productEntity.getPrice();
        this.category = productEntity.getProductCategory().getCategoryName();
        this.quantity = checkoutProduct.getQuantity();
        this.taxPercent = productEntity.getProductCategory().getTaxPercent();
        this.total = productEntity.getPrice() * checkoutProduct.getQuantity();
        this.totalTax = total * productEntity.getProductCategory().getTaxPercent() / 100;
    }
}
