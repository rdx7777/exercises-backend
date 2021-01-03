package io.github.rdx7777.exercisesbackend.service;

import io.github.rdx7777.exercisesbackend.service.helpers.sieve.SieveOfEratosthenes;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SieveService {

    private final Logger logger = LoggerFactory.getLogger(SieveService.class);

    public Integer[] getSieve(Integer maxNumber) {
        if (maxNumber == null) {
            logger.error("Attempt to get Sieve of Eratosthenes providing null maximum number.");
            throw new IllegalArgumentException("Maximum number cannot be null.");
        }
        if (maxNumber > 100_000) {
            logger.error("Attempt to get Sieve of Eratosthenes providing maximum number out of supported range.");
            throw new IllegalArgumentException("Maximum number out of supported range. The maximum supported number is 100,000.");
        }
        return Arrays.stream(SieveOfEratosthenes.sieve(maxNumber)).boxed().toArray(Integer[]::new);
    }
}
