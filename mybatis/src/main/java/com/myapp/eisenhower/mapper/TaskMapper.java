package com.myapp.eisenhower.mapper;

import com.myapp.eisenhower.model.Task;

import java.util.List;

public interface TaskMapper {
    Task findById(Long id);
    List<Task> findByUserId(Long userId);
    void insert(Task task);
    void update(Task task);
    void delete(Long id);
}
