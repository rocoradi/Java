package com.schoolofnet.domain.service;

import com.schoolofnet.domain.entity.Task;

public interface TaskService {
	
	Iterable<Task> findAll();
	Task create(String name);
	Task findOne(Integer id);
	Task update(Task task);
	void remove(Task task);

}
