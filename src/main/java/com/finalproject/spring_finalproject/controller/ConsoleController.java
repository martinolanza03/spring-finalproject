package com.finalproject.spring_finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.spring_finalproject.model.Console;
import com.finalproject.spring_finalproject.service.ConsoleService;

@Controller
@RequestMapping("/console")
public class ConsoleController {
    @Autowired
    private ConsoleService consoleService;

    @GetMapping
    public String index(Model model) {
        List<Console> consoles = consoleService.findAll();

        model.addAttribute("consoles", consoles);

        return "console/index";
    }

}
