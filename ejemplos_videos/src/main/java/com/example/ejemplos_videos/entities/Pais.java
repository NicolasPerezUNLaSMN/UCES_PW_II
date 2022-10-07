package com.example.ejemplos_videos.entities;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;




@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //Para hacer iguales los objetos
@Table(name="pais")
public class Pais {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	
	private String nombre;
	
	private int ranking;
	
	

	 @ManyToMany(mappedBy = "paises")
	    public Set<Persona> persona = new HashSet<>();
	

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int rank) {
		this.ranking = rank;
	}


	
	
	
	public Pais() {
		super();
	
	}

	public Pais(int id, String nombre, int ranking, Set<Persona> persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ranking = ranking;
		this.persona = persona;
	}
	
	public Pais(int id, String nombre, int ranking) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ranking = ranking;
		this.persona =  new HashSet<>();
	}

	public Set<Persona> getPersona() {
		return persona;
	}

	public void setPersona(Set<Persona> persona) {
		this.persona = persona;
	}
	

	
	
	
}
