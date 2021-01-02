package io.github.rdx7777.exercisesbackend.service.helpers.sort;

class MergeSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new MergeSort();
    }
}
