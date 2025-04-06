package com.myapp.eisenhower.dao;

import com.myapp.eisenhower.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Task findById(Long id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Task.class), id);
    }

    @Override
    public List<Task> findAllByUser(Long userId) {
        String sql = "SELECT * FROM tasks WHERE user_id = ? ORDER BY due_date ASC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Task.class), userId);
    }

    @Override
    public void insert(Task task) {
        String sql = """
            INSERT INTO tasks (user_id, title, description, is_urgent, is_important, due_date, completed)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;
        jdbcTemplate.update(sql,
                task.getUserId(),
                task.getTitle(),
                task.getDescription(),
                task.isUrgent(),
                task.isImportant(),
                task.getDueDate(),
                task.isCompleted()
        );
    }

    @Override
    public void update(Task task) {
        String sql = """
            UPDATE tasks
            SET title = ?, description = ?, is_urgent = ?, is_important = ?, due_date = ?, completed = ?
            WHERE id = ?
        """;
        jdbcTemplate.update(sql,
                task.getTitle(),
                task.getDescription(),
                task.isUrgent(),
                task.isImportant(),
                task.getDueDate(),
                task.isCompleted(),
                task.getId()
        );
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM tasks WHERE id = ?", id);
    }
}
