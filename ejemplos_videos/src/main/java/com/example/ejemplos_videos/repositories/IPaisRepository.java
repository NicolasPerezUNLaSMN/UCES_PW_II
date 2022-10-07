package com.example.ejemplos_videos.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplos_videos.entities.Pais;
import com.example.ejemplos_videos.entities.Persona;

@Repository("paisRepository")
public interface IPaisRepository extends 
						JpaRepository<Pais, Serializable> {
	

	public abstract Pais findByNombre(String nombre);
	
	public abstract Pais findById(int id);
	
	

	

}
