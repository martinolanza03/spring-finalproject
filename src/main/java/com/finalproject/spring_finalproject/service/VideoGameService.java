package com.finalproject.spring_finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.spring_finalproject.model.VideoGame;
import com.finalproject.spring_finalproject.repository.VideoGameRepository;

@Service
public class VideoGameService {
    @Autowired
    private VideoGameRepository videoGameRepository;

    public List<VideoGame> findAll() {
        return videoGameRepository.findAll();
    }

    public Optional<VideoGame> findById(Integer id) {
        return videoGameRepository.findById(id);
    }

    public VideoGame getById(Integer id) {
        Optional<VideoGame> videoGameAttempt = videoGameRepository.findById(id);

        return videoGameAttempt.get();
    }

    public VideoGame create(VideoGame videoGame) {
        return videoGameRepository.save(videoGame);
    }

    public VideoGame update(VideoGame videoGame) {
        return videoGameRepository.save(videoGame);
    }

    public void delate(VideoGame videoGame) {
        videoGameRepository.delete(videoGame);
    }

    public void delateById(Integer Id) {
        VideoGame videoGame = videoGameRepository.findById(Id).get();

        videoGameRepository.delete(videoGame);
    }
}
