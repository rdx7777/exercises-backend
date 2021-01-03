package io.github.rdx7777.exercisesbackend.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.rdx7777.exercisesbackend.service.SortService;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SortController.class)
class SortControllerTest {

    @MockBean
    private SortService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldGetAllResults() throws Exception {
        Integer size = 10;
        Integer[] unsortedArray = new Integer[]{0, 7, 5, 1, 4, 2, 3, 6, 9, 8};
        Integer[] sortedArray = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Map<Long, Integer[]> results = new LinkedHashMap<>();
        results.put(1L, sortedArray);
        results.put(2L, sortedArray);
        results.put(3L, sortedArray);
        results.put(4L, sortedArray);
        results.put(5L, sortedArray);

        when(service.getAllResults(size)).thenReturn(results);

        String url = String.format("/api/sort/%d", size);

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json(mapper.writeValueAsString(results)));

        verify(service).getAllResults(size);
    }
}
