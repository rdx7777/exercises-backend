package io.github.rdx7777.exercisesbackend.service.helpers.fibonacci;

public class FibonacciRecursive {

    public static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            throw new IllegalArgumentException("Fibonacci number in order cannot be lower than zero.");
        }
        if (fibonacciNumberInOrder < 2) {
            return fibonacciNumberInOrder;
        }
        return fibonacci(fibonacciNumberInOrder - 2)
            + fibonacci(fibonacciNumberInOrder - 1);
    }
}
