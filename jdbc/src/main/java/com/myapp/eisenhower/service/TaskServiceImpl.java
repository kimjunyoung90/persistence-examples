package com.myapp.eisenhower.service;

import com.myapp.eisenhower.dao.TaskDao;
import com.myapp.eisenhower.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Override
    public Task getTasks(Long id) {
        return taskDao.findById(id);
    }
}
