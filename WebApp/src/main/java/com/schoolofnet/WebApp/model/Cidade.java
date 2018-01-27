/**
 * @author Coradi
 *
 * 10 de jan de 2018
 */
package com.schoolofnet.WebApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidades")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	
	public Cidade() {}
	
	public Cidade(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Cidade(String nome) {
		this.nome = nome;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
