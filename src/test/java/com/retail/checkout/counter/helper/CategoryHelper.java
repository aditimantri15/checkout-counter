package com.retail.checkout.counter.helper;

import com.retail.checkout.counter.entity.CategoryEntity;
import com.retail.checkout.counter.model.Category;
import org.assertj.core.util.Lists;

import java.sql.Timestamp;
import java.util.List;

public class CategoryHelper {

    private static final Long ID = 1L;

    private static final String CATEGORY_NAME = "category-A";

    private static final Double TAX_PERCENT = 10d;

    private static final Timestamp TIMESTAMP = new Timestamp(System.currentTimeMillis());

    public static List<Category> getCategoryList() {
        return Lists.newArrayList(new Category(ID, CATEGORY_NAME, TAX_PERCENT));
    }

    public static List<CategoryEntity> getCategoryEntityList() {
        return Lists.newArrayList(getCategoryEntity());
    }

    public static CategoryEntity getCategoryEntity() {
        return new CategoryEntity(ID, CATEGORY_NAME, TAX_PERCENT, TIMESTAMP, TIMESTAMP);
    }
}
