package io.github.rdx7777.exercisesbackend.service.helpers.fibonacci;

public class FibonacciIterative {

    public static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            throw new IllegalArgumentException("Fibonacci number in order cannot be lower than zero.");
        }
        if (fibonacciNumberInOrder < 2) {
            return fibonacciNumberInOrder;
        }
        long temp;
        long previousValue = 1;
        long actualValue = 1;
        for (int i = 2; i < fibonacciNumberInOrder; i++) {
            temp = previousValue;
            previousValue = actualValue;
            actualValue = previousValue + temp;
        }
        return actualValue;
    }
}
