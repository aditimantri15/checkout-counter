package com.retail.checkout.counter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    public void greet() throws Exception {
        String expectedResult = "You are at the Checkout Counter";

        MvcResult result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        String actualResult = result.getResponse().getContentAsString();
        assertNotNull(actualResult);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void greetMethodNotAllowed() throws Exception {
        mockMvc.perform(put("/"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void greetNotFound() throws Exception {
        mockMvc.perform(put("/greet"))
                .andExpect(status().isNotFound());
    }
}
