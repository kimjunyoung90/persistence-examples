package com.myapp.eisenhower.service;

import com.myapp.eisenhower.repository.TaskRepository;
import com.myapp.eisenhower.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task getTasks(Long id) {
        return taskRepository.findById(id);
    }
}
