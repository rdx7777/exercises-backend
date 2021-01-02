package io.github.rdx7777.exercisesbackend.service;

import io.github.rdx7777.exercisesbackend.service.helpers.fibonacci.FibonacciChecker;
import io.github.rdx7777.exercisesbackend.service.helpers.fibonacci.FibonacciIterative;
import io.github.rdx7777.exercisesbackend.service.helpers.fibonacci.FibonacciRecursive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    private final Logger logger = LoggerFactory.getLogger(FibonacciService.class);

    public Boolean checkFibonacciNumber(Long number) {
        if (number == null) {
            logger.error("Attempt to check Fibonacci number providing null number.");
            throw new IllegalArgumentException("Number for check cannot be null.");
        }
        if (number < 0) {
            logger.error("Attempt to check Fibonacci number providing number lower than 0.");
            throw new IllegalArgumentException("Number for check cannot be lower than zero.");
        }
        if (number > 2_000_000_000) {
            logger.error("Attempt to check Fibonacci number providing number out of supported range.");
            throw new IllegalArgumentException("Number out of supported range. The maximum supported number is 2,000,000,000.");
        }
        return FibonacciChecker.isFibonacciNumber(number);
    }

    public Long getFibonacciNumberInOrderUsingIterativeMethod(Integer fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder == null) {
            logger.error("Attempt to get Fibonacci number providing null order number.");
            throw new IllegalArgumentException("Fibonacci number in order cannot be null.");
        }
        if (fibonacciNumberInOrder < 0) {
            logger.error("Attempt to get Fibonacci number providing order number lower than 0.");
            throw new IllegalArgumentException("Fibonacci number in order cannot be lower than zero.");
        }
        return FibonacciIterative.fibonacci(fibonacciNumberInOrder);
    }

    public Long getFibonacciNumberInOrderUsingRecursiveMethod(Integer fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder == null) {
            logger.error("Attempt to get Fibonacci number providing null order number.");
            throw new IllegalArgumentException("Fibonacci number in order cannot be null.");
        }
        if (fibonacciNumberInOrder < 0) {
            logger.error("Attempt to get Fibonacci number providing order number lower than 0.");
            throw new IllegalArgumentException("Fibonacci number in order cannot be lower than zero.");
        }
        return FibonacciRecursive.fibonacci(fibonacciNumberInOrder);
    }
}
