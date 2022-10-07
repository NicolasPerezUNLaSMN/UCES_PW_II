package com.example.ejemplos_videos.models;




import java.util.HashSet;

import java.util.Set;




public class PaisModelo {

	
	
	private int id;
	

	
	private String nombre;
	
	private int ranking;
	
	
	public Set<PersonaModelo> persona = new HashSet<>();


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


	public void setRanking(int ranking) {
		this.ranking = ranking;
	}


	public Set<PersonaModelo> getPersona() {
		return persona;
	}


	public void setPersona(Set<PersonaModelo> persona) {
		this.persona = persona;
	}


	public PaisModelo(int id, String nombre, int ranking, Set<PersonaModelo> persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ranking = ranking;
		this.persona = persona;
	}
	
	
	public PaisModelo(int id, String nombre, int ranking) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ranking = ranking;
		this.persona= new HashSet<>();
	}
	
	
	public PaisModelo() {
		super();
		
	
	}
	
	

	
	
	
	
	
}
