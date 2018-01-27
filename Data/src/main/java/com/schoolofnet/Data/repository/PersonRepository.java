/**
 * @author Coradi
 *
 * 9 de jan de 2018
 */
package com.schoolofnet.Data.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.Data.models.Event;
import com.schoolofnet.Data.models.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{
	Page<Person> findByEventoId(Event eventoId, Pageable pageable);
}
