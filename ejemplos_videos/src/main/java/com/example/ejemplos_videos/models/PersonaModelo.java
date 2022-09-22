package com.example.ejemplos_videos.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class PersonaModelo {
	
	
	private int id;
	
	@Size(min=4, max =12)
	private String nombre;
	
	@Min(0)
	private int edad;
	
	
	@Min(4)
	@Max(300)
	private float peso;
	
	@Size(min=4, max =40)
	private String pais;
	
	
	
	public PersonaModelo() 
	{}
	
	
	public PersonaModelo(String nombre, int edad, float peso) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	
	
	
	public PersonaModelo(@Size(min = 4, max = 12) String nombre, @Min(0) int edad, @Min(4) @Max(300) float peso,
			@Size(min = 4, max = 40) String pais) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}


	public PersonaModelo(int id, @Size(min = 4, max = 12) String nombre, @Min(0) int edad, @Min(4) @Max(300) float peso,
			@Size(min = 4, max = 40) String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	

}
