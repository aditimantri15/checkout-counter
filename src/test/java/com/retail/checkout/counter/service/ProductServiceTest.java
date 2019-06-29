package com.retail.checkout.counter.service;

import com.retail.checkout.counter.dao.ProductDao;
import com.retail.checkout.counter.model.Product;
import com.retail.checkout.counter.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.retail.checkout.counter.helper.ProductHelper.getProductEntityList;
import static com.retail.checkout.counter.helper.ProductHelper.getProductList;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductDao productDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProducts() throws Exception {
        when(productDao.findAll()).thenReturn(getProductEntityList());
        List<Product> products = productService.getProducts();
        assertNotNull(products);
        assertEquals(products, getProductList());
    }
}
