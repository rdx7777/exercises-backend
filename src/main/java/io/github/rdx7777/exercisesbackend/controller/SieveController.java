package io.github.rdx7777.exercisesbackend.controller;

import io.github.rdx7777.exercisesbackend.service.SieveService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sieve")
public class SieveController {

    private final Logger logger = LoggerFactory.getLogger(SieveController.class);

    public final SieveService service;

    public SieveController(SieveService sieveService) {
        this.service = sieveService;
    }

    @GetMapping(value = "/{max}", produces = "application/json")
    public ResponseEntity<?> getSieve(@PathVariable("max") Integer max) {
        logger.info("Attempt to get sieve for {}.", max);
        return ResponseEntity.ok(service.getSieve(max));
    }
}
