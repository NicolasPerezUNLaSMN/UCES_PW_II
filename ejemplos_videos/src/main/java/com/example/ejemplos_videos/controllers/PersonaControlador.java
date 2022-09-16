package com.example.ejemplos_videos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ejemplos_videos.helpers.ViewRouteHelper;
import com.example.ejemplos_videos.models.Persona;

@Controller
@RequestMapping("personas")
public class PersonaControlador {
	
	
	
	@GetMapping("/crearPersona")
	public String crearPersona(Model model) {
		
		model.addAttribute("persona", new Persona());
		return ViewRouteHelper.PERSONA_FORM;
		
	}
	
	
	@PostMapping("/nuevapersona")
	public ModelAndView nuevaPersona(@ModelAttribute("persona")Persona persona) {
		
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.PERSONA_NEW);
		mV.addObject("persona", persona);
		
		return mV;
	}

}
