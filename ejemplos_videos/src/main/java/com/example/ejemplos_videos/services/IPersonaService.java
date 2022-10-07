package com.example.ejemplos_videos.services;

import com.example.ejemplos_videos.models.PersonaModelo;

import java.util.List;
import java.util.Set;

import com.example.ejemplos_videos.entities.Figurita;
import com.example.ejemplos_videos.entities.Pais;
import com.example.ejemplos_videos.entities.Persona;
public interface IPersonaService {
	
	
	public List<Persona> getAll();
	
	public PersonaModelo insertOrUpdate(PersonaModelo personaModelo);
	
	public PersonaModelo insertOrUpdateSet(PersonaModelo personaModelo);
	
	public boolean remove(int id);
	
	public PersonaModelo traerPorId(int id);
	
	public List<PersonaModelo> getAllModel();
	
	public Set<Pais> paisesDeLaPersona(int id);

	public Set<Figurita> figuritasDeLaPersona(int id);
}


