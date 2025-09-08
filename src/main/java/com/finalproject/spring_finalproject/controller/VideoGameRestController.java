package com.finalproject.spring_finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.spring_finalproject.model.VideoGame;
import com.finalproject.spring_finalproject.service.VideoGameService;

@RestController
@RequestMapping("/api/videogame")
public class VideoGameRestController {

    @Autowired
    private VideoGameService videoGameService;

    @GetMapping
    public List<VideoGame> index() {
        List<VideoGame> videogames = videoGameService.findAll();

        return videogames;
    }
}
