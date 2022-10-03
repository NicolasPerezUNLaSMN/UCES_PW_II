package com.example.ejemplos_videos.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplos_videos.entities.Persona;

@Repository("personaRepository")
public interface IPersonaRepository extends 
						JpaRepository<Persona, Serializable> {
	
	//Metodos que se pueden llamar desde el controlador :) 
	//Si se utilizan nombres standar como findBy, Order, GroupBy, etc no hace falta 
	//desarrollar las consultas,tambien se puede hacer buscarPorNombre, pero
	//con esos nombres deberas programarlo personalmente
	public abstract Persona findByNombre(String nombre);
	
	public abstract Persona findById(int id);
	
	
	public abstract Persona findByPaisAndEdad(String pais, int edad);
	
	
	public abstract Persona findByPaisAndEdadOrderByEdadDesc(String pais, int edad);
	
	

}
