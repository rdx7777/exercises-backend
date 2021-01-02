package io.github.rdx7777.exercisesbackend.service.helpers.sort;

class BubbleSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new BubbleSort();
    }
}
