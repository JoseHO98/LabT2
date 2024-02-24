package com.example.demo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Pelicula;
import com.example.demo.service.PeliculaService;


@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping("/getAllPelicula")
	public String getAllPelicula(Model model) {
		List<Pelicula> listPelicula = peliculaService.getAllPelicula();
		model.addAttribute("pelicula", listPelicula);
		return"listado";
	}
	
	@GetMapping("/register")
	public String register() {
		return "registrar";
	}
	
	@PostMapping("/register")
	public String createPelicula(@RequestParam("nombre") String nombre,@RequestParam("director") String director,@RequestParam("fechaEstreno") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaEstreno,@RequestParam("idgenero") Long idgenero, Model model) {
		
		Pelicula pelicula = new Pelicula();
		pelicula.nombre = nombre;
		pelicula.director = director;
		pelicula.fechaEstreno = fechaEstreno;
		pelicula.idgenero = idgenero;
		
		peliculaService.createPelicula(pelicula);
		
		List<Pelicula> listPeliculas = peliculaService.getAllPelicula();
		model.addAttribute("pelicula",listPeliculas);
		
		return "listado";
	}
	@GetMapping("/edit/{idpelicula}")
	public String getPeliculaByID(@PathVariable Long idpelicula, Model model) {
		Pelicula pelicula = peliculaService.getPeliculaById(idpelicula);
		
		model.addAttribute("pelicula", pelicula);
		return "editar";
	}
	@PostMapping("/edit")
	public String editPelicula(@RequestParam("idpelicula") Long idpelicula,@RequestParam("nombre") String nombre,@RequestParam("director") String director,@RequestParam("fechaEstreno") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaEstreno, Model model) {
		
		Pelicula pelicula = peliculaService.getPeliculaById(idpelicula);
		pelicula.nombre = nombre;
		pelicula.director = director;
		pelicula.fechaEstreno = fechaEstreno;
		
		peliculaService.createPelicula(pelicula);
		
		List<Pelicula> listPeliculas = peliculaService.getAllPelicula();
		model.addAttribute("pelicula",listPeliculas);
		
		return "listado";
	}
	@GetMapping("/delete/{idpelicula}")
	public String deletePelicula(@PathVariable Long idpelicula, Model model) {
		peliculaService.deletePelicula(idpelicula);
		
		List<Pelicula> listPeliculas = peliculaService.getAllPelicula();
		model.addAttribute("pelicula", listPeliculas);
		
		return "listado";
	}
}
