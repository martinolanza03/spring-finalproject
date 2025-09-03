package com.finalproject.spring_finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.spring_finalproject.model.VideoGame;
import com.finalproject.spring_finalproject.service.VideoGameService;

@Controller
@RequestMapping("/videogame")
public class VideoGameController {
    @Autowired
    private VideoGameService videoGameService;

    @GetMapping
    public String index(Model model) {
        List<VideoGame> videogames = videoGameService.findAll();

        model.addAttribute("videogames", videogames);

        return "videogame/index";
    }

}
