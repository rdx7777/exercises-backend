package io.github.rdx7777.exercisesbackend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SortServiceTest {

    @InjectMocks
    SortService sortService;

    @Test
    void shouldGetAllResults() {
        // given
        int[] sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        // when
        Map<Long, Integer[]> result = sortService.getAllResults(15);

        // then
        List<Integer[]> resultsForCheck= new ArrayList<>();
        for (Map.Entry<Long, Integer[]> entry : result.entrySet()) {
            resultsForCheck.add(entry.getValue());
            // first value (for i = 0) skipped because method return original unsorted array at this point
            for (int i = 1; i < resultsForCheck.size(); i++) {
                assertThat(resultsForCheck.get(i)).isEqualTo(sortedArray);
            }
        }
    }

    @Test
    void getAllResultsMethodShouldThrowExceptionForInvalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> sortService.getAllResults(null),
            "Array size cannot be null.");
        assertThrows(IllegalArgumentException.class, () -> sortService.getAllResults(-1),
            "Array size cannot be lower than zero.");
        assertThrows(IllegalArgumentException.class, () -> sortService.getAllResults(1_001),
            "Array size out of supported range. The maximum supported array size is 1,000,000.");
    }
}
