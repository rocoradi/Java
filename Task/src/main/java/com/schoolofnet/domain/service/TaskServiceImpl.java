package com.schoolofnet.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schoolofnet.domain.entity.Task;
import com.schoolofnet.domain.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepository;
	
	@Transactional
	public Iterable<Task> findAll() {
		return taskRepository.findAllQuery();
	}
	
	
	public Task create(String name) {
		Task task = new Task(name);
		taskRepository.save(task);
		return task;
	}
	
	public Task findOne(Integer id) {
		return taskRepository.findOne(id);
	}
	
	public Task update(Task task) {
		return taskRepository.save(task);
	}
	
	public void remove(Task task) {
		taskRepository.delete(task);
	}
}
