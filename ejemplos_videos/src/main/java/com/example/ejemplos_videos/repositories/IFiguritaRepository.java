package com.example.ejemplos_videos.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplos_videos.entities.Figurita;
import com.example.ejemplos_videos.entities.Pais;
import com.example.ejemplos_videos.entities.Persona;

@Repository("figuritaRepository")
public interface IFiguritaRepository extends 
						JpaRepository<Figurita, Serializable> {
	

	
	
	public abstract Figurita findById(int id);
	
	

	

}
