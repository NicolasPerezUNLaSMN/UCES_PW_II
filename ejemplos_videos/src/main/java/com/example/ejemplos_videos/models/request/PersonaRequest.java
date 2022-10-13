package com.example.ejemplos_videos.models.request;



import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaRequest {
	
	@JsonProperty("Nombre")
	private String nombre;
	
	@JsonProperty("Edad")
	private int edad;
	
	@JsonProperty("Peso")
	private float peso;
	
	@JsonProperty("Pais")
	private String pais;
	
	//DATOS AVATAR
	@JsonProperty("Email")
	private String email;
	

	@JsonProperty("WebPersonal")
	private String webPersonal;
	
	@JsonProperty("Imagen")
	private String imagen;

	//Constructores, setters y getters

	
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public PersonaRequest(  String nombre,  int edad,
			 float peso, String pais) {
		super();
		
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
	}

	

	@Override
	public String toString() {
		return "PersonaRequest [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", pais=" + pais + ", email="
				+ email + ", webPersonal=" + webPersonal + ", imagen=" + imagen + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebPersonal() {
		return webPersonal;
	}

	public void setWebPersonal(String webPersonal) {
		this.webPersonal = webPersonal;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public PersonaRequest(String nombre, int edad, float peso, String pais,
			String email,String webPersonal, String imagen) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
		this.email = email;
		this.webPersonal = webPersonal;
		this.imagen = imagen;
	}

	public PersonaRequest() {
		super();
	}
	
	
	
	
	
	

}
