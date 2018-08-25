package com.leonardobrancalhao.financeiro.service;

import java.util.List;

import com.leonardobrancalhao.financeiro.model.Categoria;
import com.leonardobrancalhao.financeiro.repository.CategoriaRepository;

public class CategoriaService {

	public List<Categoria> listar(){
		
		CategoriaRepository repository = new CategoriaRepository();
		return repository.listar();
	}
	
}
