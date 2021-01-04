package io.github.rdx7777.exercisesbackend.controller;

import io.github.rdx7777.exercisesbackend.service.SortService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sort")
public class SortController {

    private final Logger logger = LoggerFactory.getLogger(SortController.class);

    private final SortService service;

    public SortController(SortService service) {
        this.service = service;
    }

    @GetMapping(value = "/{size}", produces = "application/json")
    public ResponseEntity<?> getResults(@PathVariable("size") Integer size) {
        logger.info("Attempt to get sorted arrays with sorting times for array size: {}.", size);
        return ResponseEntity.ok(service.getAllResults(size));
    }
}
