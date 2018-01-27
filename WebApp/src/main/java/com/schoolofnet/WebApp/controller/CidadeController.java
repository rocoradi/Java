/**
 * @author Coradi
 *
 * 10 de jan de 2018
 */
package com.schoolofnet.WebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.WebApp.model.Cidade;
import com.schoolofnet.WebApp.repository.CidadeRepository;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public CidadeController(CidadeRepository cidadeRepository) {
		this.cidadeRepository = cidadeRepository;
	}
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("cidades", this.cidadeRepository.findAll());
		return "cidades/index";
	}
	
	@GetMapping("/new")
	public String novaCidade(Model model) {
		model.addAttribute("cidade", new Cidade());
		return "cidades/new";
	}
	
	@PostMapping("/")
	public String create(@ModelAttribute("cidade") Cidade cidade, Model model) {
		this.cidadeRepository.save(cidade);
		return "redirect:/cidades";
	}
	
	@GetMapping("/{id}")
	public String editarCidade(@PathVariable("id") Long id, Model model) {
		model.addAttribute("cidade", this.cidadeRepository.findOne(id));
		return "cidades/edit";
	}
	
	@PutMapping("{id}")
	public String update(@PathVariable("id") Long id, @ModelAttribute Cidade cidade ,Model model) {
		Cidade cidadeExistente = this.cidadeRepository.findOne(id);
		
		if (cidadeExistente != null) {
			cidadeExistente.setId(cidade.getId());
			cidadeExistente.setNome(cidade.getNome());
			
			this.cidadeRepository.save(cidadeExistente);
		}
		
		return "redirect:/cidades"; 
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		Cidade cidade = this.cidadeRepository.findOne(id);
		
		if (cidade != null) {
			this.cidadeRepository.delete(cidade);
		}
		
		return "redirect:/cidades";
	}
	
}
