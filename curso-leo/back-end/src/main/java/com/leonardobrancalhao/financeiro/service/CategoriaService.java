package com.leonardobrancalhao.financeiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardobrancalhao.financeiro.model.Categoria;
import com.leonardobrancalhao.financeiro.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> listar() {
		return repository.findAll();
	}

	public Categoria listar(Integer id) {
		if (id == null || id <= 0) {
			return null;
		}
		return repository.findById(id).get();
	}

	public void salvar(Categoria categoria) {
		if (categoria == null) {
			return;
		}

		if (categoria.getNome() == null) {
			return;
		}

		repository.save(categoria);

	}

}
