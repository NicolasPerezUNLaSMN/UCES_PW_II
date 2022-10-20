package com.example.ejemplos_videos.converters;


import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.ejemplos_videos.entities.Figurita;
import com.example.ejemplos_videos.entities.Pais;
import com.example.ejemplos_videos.models.FiguritaModelo;
import com.example.ejemplos_videos.models.PaisModelo;


@Component("figuritaConverter")
public class FiguritaConverter {
	
	
	
	public FiguritaModelo entityToModel(Figurita figurita) {
		
		
	
		return new FiguritaModelo(figurita.getId(), figurita.getNumero(), figurita.getDescripcion());
		
		
	}
	
		
	
	public Figurita modelToEntity(FiguritaModelo figurita) {
		
	
		return new Figurita(figurita.getId(), figurita.getNumero(), figurita.getDescripcion());
		
		
	}

}
