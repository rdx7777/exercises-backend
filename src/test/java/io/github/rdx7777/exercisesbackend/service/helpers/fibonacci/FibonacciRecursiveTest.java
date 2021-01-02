package io.github.rdx7777.exercisesbackend.service.helpers.fibonacci;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class FibonacciRecursiveTest {

    @ParameterizedTest
    @MethodSource("fibonacciArguments")
    void shouldReturnCorrectValue(int fibonacciNumberInOrder, long expected) {
        assertThat(FibonacciRecursive.fibonacci(fibonacciNumberInOrder)).isEqualTo(expected);
    }

    static Stream<Arguments> fibonacciArguments() {
        return Stream.of(
            Arguments.of(0, 0L),
            Arguments.of(1, 1L),
            Arguments.of(2, 1L),
            Arguments.of(5, 5L),
            Arguments.of(10, 55L),
            Arguments.of(19, 4181L)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -20, -123})
    void shouldThrowExceptionForInvalidArgument(int fibonacciNumberInOrder) {
        assertThrows(IllegalArgumentException.class, () -> FibonacciRecursive.fibonacci(fibonacciNumberInOrder));
    }
}
