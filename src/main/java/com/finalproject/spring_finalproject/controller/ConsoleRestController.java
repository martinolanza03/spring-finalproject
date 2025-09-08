package com.finalproject.spring_finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.spring_finalproject.model.Console;
import com.finalproject.spring_finalproject.service.ConsoleService;

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
}
