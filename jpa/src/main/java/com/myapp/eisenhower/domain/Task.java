package com.myapp.eisenhower.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private boolean isUrgent;
    private boolean isImportant;
    private Date dueDate;
    private boolean completed;
    private Date createdAt;
    private Date updatedAt;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getIsUrgent() { return isUrgent; }
    public void setIsUrgent(boolean isUrgent) { this.isUrgent = isUrgent; }

    public boolean getIsImportant() { return isImportant; }
    public void setIsImportant(boolean isImportant) { this.isImportant = isImportant; }

    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public boolean getCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
