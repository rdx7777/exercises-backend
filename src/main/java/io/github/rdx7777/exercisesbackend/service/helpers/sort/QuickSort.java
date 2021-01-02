package io.github.rdx7777.exercisesbackend.service.helpers.sort;

public class QuickSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array cannot be null.");
        }
        int[] sortedArray = array.clone();
        return hoareQuickSort(sortedArray, 0, sortedArray.length - 1);
    }

    private static int[] hoareQuickSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int partitionIndex = arrayPartition(array, leftIndex, rightIndex);
            hoareQuickSort(array, leftIndex, partitionIndex);
            hoareQuickSort(array, partitionIndex + 1, rightIndex);
        }
        return array;
    }

    private static int arrayPartition(int[] array, int leftIndex, int rightIndex) {
        int pivotIndex = setPivotIndex(leftIndex, rightIndex);
        int pivotValue = array[pivotIndex];
        int i = leftIndex - 1;
        int j = rightIndex + 1;
        while (true) {
            do {
                i++;
            }
            while (array[i] < pivotValue);
            do {
                j--;
            }
            while (array[j] > pivotValue);
            if (i >= j) {
                return j;
            } else {
                ArrayUtils.swapElementsInArray(array, i, j);
            }
        }
    }

    private static int setPivotIndex(int leftIndex, int rightIndex) {
        return (leftIndex + (rightIndex - leftIndex) / 2);
    }
}
