package com.example.ejemplos_videos.controllers.api.v0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplos_videos.models.FiguritaModelo;

import com.example.ejemplos_videos.services.IFiguritaService;


import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/v0/figurita")
public class FiguritaControladorRest {
	
	@Autowired
	@Qualifier("figuritaService")
	private IFiguritaService figuritaService;
	
	
	@Operation(summary="Trae figurita por id", description = "Trae a la figurita con su determinado id")
	@GetMapping("/traer/{id}")
	public ResponseEntity<Object> traerFigurita(@PathVariable("id") int id) {
		
	
	    FiguritaModelo f = figuritaService.traerPorId(id);
	    
	    Object body;
	    		
	    if (f == null) {
	    	body ="No se puedo traer a la figurita";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	    }

	    return ResponseEntity.status(HttpStatus.OK).body(f);
	}
	

}
