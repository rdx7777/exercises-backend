package io.github.rdx7777.exercisesbackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FibonacciServiceTest {

    @InjectMocks
    FibonacciService fibonacciService;

    @Test
    void shouldCheckFibonacciNumber() {
        assertTrue(fibonacciService.checkFibonacciNumber(1L));
        assertFalse(fibonacciService.checkFibonacciNumber(4L));
    }

    @Test
    void checkFibonacciNumberMethodShouldThrowExceptionForInvalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> fibonacciService.checkFibonacciNumber(null),
            "Number for check cannot be null.");
        assertThrows(IllegalArgumentException.class, () -> fibonacciService.checkFibonacciNumber(-1L),
            "Number for check cannot be lower than zero.");
        assertThrows(IllegalArgumentException.class, () -> fibonacciService.checkFibonacciNumber(2_000_000_001L),
            "Number out of supported range. The maximum supported number is 2,000,000,000.");
    }

    @Test
    void shouldGetFibonacciNumberInOrderUsingIterativeMethod() {
        assertEquals(5L, fibonacciService.getFibonacciNumberInOrderUsingIterativeMethod(5));
        assertEquals(55L, fibonacciService.getFibonacciNumberInOrderUsingIterativeMethod(10));
    }

    @Test
    void getFibonacciNumberInOrderUsingIterativeMethodShouldThrowExceptionForInvalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> fibonacciService.getFibonacciNumberInOrderUsingIterativeMethod(null),
            "Fibonacci number in order cannot be null.");
        assertThrows(IllegalArgumentException.class, () -> fibonacciService.getFibonacciNumberInOrderUsingIterativeMethod(-1),
            "Fibonacci number in order cannot be lower than zero.");
        assertThrows(IllegalArgumentException.class, () -> fibonacciService.getFibonacciNumberInOrderUsingIterativeMethod(51),
            "Fibonacci number in order cannot be greater than 50.");
    }

    @Test
    void shouldGetFibonacciNumberInOrderUsingRecursiveMethod() {
        assertEquals(5L, fibonacciService.getFibonacciNumberInOrderUsingRecursiveMethod(5));
        assertEquals(55L, fibonacciService.getFibonacciNumberInOrderUsingRecursiveMethod(10));
    }

    @Test
    void getFibonacciNumberInOrderUsingRecursiveMethodShouldThrowExceptionForInvalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> fibonacciService.getFibonacciNumberInOrderUsingRecursiveMethod(null),
            "Fibonacci number in order cannot be null.");
        assertThrows(IllegalArgumentException.class, () -> fibonacciService.getFibonacciNumberInOrderUsingRecursiveMethod(-1),
            "Fibonacci number in order cannot be lower than zero.");
        assertThrows(IllegalArgumentException.class, () -> fibonacciService.getFibonacciNumberInOrderUsingRecursiveMethod(51),
            "Fibonacci number in order cannot be greater than 50.");
    }
}
