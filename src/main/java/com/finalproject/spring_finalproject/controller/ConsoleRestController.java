package com.finalproject.spring_finalproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.spring_finalproject.model.Console;
import com.finalproject.spring_finalproject.service.ConsoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/console")
public class ConsoleRestController {

    @Autowired
    private ConsoleService consoleService;

    @GetMapping
    public List<Console> index() {
        List<Console> consoles = consoleService.findAll();

        return consoles;
    }

    @GetMapping("{id}")
    public ResponseEntity<Console> show(@Valid @PathVariable Integer id) {
        Optional<Console> consoleAttempt = consoleService.findById(id);

        if (consoleAttempt.isEmpty()) {
            return new ResponseEntity<Console>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Console>(consoleAttempt.get(), HttpStatus.OK);
    }
}
