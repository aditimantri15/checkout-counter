package com.retail.checkout.counter.service.impl;

import com.retail.checkout.counter.dao.CategoryDao;
import com.retail.checkout.counter.model.Category;
import com.retail.checkout.counter.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categoryDao.findAll().forEach(categoryEntity -> categories.add(new Category(categoryEntity)));
        return categories;
    }
}
