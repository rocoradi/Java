package com.schoolofnet.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.schoolofnet.domain.entity.Task;

@Transactional
public interface TaskRepository extends CrudRepository<Task, Integer>{
	
	@Query(name="select T from Task T")
	Iterable<Task> findAllQuery();
	
	@Query(name="select * from task", nativeQuery=true)
	Iterable<Task> findAllNativeQuery();

}
