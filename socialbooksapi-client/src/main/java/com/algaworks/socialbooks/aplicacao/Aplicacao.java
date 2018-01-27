/**
 * @author Coradi
 *
 * 29 de dez de 2017
 */
package com.algaworks.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.algaworks.socialbooks.client.LivrosClient;
import com.algaworks.socialbooks.client.domain.Livro;

public class Aplicacao {
	
	public static void main(String[] args) throws ParseException {
		
		LivrosClient client = new LivrosClient("http://localhost:8080","algaworks","s3nh4");
		
		//Listando todos os livros pela API
		List<Livro> listaLivros = client.listar();
		for (Livro livro : listaLivros) {
			System.out.println("Livro: " + livro.getNome());
		}
		
		//Criando um novo livro pela API
		Livro livro = new Livro();
		livro.setNome("Spring na pratica");
		livro.setEditora("AlgaWorks");
		
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("29/12/2017"));
		
		livro.setResumo("Este livro aborda técnicas de desenvolvimento de APIs.");
		
		String localizacao = client.salvar(livro);
		System.out.println("URI do livro salvo: "+ localizacao);
		
		//Listando o livro específico salvo
		Livro livroBuscado = client.buscar(localizacao);
		System.out.println("Livro buscado: " + livroBuscado.getNome());
		
		
		
	}

}
