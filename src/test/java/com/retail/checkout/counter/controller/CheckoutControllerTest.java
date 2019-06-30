package com.retail.checkout.counter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.checkout.counter.model.Bill;
import com.retail.checkout.counter.model.CheckoutRequest;
import com.retail.checkout.counter.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.retail.checkout.counter.helper.ProductHelper.getCheckoutRequest;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CheckoutControllerTest {

    @InjectMocks
    private CheckoutController checkoutController;

    @Mock
    private ProductService productService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(checkoutController).build();
    }

    @Test
    public void generateBill() throws Exception {
        when(productService.generateBill(any(CheckoutRequest.class))).thenReturn(new Bill());

        String inputJson = new ObjectMapper().writeValueAsString(getCheckoutRequest());
        MvcResult mvcResult = mockMvc.perform(post("/checkout")
                .contentType(MediaType.APPLICATION_JSON).content(inputJson))
                .andExpect(status().isOk())
                .andReturn();


        String actualResult = mvcResult.getResponse().getContentAsString();

        assertNotNull(actualResult);
        verify(productService, times(1)).generateBill(any());
        verifyNoMoreInteractions(productService);
    }

    @Test
    public void getCategoriesBadRequest() throws Exception {
        String inputJson = new ObjectMapper().writeValueAsString(new CheckoutRequest());

        mockMvc.perform(post("/checkout")
                .contentType(MediaType.APPLICATION_JSON).content(inputJson))
                .andExpect(status().isBadRequest());

        verify(productService, times(0)).generateBill(any());
    }

    @Test
    public void getCategoriesMethodNotAllowed() throws Exception {
        String inputJson = new ObjectMapper().writeValueAsString(getCheckoutRequest());

        mockMvc.perform(put("/checkout")
                .contentType(MediaType.APPLICATION_JSON).content(inputJson))
                .andExpect(status().isMethodNotAllowed());

        verify(productService, times(0)).generateBill(any());
    }

    @Test
    public void getCategoriesNotFound() throws Exception {
        String inputJson = new ObjectMapper().writeValueAsString(getCheckoutRequest());

        mockMvc.perform(post("/checkouts")
                .contentType(MediaType.APPLICATION_JSON).content(inputJson))
                .andExpect(status().isNotFound());

        verify(productService, times(0)).generateBill(any());
    }
}
