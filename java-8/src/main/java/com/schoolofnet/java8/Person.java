/**
 * @author Coradi
 *
 * 12 de jan de 2018
 */
package com.schoolofnet.java8;

public class Person {
	
	private String nome;
	
	
	
	public Person() {}
	
	public Person(String nome) {
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static void say(String s) {
		System.out.println("Uma nova pessoa esta dizendo algo..."+ s);
	}

}
