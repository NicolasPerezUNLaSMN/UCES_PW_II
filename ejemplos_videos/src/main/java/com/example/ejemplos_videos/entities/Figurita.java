package com.example.ejemplos_videos.entities;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="figurita")
public class Figurita {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	

	private int numero;
	
	
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "persona_id")
	@JsonBackReference
	private Persona persona;
	
	
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Figurita(int id, int numero, String descripcion, Persona persona) {
		super();
		this.id = id;
		this.numero = numero;
		this.descripcion = descripcion;
		this.persona = persona;
	}
	
	
	public Figurita() {
		super();
		
	}
	
	
	public Figurita( int numero, String descripcion, Persona persona) {
		super();
		
		this.numero = numero;
		this.descripcion = descripcion;
		this.persona = persona;
	}
	
	public Figurita(int id, int numero, String descripcion) {
		super();
		this.id = id;
		this.numero = numero;
		this.descripcion = descripcion;
	
	}
	
	
	public Figurita( int numero, String descripcion) {
		super();
	
		this.numero = numero;
		this.descripcion = descripcion;
	
	}

	@Override
	public String toString() {
		return "Figurita [id=" + id + ", numero=" + numero + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
	
}
