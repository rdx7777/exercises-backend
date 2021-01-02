package io.github.rdx7777.exercisesbackend.service.helpers.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class SortingTestBase {

    public abstract SortingMethod getSortingMethod();

    @Test
    public void shouldSortSimpleArray() {
        // given
        int[] given = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        System.out.println("Sorting by: " + getSortingMethod().getClass());

        // when
        long startTime = System.nanoTime();
        int[] result = getSortingMethod().sort(given);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        // then
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("shouldSortArguments")
    void shouldSort(int[] input, int[] expected) {
        assertArrayEquals(getSortingMethod().sort(input), expected);
    }

    static Stream<Arguments> shouldSortArguments() {
        return Stream.of(
            Arguments.of(new int[]{}, new int[]{}),
            Arguments.of(new int[]{1}, new int[]{1}),
            Arguments.of(new int[]{5, 5, 5, 5, 5, 5, 5}, new int[]{5, 5, 5, 5, 5, 5, 5}),
            Arguments.of(new int[]{1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}, new int[]{1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}),
            Arguments.of(new int[]{3, 99, 2, 56, 43, 15, -2, 11, 10, 1, 12, 8}, new int[]{-2, 1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}),
            Arguments.of(new int[]{99, 56, 43, 15, 12, 11, 10, 8, 3, 2, 1}, new int[]{1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}),
            Arguments.of(new int[]{1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}, new int[]{1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}),
            Arguments.of(new int[]{3, 0, -2, 99, 2, 1, 3, 56, 43, 15, 12, 11, 10, -11, 43, 1, 12, 8, -3, -2}, new int[]{-11, -3, -2, -2, 0, 1, 1, 2, 3, 3, 8, 10, 11, 12, 12, 15, 43, 43, 56, 99})
        );
    }

    @Test
    void shouldThrowExceptionForNullAsArray() {
        assertThrows(IllegalArgumentException.class, () -> getSortingMethod().sort(null));
    }
}
