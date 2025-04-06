package com.myapp.eisenhower.repository;

import com.myapp.eisenhower.domain.Task;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Task findById(Long id) {
        return entityManager.find(Task.class, id);
    }

    public List<Task> findAll() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    public void save(Task task) {
        entityManager.persist(task);
    }

    public void update(Task task) {
        entityManager.merge(task);
    }

    public void delete(Long id) {
        Task task = findById(id);
        if (task != null) {
            entityManager.remove(task);
        }
    }
}
