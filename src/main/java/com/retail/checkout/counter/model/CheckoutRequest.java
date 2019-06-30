package com.retail.checkout.counter.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class CheckoutRequest {

    @Valid
    @NotEmpty(message = "checkoutProducts can not be null or empty")
    List<CheckoutProduct> checkoutProducts;
}
