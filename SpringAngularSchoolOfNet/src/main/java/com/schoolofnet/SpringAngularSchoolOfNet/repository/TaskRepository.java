package com.schoolofnet.SpringAngularSchoolOfNet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.SpringAngularSchoolOfNet.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	

}
