package com.retail.checkout.counter.service;

import com.retail.checkout.counter.dao.ProductDao;
import com.retail.checkout.counter.exception.BadRequestException;
import com.retail.checkout.counter.model.Bill;
import com.retail.checkout.counter.model.Product;
import com.retail.checkout.counter.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static com.retail.checkout.counter.helper.ProductHelper.getBill;
import static com.retail.checkout.counter.helper.ProductHelper.getCheckoutRequest;
import static com.retail.checkout.counter.helper.ProductHelper.getProductEntityList;
import static com.retail.checkout.counter.helper.ProductHelper.getProductList;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
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
    public void getProducts() {
        when(productDao.findAll()).thenReturn(getProductEntityList());

        List<Product> products = productService.getProducts();

        assertNotNull(products);
        assertEquals(products, getProductList());
        verify(productDao, times(1)).findAll();
        verifyNoMoreInteractions(productDao);
    }

    @Test
    public void generateBill() {
        when(productDao.getAllByIdIn(anySet())).thenReturn(getProductEntityList());

        Bill bill = productService.generateBill(getCheckoutRequest());

        assertNotNull(bill);
        assertEquals(bill, getBill());
        verify(productDao, times(1)).getAllByIdIn(anySet());
        verifyNoMoreInteractions(productDao);
    }

    @Test(expected = BadRequestException.class)
    public void generateBillThrowsBadRequestException() {
        when(productDao.getAllByIdIn(anySet())).thenReturn(new ArrayList<>());

        productService.generateBill(getCheckoutRequest());

        verify(productDao, times(1)).getAllByIdIn(anySet());
        verifyNoMoreInteractions(productDao);
    }
}
