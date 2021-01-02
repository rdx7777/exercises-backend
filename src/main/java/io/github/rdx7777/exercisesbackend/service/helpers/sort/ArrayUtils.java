package io.github.rdx7777.exercisesbackend.service.helpers.sort;

public class ArrayUtils {

    public static void swapElementsInArray(int[] array, int indexOfFirstElement, int indexOfSecondElement) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array cannot be null.");
        }
        if (indexOfFirstElement < 0) {
            throw new IllegalArgumentException("Passed index of first element cannot be lower than zero.");
        }
        if (indexOfFirstElement > array.length - 1) {
            throw new IllegalArgumentException("Passed index of first element cannot be greater than array size.");
        }
        if (indexOfSecondElement < 0) {
            throw new IllegalArgumentException("Passed index of second element cannot be lower than zero.");
        }
        if (indexOfSecondElement > array.length - 1) {
            throw new IllegalArgumentException("Passed index of second element cannot be greater than array size.");
        }
        int temp = array[indexOfSecondElement];
        array[indexOfSecondElement] = array[indexOfFirstElement];
        array[indexOfFirstElement] = temp;
    }
}
