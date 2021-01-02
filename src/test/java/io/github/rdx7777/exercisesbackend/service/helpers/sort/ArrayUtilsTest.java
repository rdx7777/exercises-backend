package io.github.rdx7777.exercisesbackend.service.helpers.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ArrayUtilsTest {

    @ParameterizedTest
    @MethodSource("swapElementsArguments")
    void shouldSwapElementsInArray(int[] input, int indexOfFirstElement, int indexOfSecondElement, int[] expected) {
        ArrayUtils.swapElementsInArray(input, indexOfFirstElement, indexOfSecondElement);
        assertArrayEquals(input, expected);
    }

    static Stream<Arguments> swapElementsArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, 3, new int[]{1, 2, 4, 3, 5}),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 0, 4, new int[]{5, 2, 3, 4, 1}),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, 2, new int[]{1, 2, 3, 4, 5}),
            Arguments.of(new int[]{1, 3, 3, 3, 3, 3, 4, 7, 6, 10}, 1, 2, new int[]{1, 3, 3, 3, 3, 3, 4, 7, 6, 10}),
            Arguments.of(new int[]{0, 0, 0, 0, 0, 0}, 0, 5, new int[]{0, 0, 0, 0, 0, 0})
        );
    }

    @Test
    void shouldThrowExceptionForNullAsArray() {
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.swapElementsInArray(null, 1, 2));
    }

    @ParameterizedTest
    @MethodSource("invalidIndexOfFirstElementArguments")
    void shouldThrowExceptionForInvalidIndexOfFirstElement(int[] input, int indexOfFirstElement, int indexOfSecondElement) {
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.swapElementsInArray(input, indexOfFirstElement, indexOfSecondElement));
    }

    static Stream<Arguments> invalidIndexOfFirstElementArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, -1, 3),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 6, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidIndexOfSecondElementArguments")
    void shouldThrowExceptionForInvalidIndexOfSecondElement(int[] input, int indexOfFirstElement, int indexOfSecondElement) {
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.swapElementsInArray(input, indexOfFirstElement, indexOfSecondElement));
    }

    static Stream<Arguments> invalidIndexOfSecondElementArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 1, -1),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 1, 7)
        );
    }
}
