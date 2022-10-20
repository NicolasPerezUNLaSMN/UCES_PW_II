package com.example.ejemplos_videos.services;

import com.example.ejemplos_videos.models.FiguritaModelo;
import com.example.ejemplos_videos.models.PersonaModelo;

import java.util.List;

import com.example.ejemplos_videos.entities.Figurita;
import com.example.ejemplos_videos.entities.Pais;
import com.example.ejemplos_videos.entities.Persona;
public interface IFiguritaService {
	
	
	public List<Figurita> getAll();
	


	
	public FiguritaModelo traerPorId(int id);
	

	


}


