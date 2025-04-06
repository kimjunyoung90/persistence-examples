package com.myapp.eisenhower.repository;

import com.myapp.eisenhower.domain.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TaskRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Task findById(Long id) {
        return (Task) sessionFactory.getCurrentSession().get(Task.class, id);
    }

    public List<Task> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Task").list();
    }

    public void save(Task task) {
        sessionFactory.getCurrentSession().save(task);
    }

    public void update(Task task) {
        sessionFactory.getCurrentSession().update(task);
    }

    public void delete(Long id) {
        Task task = findById(id);
        if (task != null) {
            sessionFactory.getCurrentSession().delete(task);
        }
    }
}
