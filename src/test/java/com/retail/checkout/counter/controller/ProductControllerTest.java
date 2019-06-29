package com.retail.checkout.counter.controller;

import com.retail.checkout.counter.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.retail.checkout.counter.helper.ProductHelper.getProductList;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void getProducts() throws Exception {
        when(productService.getProducts()).thenReturn(getProductList());

        MvcResult result = mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andReturn();

        String actualResult = result.getResponse().getContentAsString();
        assertNotNull(actualResult);
    }

    @Test
    public void getProductsMethodNotAllowed() throws Exception {
        mockMvc.perform(put("/products"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void getProductsNotFound() throws Exception {
        mockMvc.perform(put("/product"))
                .andExpect(status().isNotFound());
    }
}
