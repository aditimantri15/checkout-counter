package com.retail.checkout.counter.controller;

import com.retail.checkout.counter.service.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.retail.checkout.counter.helper.CategoryHelper.getCategoryList;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void getCategories() throws Exception {
        when(categoryService.getCategories()).thenReturn(getCategoryList());

        MvcResult result = mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andReturn();

        String actualResult = result.getResponse().getContentAsString();
        assertNotNull(actualResult);
    }

    @Test
    public void getCategoriesMethodNotAllowed() throws Exception {
        mockMvc.perform(put("/categories"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void getCategoriesNotFound() throws Exception {
        mockMvc.perform(put("/category"))
                .andExpect(status().isNotFound());
    }
}
