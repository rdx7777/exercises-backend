package io.github.rdx7777.exercisesbackend.service.helpers.sort;

class QuickSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new QuickSort();
    }
}
