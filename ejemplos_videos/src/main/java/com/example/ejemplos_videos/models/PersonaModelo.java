package com.example.ejemplos_videos.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class PersonaModelo {
	
	@Size(min=4, max =12)
	private String nombre;
	
	@Min(0)
	private int edad;
	
	
	@Min(4)
	@Max(300)
	private float peso;
	
	public PersonaModelo() 
	{}
	
	
	public PersonaModelo(String nombre, int edad, float peso) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
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
	
	
	

}
