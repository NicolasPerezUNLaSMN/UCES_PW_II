package com.example.ejemplos_videos.services;


import com.example.ejemplos_videos.models.PaisModelo;


import java.util.List;

import com.example.ejemplos_videos.entities.Pais;

public interface IPaisService {
	
	
	public List<Pais> getAll();
	
	public PaisModelo insertOrUpdate(PaisModelo paisModelo);
	
	public boolean remove(int id);
	
	public PaisModelo traerPorId(int id);
	
	public List<PaisModelo> getAllModel();
	


}


