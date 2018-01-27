/**
 * @author Coradi
 *
 * 9 de jan de 2018
 */
package com.schoolofnet.Data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pessoas")
public class Person {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "evento_id")
	@JsonBackReference
	private Event eventoId;
	
	

	public Person() {}
	
	public Person(Long id, String nome, Event eventoId) {
		this.setId(id);;
		this.setNome(nome);;
		this.setEventoId(eventoId);
	}
	
	public Person(String nome, Event event) {
		this.setNome(nome);
		this.setEventoId(event);
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
	
	public Event getEventoId() {
		return eventoId;
	}

	public void setEventoId(Event eventoId) {
		this.eventoId = eventoId;
	}
	
}
