package io.github.rdx7777.exercisesbackend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SieveServiceTest {

    @InjectMocks
    SieveService sieveService;

    @Test
    void shouldSieve() {
        // given
        Integer[] arrayFor100 = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        Integer[] arrayFor40 = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        Integer[] arrayFor1 = new Integer[0];
        Integer[] arrayForNegativeNumber = new Integer[0];

        // then
        assertThat(sieveService.getSieve(100)).isEqualTo(arrayFor100);
        assertThat(sieveService.getSieve(40)).isEqualTo(arrayFor40);
        assertThat(sieveService.getSieve(1)).isEqualTo(arrayFor1);
        assertThat(sieveService.getSieve(-10)).isEqualTo(arrayForNegativeNumber);
    }

    @Test
    void getSieveMethodShouldThrowExceptionForInvalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> sieveService.getSieve(null),
            "Maximum number cannot be null.");
        assertThrows(IllegalArgumentException.class, () -> sieveService.getSieve(1_000_000),
            "Maximum number out of supported range. The maximum supported number is 100,000.");
    }
}
