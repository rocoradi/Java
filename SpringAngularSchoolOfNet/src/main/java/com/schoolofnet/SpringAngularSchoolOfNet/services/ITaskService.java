package com.schoolofnet.SpringAngularSchoolOfNet.services;

import java.util.List;
import java.util.Optional;

import com.schoolofnet.SpringAngularSchoolOfNet.entities.Task;

public interface ITaskService {

	List<Task> findAll();
	Optional<Task> findOne(Long id);
	Task create(Task task);
}
