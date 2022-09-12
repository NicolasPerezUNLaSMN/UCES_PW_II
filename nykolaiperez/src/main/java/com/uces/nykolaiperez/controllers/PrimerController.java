package com.uces.nykolaiperez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/primerspring")
public class PrimerController {
	
	@GetMapping("holamundo")
	public String holaMundo() {
		
		return "HolaMundo"; 
		
	}
	


}
