package com.myapp.eisenhower.service;

import com.myapp.eisenhower.mapper.TaskMapper;
import com.myapp.eisenhower.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public Task getTasks(Long id) {
        return taskMapper.findById(id);
    }
}
