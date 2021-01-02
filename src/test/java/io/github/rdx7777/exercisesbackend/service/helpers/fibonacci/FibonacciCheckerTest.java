package io.github.rdx7777.exercisesbackend.service.helpers.fibonacci;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.rdx7777.exercisesbackend.service.helpers.fibonacci.FibonacciChecker;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FibonacciCheckerTest {

    @ParameterizedTest
    @ValueSource(longs = {13, 3, 5, 8, 2, 21, 987, 1597, 6765})
    void shouldReturnTrueForFibonacciNumber(long number) {
        assertTrue(FibonacciChecker.isFibonacciNumber(number));
    }

    @ParameterizedTest
    @ValueSource(longs = {4, 15, 19, 40, 99, 300, 6400, 12111, 1999999999})
    void shouldReturnFalseForNonFibonacciNumber(long number) {
        assertFalse(FibonacciChecker.isFibonacciNumber(number));
    }

    @ParameterizedTest
    @ValueSource(longs = {-10, -1, 2000000999})
    void shouldThrowExceptionForInvalidArgument(long number) {
        assertThatThrownBy(() -> FibonacciChecker.isFibonacciNumber(number)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
