package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpelicula")
	public Long idpelicula;
	@Column(name = "nombre")
	public String nombre;
	@Column(name = "director")
	public String director;
	@Column(name = "fechaEstreno")
	public Date fechaEstreno;
	@JoinColumn(name = "idgenero") 
	public Long idgenero;
}
