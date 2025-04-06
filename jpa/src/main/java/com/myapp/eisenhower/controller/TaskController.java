package com.myapp.eisenhower.controller;

import com.myapp.eisenhower.domain.Task;
import com.myapp.eisenhower.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskService sampleService;

    @RequestMapping("/tasks/{id}")
    public Task getTasks(@PathVariable Long id) {
        return sampleService.getTask(id);
    }
}
