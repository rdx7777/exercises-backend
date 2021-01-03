package io.github.rdx7777.exercisesbackend.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.github.rdx7777.exercisesbackend.service.FibonacciService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FibonacciController.class)
class FibonacciControllerTest {

    @MockBean
    private FibonacciService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCheckFibonacciNumber() throws Exception {
        Long number = 21L;
        when(service.checkFibonacciNumber(number)).thenReturn(true);

        String url = String.format("/api/fibonacci/check/%d", number);

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(String.valueOf(true)));

        verify(service).checkFibonacciNumber(number);
    }

    @Test
    void shouldGetFibonacciNumberInOrderUsingIterativeMethod() throws Exception {
        Integer number = 10;
        Long result = 55L;
        when(service.getFibonacciNumberInOrderUsingIterativeMethod(number)).thenReturn(result);

        String url = String.format("/api/fibonacci/get/iterative/%d", number);

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(String.valueOf(result)));

        verify(service).getFibonacciNumberInOrderUsingIterativeMethod(number);
    }

    @Test
    void shouldGetFibonacciNumberInOrderUsingRecursiveMethod() throws Exception {
        Integer number = 11;
        Long result = 89L;
        when(service.getFibonacciNumberInOrderUsingRecursiveMethod(number)).thenReturn(result);

        String url = String.format("/api/fibonacci/get/recursive/%d", number);

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(String.valueOf(result)));

        verify(service).getFibonacciNumberInOrderUsingRecursiveMethod(number);
    }
}
