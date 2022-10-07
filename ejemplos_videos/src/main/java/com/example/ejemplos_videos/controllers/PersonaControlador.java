package com.example.ejemplos_videos.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.ejemplos_videos.entities.Figurita;
import com.example.ejemplos_videos.entities.Pais;
import com.example.ejemplos_videos.entities.Persona;
import com.example.ejemplos_videos.helpers.ViewRouteHelper;
import com.example.ejemplos_videos.models.PaisModelo;
import com.example.ejemplos_videos.models.PersonaModelo;
import com.example.ejemplos_videos.services.IAvatarService;
import com.example.ejemplos_videos.services.IPaisService;
import com.example.ejemplos_videos.services.IPersonaService;

@Controller
@RequestMapping("personas")
public class PersonaControlador {
	
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	

	@Autowired
	@Qualifier("paisService")
	private IPaisService paisService;
	
	@Autowired
	@Qualifier("avatarService")
	private IAvatarService avatarService;
	
	//@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("/crearPersona")
	public ModelAndView  crearPersona(Model model) {	
		model.addAttribute("persona", new PersonaModelo());
		
		
		
		
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PERSONA_FORM);
		//modelAndView.addObject("usuario", user.getUsername());
		
		

		
		return modelAndView;	
	}
	
	
	
	@GetMapping("/editarPersona/{id}")
	public ModelAndView  editarPersona(@PathVariable("id")int id, Model model) {	
		
		
		
		PersonaModelo persona = personaService.traerPorId(id);

		model.addAttribute("persona", persona);
		
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PERSONA_FORM);
		
		
		return modelAndView;	
	}
	
	
	

	@GetMapping("/agregarFavorito/{id}")
	public ModelAndView  agregarFavorito(@PathVariable("id")int id, Model model) {	
		
		
		
		PersonaModelo persona = personaService.traerPorId(id);
		
		List<Pais> paises = paisService.getAll();

		model.addAttribute("persona", persona);
		model.addAttribute("paises",paises);
		
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PERSONA_FAVORITO);
		
		
		return modelAndView;	
	}
	
	

	@GetMapping("/detalles/{id}")
	public ModelAndView  detalles(@PathVariable("id")int id, Model model) {	
		
		
		
		PersonaModelo persona = personaService.traerPorId(id);
		
		Set<Pais> paises = personaService.paisesDeLaPersona(id);
		
		Set<Figurita> figuritas = personaService.figuritasDeLaPersona(id);

		model.addAttribute("persona", persona);
		model.addAttribute("paises",paises);
		model.addAttribute("figuritas",figuritas);
		
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PERSONA_DETALLES);
		
		
		return modelAndView;	
	}
	
	
	@GetMapping("/agregar/{id}/{idEquipo}")
	public ModelAndView  agregar(@PathVariable("id")int id,@PathVariable("idEquipo")int idEquipo, Model model) {	
		
	
		
		PersonaModelo persona = personaService.traerPorId(id);
		
		PaisModelo pais = paisService.traerPorId(idEquipo);
		
		persona.getPaises().add(pais);
		
		
		personaService.insertOrUpdateSet(persona);

		
		ModelAndView mV = new ModelAndView();
		
		mV.setViewName(ViewRouteHelper.PERSONA_LIST);
		mV.addObject("listaPersonas",personaService.getAll());
		
		
		return mV;	
	}
	
	
	
	
	
	@GetMapping("/eliminarPersona/{id}")
	public ModelAndView  eliminarPersona(@PathVariable("id")int id, Model model) {	
		
	
		personaService.remove(id);
		
		
		return listaPersonas();	
	}
	
	
		@GetMapping("/listaPersonas")
		public ModelAndView  listaPersonas() {	
		
			ModelAndView mV = new ModelAndView();
			
			mV.setViewName(ViewRouteHelper.PERSONA_LIST);
			mV.addObject("listaPersonas",personaService.getAll());
			
		
			
			
			return mV;	
		}
	
		
		
	
	@PostMapping("/nuevapersona")
	public ModelAndView nuevaPersona(@Valid @ModelAttribute("persona")PersonaModelo persona,
			BindingResult b, @RequestParam("file") MultipartFile imagen) {
		
		
		
		ModelAndView mV = new ModelAndView();
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.PERSONA_FORM);
			
		}else {
			
			if(!imagen.isEmpty()) {
				
				Path directorioImagenes = Paths.get("src//main//resources//static/images");
				
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				
				try {
					byte[] bytesImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);
					
					persona.getAvatar().setImagen(imagen.getOriginalFilename());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		
			
			
			//Modificamos el insertar de la persona para que se inserte el avatar tambien...
			personaService.insertOrUpdate(persona); 
			
			mV.setViewName(ViewRouteHelper.PERSONA_NEW);
			mV.addObject("persona", persona);
			
			//Podríamos tambien agregarle las personas que tenemos en la BD
			mV.addObject("listaPersonas",personaService.getAll());
			
			
			
			

		}
			
		return mV;
	}

}
