package io.github.rdx7777.exercisesbackend.service.helpers.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array cannot be null.");
        }
        List<Integer> listToSort = Arrays.stream(array.clone()).boxed().collect(Collectors.toList());
        Collections.sort(listToSort);
        return listToSort.stream().mapToInt(i -> i).toArray();
    }
}
