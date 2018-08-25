package com.leonardobrancalhao.financeiro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {
	
	@GetMapping
	public ResponseEntity<?> teste() {
		return new ResponseEntity<>("Retornando Erro", HttpStatus.INTERNAL_SERVER_ERROR)  ;
	}
	
	@PostMapping
	public ResponseEntity<?> post(){
		return new ResponseEntity<>("requisicao post", HttpStatus.OK);
	}
	
	

}
