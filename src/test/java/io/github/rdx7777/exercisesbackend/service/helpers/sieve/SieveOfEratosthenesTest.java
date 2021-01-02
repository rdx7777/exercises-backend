package io.github.rdx7777.exercisesbackend.service.helpers.sieve;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SieveOfEratosthenesTest {

    @ParameterizedTest
    @MethodSource("sieveArguments")
    void shouldSieve(int maximumNumber, int[] expected) {
        assertThat(SieveOfEratosthenes.sieve(maximumNumber)).isEqualTo(expected);
    }

    static Stream<Arguments> sieveArguments() {
        return Stream.of(
            Arguments.of(-5, new int[0]),
            Arguments.of(1, new int[0]),
            Arguments.of(100, new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97})
        );
    }
}
