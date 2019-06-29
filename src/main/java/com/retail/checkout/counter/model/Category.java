package com.retail.checkout.counter.model;

import com.retail.checkout.counter.entity.CategoryEntity;
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
public class Category implements Serializable {

    private static final long serialVersionUID = 955380842243771073L;

    private Long id;

    private String categoryName;

    private Double taxPercent;

    public Category(CategoryEntity categoryEntity) {
        this.id = categoryEntity.getId();
        this.categoryName = categoryEntity.getCategoryName();
        this.taxPercent = categoryEntity.getTaxPercent();
    }
}
