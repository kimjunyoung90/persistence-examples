package com.myapp.eisenhower.dao;

import com.myapp.eisenhower.model.Task;

import java.util.List;

public interface TaskDao {
    public void insert(Task task);
    public void update(Task task);
    public void delete(Long id);
    public Task findById(Long id);
    public List<Task> findAllByUser(Long id);
}
