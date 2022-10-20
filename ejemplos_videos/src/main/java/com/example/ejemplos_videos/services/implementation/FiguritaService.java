package com.example.ejemplos_videos.services.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.ejemplos_videos.converters.FiguritaConverter;

import com.example.ejemplos_videos.entities.Figurita;

import com.example.ejemplos_videos.models.FiguritaModelo;

import com.example.ejemplos_videos.repositories.IFiguritaRepository;

import com.example.ejemplos_videos.services.IFiguritaService;



@Service("figuritaService")
public class FiguritaService implements IFiguritaService {
	
	@Autowired
	@Qualifier("figuritaRepository")
	private IFiguritaRepository figuritaRepository;
	
	@Autowired
	@Qualifier("figuritaConverter")
	private FiguritaConverter figuritaConverter;
	
	@Override
	public List<Figurita> getAll(){	
			
			
		return figuritaRepository.findAll();	
	}
	
	
	public FiguritaModelo traerPorId(int id) {
		
		
		return figuritaConverter.entityToModel(figuritaRepository.findById(id));
		
	};
	
	
	
	
	
	
	
	

}
