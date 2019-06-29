package com.retail.checkout.counter.service;

import com.retail.checkout.counter.dao.CategoryDao;
import com.retail.checkout.counter.model.Category;
import com.retail.checkout.counter.service.impl.CategoryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.retail.checkout.counter.helper.CategoryHelper.getCategoryEntityList;
import static com.retail.checkout.counter.helper.CategoryHelper.getCategoryList;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryDao categoryDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCategories() throws Exception {
        when(categoryDao.findAll()).thenReturn(getCategoryEntityList());
        List<Category> categories = categoryService.getCategories();
        assertNotNull(categories);
        assertEquals(categories, getCategoryList());
    }
}
