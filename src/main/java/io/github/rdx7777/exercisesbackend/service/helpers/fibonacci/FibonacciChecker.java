package io.github.rdx7777.exercisesbackend.service.helpers.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibonacciChecker {

    private static Map<Long, Boolean> cache = new HashMap<>();

    public static boolean isFibonacciNumber(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Fibonacci number cannot be lower than zero.");
        }
        if (number > 2_000_000_000) {
            throw new IllegalArgumentException("Number out of supported range. The maximum supported number is 2,000,000,000.");
        }
        if (cache.containsKey(number)) {
            return cache.get(number);
        }
        long formula1 = 5 * (number * number) + 4;
        long formula2 = 5 * (number * number) - 4;
        boolean isFibonacciNumber = isPerfectSquare(formula1) || isPerfectSquare(formula2);
        cache.put(number, isFibonacciNumber);
        return isFibonacciNumber;
    }

    private static boolean isPerfectSquare(long number) {
        double root = Math.sqrt(number);
        return root == Math.round(root);
    }
}
