package com.example.ejemplos_videos.models;






public class FiguritaModelo {

	

	private int id;
	
	

	private int numero;
	
	
	private String descripcion;

	
	
	
	
	
	
	

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

	

	
	
	public FiguritaModelo() {
		super();
		
	}
	
	

	
	public FiguritaModelo(int id, int numero, String descripcion) {
		super();
		this.id = id;
		this.numero = numero;
		this.descripcion = descripcion;
	
	}
	
	
	public FiguritaModelo( int numero, String descripcion) {
		super();
	
		this.numero = numero;
		this.descripcion = descripcion;
	
	}

	@Override
	public String toString() {
		return "Figurita [id=" + id + ", numero=" + numero + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
	
}
