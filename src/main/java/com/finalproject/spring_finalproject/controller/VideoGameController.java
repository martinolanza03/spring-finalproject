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

import com.finalproject.spring_finalproject.model.VideoGame;
import com.finalproject.spring_finalproject.repository.ConsoleRepository;
import com.finalproject.spring_finalproject.service.VideoGameService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/videogame")
public class VideoGameController {
    @Autowired
    private VideoGameService videoGameService;

    @Autowired
    private ConsoleRepository consoleRepository;

    @GetMapping
    public String index(Model model) {
        List<VideoGame> videogames = videoGameService.findAll();

        model.addAttribute("videogames", videogames);

        return "videogame/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("videogame", videoGameService.getById(id));

        return "videogame/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("videogame", new VideoGame());
        model.addAttribute("consoles", consoleRepository.findAll());

        return "videogame/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("videogame") VideoGame formVideoGame,
            BindingResult bidingResult,
            Model model) {
        if (bidingResult.hasErrors()) {
            model.addAttribute("consoles", consoleRepository.findAll());
            return "videogame/create-or-edit";
        }

        videoGameService.create(formVideoGame);

        return "redirect:/videogame";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("videogame", videoGameService.findById(id).get());
        model.addAttribute("consoles", consoleRepository.findAll());
        model.addAttribute("edit", true);

        return "videogame/create-or-edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute("videogame") VideoGame formVideoGame,
            BindingResult bidingResult,
            Model model) {
        if (bidingResult.hasErrors()) {
            model.addAttribute("consoles", consoleRepository.findAll());
            return "videogame/create-or-edit";
        }

        videoGameService.update(formVideoGame);

        return "redirect:/videogame";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        videoGameService.deleteById(id);

        return "redirect:/videogame";
    }
}
