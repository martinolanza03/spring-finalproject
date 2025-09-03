package com.finalproject.spring_finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.spring_finalproject.model.VideoGame;

public interface VideoGameRepository extends JpaRepository<VideoGame, Integer> {

}
