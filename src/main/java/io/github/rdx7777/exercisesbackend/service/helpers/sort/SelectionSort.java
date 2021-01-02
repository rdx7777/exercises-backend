package io.github.rdx7777.exercisesbackend.service.helpers.sort;

public class SelectionSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array cannot be null.");
        }
        int[] sortedArray = array.clone();
        for (int i = 0; i < sortedArray.length; i++) {
            int minimalElementPosition = i;
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] < sortedArray[minimalElementPosition]) {
                    minimalElementPosition = j;
                }
            }
            ArrayUtils.swapElementsInArray(sortedArray, minimalElementPosition, i);
        }
        return sortedArray;
    }
}
