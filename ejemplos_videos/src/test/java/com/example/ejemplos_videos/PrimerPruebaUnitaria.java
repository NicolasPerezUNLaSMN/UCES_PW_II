package com.example.ejemplos_videos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.ejemplos_videos.services.IFiguritaService;

@SpringBootTest
public class PrimerPruebaUnitaria {
	
	
	
	@Autowired
	@Qualifier("figuritaService")
	private IFiguritaService figuritaService;
	
	@Test
	void pruebaFigurita1() {
		
		System.out.println(figuritaService.traerPorId(1));
	}
	
	
	
	
	

}
