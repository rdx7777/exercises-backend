package io.github.rdx7777.exercisesbackend.service.helpers.sort;

public class MergeSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array cannot be null.");
        }
        int[] sortedArray = array.clone();
        return mergeSort(sortedArray, sortedArray.length);
    }

    private static int[] mergeSort(int[] array, int index) {
        if (index < 2) {
            return array;
        }
        int mid = index / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[index - mid];
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < index; i++) {
            rightArray[i - mid] = array[i];
        }
        mergeSort(leftArray, mid);
        mergeSort(rightArray, index - mid);
        merge(array, leftArray, rightArray, mid, index - mid);
        return array;
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < left) {
            array[k++] = leftArray[i++];
        }
        while (j < right) {
            array[k++] = rightArray[j++];
        }
    }
}
