package com.finalproject.spring_finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.spring_finalproject.model.Console;
import com.finalproject.spring_finalproject.repository.ConsoleRepository;

@Service
public class ConsoleService {
    @Autowired
    private ConsoleRepository consoleRepository;

    public List<Console> findAll() {
        return consoleRepository.findAll();
    }

    public Optional<Console> findById(Integer id) {
        return consoleRepository.findById(id);
    }

    public Console getById(Integer id) {
        Optional<Console> consoleAttempt = consoleRepository.findById(id);

        return consoleAttempt.get();
    }

    public Console create(Console console) {
        return consoleRepository.save(console);
    }

    public Console update(Console console) {
        return consoleRepository.save(console);
    }

    public void delete(Console console) {
        consoleRepository.delete(console);
    }

    public void deleteById(Integer id) {
        Console console = consoleRepository.findById(id).get();

        consoleRepository.delete(console);
    }
}
