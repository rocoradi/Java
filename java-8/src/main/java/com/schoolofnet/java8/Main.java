/**
 * @author Coradi
 *
 * 11 de jan de 2018
 */
package com.schoolofnet.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import java.awt.Scrollbar;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
//      List<String> strs = Arrays.asList("Leonan", "SON", "Java 8", "Leonidas");
//      for (String str: strs) {
//          System.out.println(str);
//      }
//
//      System.out.println("LAMBDAS!");
//
//      Person.say();
//
//      strs.forEach(str -> System.out.println(str));
//
//      List<String> result = strs.stream()
//                                .filter(str -> str.startsWith("L"))
//                                .collect(Collectors.toList());
//      result.forEach(Person::say);
      
      //java 7
//      MyInterface myInterface = new MyInterface() {
//		@Override
//		public void print() {
//			System.out.println("Java 7 implementação - Interface funcional.");
//		}
//      };  
//      myInterface.print();
      
      //java 8
//      MyInterface my1 = (String s) -> {System.out.println("Java 8 implementação - Interface funcional " + s);};
//      my1.print();
//      result.forEach(my1::print); //:: = method reference
//      my1.body();
      
      // STREAMS //
//      List<Integer> numbers = Arrays.asList(1,2,3,4,0,9,10,0);
//      List<String> texts = Arrays.asList("a","b","c","","","","e","f","g");
      
      //Processamento da STREAM em computacao pararela
//      List<Integer> filteredNumbers = numbers.parallelStream()
//    		  								 .filter(number -> number != 0)
//    		  								 .collect(Collectors.toList());
      //Processamento de forma normal
//      List<String> filteredTexts = texts.stream()
//    		  							.filter(str -> !str.isEmpty())
//    		  							.collect(Collectors.toList());
      
      //Transformando em uma String separada por virgulas
//      String filteredString = texts.stream()
//							       .filter(str -> !str.isEmpty())
//								   .collect(Collectors.joining(","));
//      
//      filteredNumbers.forEach(System.out::println);
//      filteredTexts.forEach(System.out::println);
//      System.out.println(filteredString);
//      
//      Random hash = new Random();
//      hash.doubles()
//      	  .limit(2)
//      	  .forEach(System.out::println);
		
//		List<Person> pessoas = new ArrayList<Person>();
//		
//		Person person1 = new Person("Rodrigo");
//		Person person2 = new Person("Maria");
//		Person person3 = new Person("Alice");
//		Person person4 = new Person(null);
//		
//		pessoas.add(person1);
//		pessoas.add(person2);
//		pessoas.add(person3);
//		pessoas.add(person4);
//		
//		String name = person4.getNome();
//		
//		// OPTIONAL //
//		Optional<String> op = Optional.ofNullable(name);
//		op.ifPresent(System.out::println);
//	
//		pessoas.forEach(p -> {
//			System.out.println(p.getNome());
//		});
		
		//Data-Time_API
//		Instant now = Instant.now();
//		
//		Thread.sleep(1000);
//		
//		Instant now2 = Instant.now();
//		Duration dur = Duration.between(now, now2);
//		
//		System.out.println(dur.getSeconds());
//		
//		LocalDate local = LocalDate.now();
//		System.out.println(local.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//		
//		LocalDate niver1 = LocalDate.of(1991, 06, 26);
//		LocalDate niver2 = LocalDate.of(2018, 01, 12);
//		
//		Period periodo = Period.between(niver1, niver2);
//		
//		System.out.printf("Idade: "+"%s"+" anos, "+"%s"+" meses e "+"%s"+" dias.", periodo.getYears(), periodo.getMonths(), periodo.getDays());
		
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
		
		try {
			nashorn.eval("print('HELLO WORLD FROM NASHORN')");
		} catch (ScriptException ex) {
			ex.getStackTrace();
		}
	}

}
