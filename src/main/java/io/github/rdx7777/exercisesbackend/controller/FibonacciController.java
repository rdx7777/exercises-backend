package io.github.rdx7777.exercisesbackend.controller;

import io.github.rdx7777.exercisesbackend.service.FibonacciService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    private final Logger logger = LoggerFactory.getLogger(FibonacciController.class);

    private final FibonacciService service;

    public FibonacciController(FibonacciService service) {
        this.service = service;
    }

    @GetMapping(value = "/check/{number}", produces = "application/json")
    public ResponseEntity<Boolean> checkFibonacciNumber(@PathVariable("number") Long number) {
        logger.info("Attempt to check Fibonacci number.");
        System.out.println("Hello, Fibonacci Controller here, I'm checking number: " + number);
        Boolean result = service.checkFibonacciNumber(number);
        System.out.println("Result: " + result);
//        return ResponseEntity.ok(service.checkFibonacciNumber(number));
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/get/iterative/{order}", produces = "application/json")
    public ResponseEntity<Long> getFibonacciIterative(@PathVariable("order") Integer order) {
        logger.info("Attempt to get Fibonacci number in order using iterative method.");
        return ResponseEntity.ok(service.getFibonacciNumberInOrderUsingIterativeMethod(order));
    }

    @GetMapping(value = "/get/recursive/{order}", produces = "application/json")
    public ResponseEntity<Long> getFibonacciRecursive(@PathVariable("order") Integer order) {
        logger.info("Attempt to get Fibonacci number in order using recursive method.");
        return ResponseEntity.ok(service.getFibonacciNumberInOrderUsingRecursiveMethod(order));
    }
}
