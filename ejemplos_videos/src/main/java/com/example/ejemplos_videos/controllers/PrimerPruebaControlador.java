package com.example.ejemplos_videos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.example.ejemplos_videos.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/index")
public class PrimerPruebaControlador {
	
	
	@GetMapping("/nombre") //?nombre_variable=Nico
	public ModelAndView cambiarNombreNuevo(@RequestParam(name="nombre_variable", required=true, defaultValue="null") String nombre ){
		
		ModelAndView modelV = new ModelAndView(ViewRouteHelper.INDEX);
		
		modelV.addObject("variableParaTemplate", nombre);
		
		return modelV;
	
	
}
	
	@GetMapping("/nombre/{nombre_variable}")
	public ModelAndView cambiarNombre(@PathVariable("nombre_variable")String nombre_variable) {
			
			ModelAndView modelV = new ModelAndView(ViewRouteHelper.INDEX);
			
			modelV.addObject("variableParaTemplate", nombre_variable);
			
			return modelV;
		
		
	}
	
	
	@GetMapping("iniciando")
	public String iniciandoElCurso() {
		
			return ViewRouteHelper.INDEX_INICIANDO;
		
		
	}
	
	@GetMapping("")
	public String inicio() {
		
			return ViewRouteHelper.INDEX;
		
		
	}

	
	
}
