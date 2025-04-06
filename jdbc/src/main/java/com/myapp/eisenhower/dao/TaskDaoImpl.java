package com.myapp.eisenhower.dao;

import com.myapp.eisenhower.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private DataSource dataSource;

    public Task findById(Long id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToTask(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Find failed", e);
        }
        return null;
    }

    public List<Task> findAllByUser(Long userId) {
        List<Task> list = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE user_id = ? ORDER BY due_date";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRowToTask(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Find by userId failed", e);
        }
        return list;
    }

    public void insert(Task task) {
        String sql = """
            INSERT INTO tasks (user_id, title, description, is_urgent, is_important, due_date, completed, created_at, updated_at)
            VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW())
        """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, task.getUserId());
            ps.setString(2, task.getTitle());
            ps.setString(3, task.getDescription());
            ps.setBoolean(4, task.isUrgent());
            ps.setBoolean(5, task.isImportant());
            ps.setTimestamp(6, new Timestamp(task.getDueDate().getTime()));
            ps.setBoolean(7, task.isCompleted());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    task.setId(rs.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Insert failed", e);
        }
    }

    public void update(Task task) {
        String sql = """
            UPDATE tasks
            SET title = ?, description = ?, is_urgent = ?, is_important = ?, due_date = ?, completed = ?, updated_at = NOW()
            WHERE id = ?
        """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setBoolean(3, task.isUrgent());
            ps.setBoolean(4, task.isImportant());
            ps.setTimestamp(5, new Timestamp(task.getDueDate().getTime()));
            ps.setBoolean(6, task.isCompleted());
            ps.setLong(7, task.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Update failed", e);
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Delete failed", e);
        }
    }

    private Task mapRowToTask(ResultSet rs) throws SQLException {
        Task task = new Task();
        task.setId(rs.getLong("id"));
        task.setUserId(rs.getLong("user_id"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setUrgent(rs.getBoolean("is_urgent"));
        task.setImportant(rs.getBoolean("is_important"));
        task.setDueDate(rs.getTimestamp("due_date"));
        task.setCompleted(rs.getBoolean("completed"));
        task.setCreatedAt(rs.getTimestamp("created_at"));
        task.setUpdatedAt(rs.getTimestamp("updated_at"));
        return task;
    }
}
