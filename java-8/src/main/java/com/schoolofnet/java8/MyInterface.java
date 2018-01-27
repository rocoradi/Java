/**
 * @author Coradi
 *
 * 12 de jan de 2018
 */
package com.schoolofnet.java8;

@FunctionalInterface
public interface MyInterface {
	void print(String s);
	
	default void body() {
		System.out.println("Este é o corpo da minha Interface funcional");
	}
}
