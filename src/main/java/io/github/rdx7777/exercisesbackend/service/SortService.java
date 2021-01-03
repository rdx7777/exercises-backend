package io.github.rdx7777.exercisesbackend.service;

import io.github.rdx7777.exercisesbackend.service.helpers.sort.BubbleSort;
import io.github.rdx7777.exercisesbackend.service.helpers.sort.CollectionsSort;
import io.github.rdx7777.exercisesbackend.service.helpers.sort.MergeSort;
import io.github.rdx7777.exercisesbackend.service.helpers.sort.QuickSort;
import io.github.rdx7777.exercisesbackend.service.helpers.sort.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SortService {

    private final Logger logger = LoggerFactory.getLogger(SortService.class);

    Map<Long, Integer[]> results = new LinkedHashMap<>();

    public Map<Long, Integer[]> getAllResults(Integer arraySize) {
        if (arraySize == null) {
            logger.error("Attempt to get results providing null array size.");
            throw new IllegalArgumentException("Array size cannot be null.");
        }
        if (arraySize < 0) {
            logger.error("Attempt to get results providing array size lower than 0.");
            throw new IllegalArgumentException("Array size cannot be lower than zero.");
        }
        if (arraySize > 1_000_000) {
            logger.error("Attempt to get results providing array size out of supported range.");
            throw new IllegalArgumentException("Array size out of supported range. The maximum supported array size is 1,000,000.");
        }
        int[] unsortedArray = createUnsortedArray(arraySize);
        results.clear();
        getBubbleSortResult(unsortedArray.clone());
        getCollectionSortResult(unsortedArray.clone());
        getMergeSortResult(unsortedArray.clone());
        getQuickSortResult(unsortedArray.clone());
        getSelectionSortResult(unsortedArray.clone());
        return results;
    }

    private int[] createUnsortedArray(Integer arraySize) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        int[] unsortedArray = IntStream.range(0, arraySize).map(numbers::get).toArray();
        return unsortedArray;
    }

    private void getBubbleSortResult(int[] unsortedArray) {
        BubbleSort bubbleSort = new BubbleSort();
        long startTime = System.currentTimeMillis();
        int[] bubbleSortedArray = bubbleSort.sort(unsortedArray);
        Long bubbleSortedTime = System.currentTimeMillis() - startTime;
        results.put(bubbleSortedTime, Arrays.stream(bubbleSortedArray).boxed().toArray(Integer[]::new));
    }

    private void getCollectionSortResult(int[] unsortedArray) {
        CollectionsSort collectionsSort = new CollectionsSort();
        long startTime = System.currentTimeMillis();
        int[] collectionSortedArray = collectionsSort.sort(unsortedArray);
        Long collectionSortTime = System.currentTimeMillis() - startTime;
        results.put(collectionSortTime, Arrays.stream(collectionSortedArray).boxed().toArray(Integer[]::new));
    }

    private void getMergeSortResult(int[] unsortedArray) {
        MergeSort mergeSort = new MergeSort();
        long startTime = System.currentTimeMillis();
        int[] mergeSortedArray = mergeSort.sort(unsortedArray);
        Long mergeSortTime = System.currentTimeMillis() - startTime;
        results.put(mergeSortTime, Arrays.stream(mergeSortedArray).boxed().toArray(Integer[]::new));
    }

    private void getQuickSortResult(int[] unsortedArray) {
        QuickSort quickSort = new QuickSort();
        long startTime = System.currentTimeMillis();
        int[] quickSortedArray = quickSort.sort(unsortedArray);
        Long quickSortTime = System.currentTimeMillis() - startTime;
        results.put(quickSortTime, Arrays.stream(quickSortedArray).boxed().toArray(Integer[]::new));
    }

    private void getSelectionSortResult(int[] unsortedArray) {
        SelectionSort selectionSort = new SelectionSort();
        long startTime = System.currentTimeMillis();
        int[] selectionSortedArray = selectionSort.sort(unsortedArray);
        Long selectionSortTime = System.currentTimeMillis() - startTime;
        results.put(selectionSortTime, Arrays.stream(selectionSortedArray).boxed().toArray(Integer[]::new));
    }
}
