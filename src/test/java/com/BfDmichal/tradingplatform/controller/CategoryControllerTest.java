package com.BfDmichal.tradingplatform.controller;

import com.BfDmichal.tradingplatform.domain.dto.CategoryDto;
import org.junit.Test;
import org.springframework.test.context.junit.jupiter.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
@RunWith(SpringRunner.class)
public class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CategoryController categoryController;

    @Test
    public void shouldFetchEmptyList() throws Exception{
        //Given
        List<CategoryDto> categoryDtos = new ArrayList<>();
        when(categoryController.getAllCategories()).thenReturn(categoryDtos);
        //When & Then
        mockMvc.perform(get("/v1/getCategories").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$",hasSize(0)));
    }
}
