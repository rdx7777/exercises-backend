package io.github.rdx7777.exercisesbackend.service.helpers.sieve;

public class SieveOfEratosthenes {

    public static final int NON_PRIME_MARKER = 0;

    public static int[] sieve(int maximumNumber) {
        if (maximumNumber < 2) {
            return new int[0];
        }
        int[] array = createInitialArray(maximumNumber);
        markNonePrimeNumbers(array);
        return extractPrimesNumbers(array);
    }

    private static int[] createInitialArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    private static void markNonePrimeNumbers(int[] array) {
        for (int i = 2; i < array.length; i++) {
            if (array[i] != NON_PRIME_MARKER) {
                for (int j = i * 2; j < array.length; j += i) {
                    array[j] = NON_PRIME_MARKER;
                }
            }
        }
    }

    private static int[] extractPrimesNumbers(int[] array) {
        int numberOfPrimes = getCountOfPrimeNumbers(array);
        int[] primesArray = new int[numberOfPrimes];
        int primesArrayIndex = 0;
        for (int i = 2; i < array.length; i++) {
            if (array[i] != NON_PRIME_MARKER) {
                primesArray[primesArrayIndex] = array[i];
                primesArrayIndex++;
            }
        }
        return primesArray;
    }

    private static int getCountOfPrimeNumbers(int[] array) {
        int numberOfPrimes = 0;
        for (int i = 2; i < array.length; i++) {
            if (array[i] != NON_PRIME_MARKER) {
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }
}
