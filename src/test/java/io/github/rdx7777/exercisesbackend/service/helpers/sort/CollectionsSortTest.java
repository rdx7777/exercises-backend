package io.github.rdx7777.exercisesbackend.service.helpers.sort;

class CollectionsSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new CollectionsSort();
    }
}
