/**
 * @author Coradi
 *
 * 9 de jan de 2018
 */
package com.schoolofnet.Data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.schoolofnet.Data.models.Event;
import com.schoolofnet.Data.models.Person;
import com.schoolofnet.Data.repository.EventRepository;
import com.schoolofnet.Data.repository.PersonRepository;

@RestController
@RequestMapping("/eventos/{eventoId}/pessoas")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	public PersonController(PersonRepository personRepository, EventRepository eventRepository) {
		this.personRepository = personRepository;
		this.eventRepository = eventRepository;
	}
	
	@GetMapping
	@ResponseBody
	public Page<Person> findAll(@PathVariable("eventoId") Long eventoId, Pageable pageable){
		Event event = this.eventRepository.findOne(eventoId);
		
		Page<Person> people = this.personRepository.findByEventoId(event, pageable);
		
		return people;
		
//		Event event = this.eventRepository.findOne(eventoId);
		
//		List<Person> people = event.getPeople().stream().collect(Collectors.toList());
//		return people;
	}
	
	@PostMapping
	@ResponseBody
	public Person create(@PathVariable("eventoId") Long eventoId, @RequestBody Person person) {
		Event event = this.eventRepository.findOne(eventoId);
		person.setEventoId(event);
		return this.personRepository.save(person);
	}

}
