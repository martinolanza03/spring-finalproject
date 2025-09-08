package com.finalproject.spring_finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.spring_finalproject.model.Console;
import com.finalproject.spring_finalproject.service.ConsoleService;

import jakarta.validation.Valid;

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

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("console", new Console());

        return "console/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("console") Console formConsole,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "console/create-or-edit";
        }

        consoleService.create(formConsole);

        return "redirect:/console";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("console", consoleService.findById(id).get());
        model.addAttribute("edit", true);

        return "console/create-or-edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute("console") Console formConsole,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "console/create-or-edit";
        }

        consoleService.update(formConsole);

        return "redirect:/console";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        consoleService.deleteById(id);

        return "redirect:/console";
    }

}
