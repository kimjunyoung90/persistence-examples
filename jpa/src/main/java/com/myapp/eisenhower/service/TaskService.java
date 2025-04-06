package com.myapp.eisenhower.service;


import com.myapp.eisenhower.domain.Task;

import java.util.List;

public interface TaskService {
    Task getTask(Long id);
    List<Task> getTasks();
    void saveTask(Task task);
    void updateTask(Task task);
    void deleteTask(Long id);
}
