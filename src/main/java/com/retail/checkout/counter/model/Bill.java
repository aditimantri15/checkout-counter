package com.retail.checkout.counter.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Bill implements Serializable {

    private static final long serialVersionUID = -9835687935852759L;

    private List<BilledProduct> products;

    private Double totalPrice;

    private Double totalTax;

    private Double totalAmount;

    public Bill(List<BilledProduct> products, Double totalPrice, Double totalTax) {
        this.products = products;
        this.totalPrice = totalPrice;
        this.totalTax = totalTax;
        this.totalAmount = totalPrice + totalTax;
    }
}
