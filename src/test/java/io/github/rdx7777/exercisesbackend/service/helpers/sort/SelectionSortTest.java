package io.github.rdx7777.exercisesbackend.service.helpers.sort;

class SelectionSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new SelectionSort();
    }
}
