package com.finalproject.spring_finalproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.spring_finalproject.model.VideoGame;
import com.finalproject.spring_finalproject.service.VideoGameService;

import jakarta.validation.Valid;

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

    @GetMapping("{id}")
    public ResponseEntity<VideoGame> show(@Valid @PathVariable Integer id) {
        Optional<VideoGame> videoGameAttempt = videoGameService.findById(id);

        if (videoGameAttempt.isEmpty()) {
            return new ResponseEntity<VideoGame>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<VideoGame>(videoGameAttempt.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VideoGame> store(@RequestBody VideoGame videoGame) {
        return new ResponseEntity<VideoGame>(videoGameService.create(videoGame), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<VideoGame> update(@RequestBody VideoGame videogame, @Valid @PathVariable Integer id) {
        if (videoGameService.findById(id).isEmpty()) {
            return new ResponseEntity<VideoGame>(HttpStatus.NOT_FOUND);
        }

        videogame.setId(id);

        return new ResponseEntity<VideoGame>(videoGameService.update(videogame), HttpStatus.OK);
    }

}
