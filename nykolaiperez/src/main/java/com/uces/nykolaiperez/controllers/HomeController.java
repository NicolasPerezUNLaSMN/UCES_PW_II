package com.uces.nykolaiperez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import helpers.ViewRouteHelper;
import models.Degree;

@Controller
@RequestMapping("/")
public class HomeController {
	
	//LOs POST
	@GetMapping("/degree")
	public String degree(Model model) {
		
		model.addAttribute("degree", new Degree());
		return ViewRouteHelper.DEGREE_FORM;
		
		
	}
	
	@PostMapping("/newdegree")
	public ModelAndView newdregree(@ModelAttribute("degree")Degree degree) {
		
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.DEGREE_NEW);
		mV.addObject("degree", degree);
		return mV;
		
	}
	
	
	
	
	
	//LOS GETS :)
	@GetMapping("/index")
	public String index() {
		
		return ViewRouteHelper.INDEX; 
		
	}
	
	
	//GET Example: SERVER/hello?name=someName
	@GetMapping("/hello")
	public ModelAndView helloParams1(@RequestParam(name="name", required=false, defaultValue="null") String name) {
			//ModelAndView mV = new ModelAndView("home/hello");
			ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
			mV.addObject("name", name);
			return mV;
		}
		
		//GET Example: SERVER/hello/someName
		@GetMapping("/hello/{name}")
		public ModelAndView helloParams2(@PathVariable("name") String name) {
			//ModelAndView mV = new ModelAndView("home/hello");
			ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
			mV.addObject("name", name);
			return mV;
		}
		
		@GetMapping("/")
		public RedirectView redirectToHomeIndex() {
			return new RedirectView(ViewRouteHelper.ROUTE_INDEX);
		}
	


}
