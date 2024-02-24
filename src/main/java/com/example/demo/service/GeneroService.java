package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Genero;
import com.example.demo.repository.GeneroRepository;

public class GeneroService {
	@Autowired
	private final GeneroRepository generoRepository;
    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }
    public List<Genero> getAllGeneros() {
        return generoRepository.findAll();
    }
}
