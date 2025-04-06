package com.myapp.eisenhower.service;

import com.myapp.eisenhower.repository.TaskRepository;
import com.myapp.eisenhower.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.update(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.delete(id);
    }
}
