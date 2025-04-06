package com.myapp.eisenhower.repository;

import com.myapp.eisenhower.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    //기본 CRUD 기능 자동 제공
}
