package io.github.rdx7777.exercisesbackend.service.helpers.sort;

public class BubbleSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array cannot be null.");
        }
        int[] sortedArray = array.clone();
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 1; j < sortedArray.length; j++) {
                if (sortedArray[j - 1] > sortedArray[j]) {
                    ArrayUtils.swapElementsInArray(sortedArray, j - 1, j);
                }
            }
        }
        return sortedArray;
    }
}
