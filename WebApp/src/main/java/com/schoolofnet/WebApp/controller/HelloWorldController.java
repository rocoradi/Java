/**
 * @author Coradi
 *
 * 10 de jan de 2018
 */
package com.schoolofnet.WebApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/hello");
		mv.addObject("nome", "Rodrigo Coradi");
		return mv;
	}
	
	@GetMapping("/new")
	public String newPath(Model model) {
		List<String> lista = new ArrayList<String>();
		
		lista.add("Rodrigo Coradi");
		lista.add("Maria Coradi");
		lista.add("Alice Coradi");
		lista.add("Cida Coradi");
		lista.add("Mario Coradi");
		
		model.addAttribute("nome", "Rodrigo Coradi");
		model.addAttribute("lista", lista);
		return "new";
	}
	
	
}
