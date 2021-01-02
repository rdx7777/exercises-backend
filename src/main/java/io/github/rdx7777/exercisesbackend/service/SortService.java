package io.github.rdx7777.exercisesbackend.service;

import io.github.rdx7777.exercisesbackend.service.helpers.sort.BubbleSort;
import io.github.rdx7777.exercisesbackend.service.helpers.sort.CollectionsSort;
import io.github.rdx7777.exercisesbackend.service.helpers.sort.MergeSort;
import io.github.rdx7777.exercisesbackend.service.helpers.sort.QuickSort;
import io.github.rdx7777.exercisesbackend.service.helpers.sort.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SortService {

    public List<SortedObject> getAllResults(Integer arraySize) {
        List<SortedObject> results = new ArrayList<>();
        int[] unsortedArray = createUnsortedArray(arraySize);
        results.add(getBubbleSortResult(unsortedArray.clone()));
        results.add(getCollectionSortResult(unsortedArray.clone()));
        results.add(getMergeSortResult(unsortedArray.clone()));
        results.add(getQuickSortResult(unsortedArray.clone()));
        results.add(getSelectionSortResult(unsortedArray.clone()));
        return results;
    }

    private static class SortedObject {

        private Long time;
        private Integer[] sortedArray;

        private SortedObject(Long time, Integer[] sortedArray) {
            this.time = time;
            this.sortedArray = sortedArray;
        }
    }

    private int[] createUnsortedArray(Integer arraySize) {
        Random random = new Random();
        int[] unsortedArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            unsortedArray[i] = random.nextInt(arraySize);
        }
        return unsortedArray;
    }

    private SortedObject getBubbleSortResult(int[] unsortedArray) {
        BubbleSort bubbleSort = new BubbleSort();
        long startTime = System.currentTimeMillis();
        int[] bubbleSortedArray = bubbleSort.sort(unsortedArray);
        Long bubbleSortedTime = System.currentTimeMillis() - startTime;
        return new SortedObject(bubbleSortedTime, Arrays.stream(bubbleSortedArray).boxed().toArray(Integer[]::new));
    }

    private SortedObject getCollectionSortResult(int[] unsortedArray) {
        CollectionsSort collectionsSort = new CollectionsSort();
        long startTime = System.currentTimeMillis();
        int[] collectionSortedArray = collectionsSort.sort(unsortedArray);
        Long collectionSortTime = System.currentTimeMillis() - startTime;
        return new SortedObject(collectionSortTime, Arrays.stream(collectionSortedArray).boxed().toArray(Integer[]::new));
    }

    private SortedObject getMergeSortResult(int[] unsortedArray) {
        MergeSort mergeSort = new MergeSort();
        long startTime = System.currentTimeMillis();
        int[] mergeSortedArray = mergeSort.sort(unsortedArray);
        Long mergeSortTime = System.currentTimeMillis() - startTime;
        return new SortedObject(mergeSortTime, Arrays.stream(mergeSortedArray).boxed().toArray(Integer[]::new));
    }

    private SortedObject getQuickSortResult(int[] unsortedArray) {
        QuickSort quickSort = new QuickSort();
        long startTime = System.currentTimeMillis();
        int[] quickSortedArray = quickSort.sort(unsortedArray);
        Long quickSortTime = System.currentTimeMillis() - startTime;
        return new SortedObject(quickSortTime, Arrays.stream(quickSortedArray).boxed().toArray(Integer[]::new));
    }

    private SortedObject getSelectionSortResult(int[] unsortedArray) {
        SelectionSort selectionSort = new SelectionSort();
        long startTime = System.currentTimeMillis();
        int[] selectionSortedArray = selectionSort.sort(unsortedArray);
        Long selectionSortTime = System.currentTimeMillis() - startTime;
        return new SortedObject(selectionSortTime, Arrays.stream(selectionSortedArray).boxed().toArray(Integer[]::new));
    }
}
