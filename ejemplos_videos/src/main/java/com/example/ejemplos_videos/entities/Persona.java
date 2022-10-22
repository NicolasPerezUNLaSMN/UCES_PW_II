package com.example.ejemplos_videos.entities;

import java.time.LocalDateTime;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;


@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="persona")
public class Persona {

	//columnas que no estan den models
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//Las mismas de la capa models:
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="peso")
	private float peso;
	
	@Column(name="pais")
	private String pais;
	
	//Nuevas que se suelen usar
	@Column(name="creado")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="actualizado")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	//Se podria agregar @NotNull si se queire que la relación exista siempre
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
	@JsonIgnore
	private Avatar avatar;
	
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Figurita> figuritas = new HashSet<>();;
	
	
	 @ManyToMany(cascade = {
	            CascadeType.PERSIST,
	            CascadeType.MERGE
	  })
	    @JoinTable(name = "persona_pais",
	            joinColumns = @JoinColumn(name = "persona_id"),
	            inverseJoinColumns = @JoinColumn(name = "pais_id")
	  )
	 @JsonIgnoreProperties("persona")
	private Set<Pais> paises = new HashSet<>();
	 


	public Persona(int id, String nombre, int edad, float peso, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
	}
	
	

	public Persona() {
		super();
	}



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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Persona(int id, String nombre, int edad, float peso, String pais, Avatar avatar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
		this.avatar = avatar;
	}



	public Avatar getAvatar() {
		return avatar;
	}



	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}






	
	

	public Persona(int id, String nombre, int edad, float peso, String pais, LocalDateTime createdAt,
			LocalDateTime updatedAt, Avatar avatar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.avatar = avatar;
	
	}



	public Set<Pais> getPaises() {
		return paises;
	}



	public void setPaises(Set<Pais> paises) {
		this.paises = paises;
	}



	public Persona(int id, String nombre, int edad, float peso, String pais, LocalDateTime createdAt,
			LocalDateTime updatedAt, Avatar avatar, Set<Figurita> figuritas,Set<Pais> paises) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.avatar = avatar;
		this.figuritas = figuritas;
		this.paises = paises;
	}
	
	
	public Persona(int id, String nombre, int edad, float peso, String pais, LocalDateTime createdAt,
			LocalDateTime updatedAt, Avatar avatar, Set<Pais> paises) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.avatar = avatar;
	
		this.paises = paises;
	}
	
	
	public Persona(int id, String nombre, int edad, float peso, String pais,  Avatar avatar, Set<Pais> paises) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
	
		this.avatar = avatar;
	
		this.paises = paises;
	}



	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", pais=" + pais
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt;
	}



	public Set<Figurita> getFiguritas() {
		return figuritas;
	}



	public void setFiguritas(Set<Figurita> figuritas) {
		this.figuritas = figuritas;
	}


	
	
	

	
	
	
	
	
}
