package com.example.TaskServer;;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import javafx.beans.property.SimpleLongProperty;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping()
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    
     @PutMapping("/{index}/complete")
    public void markTaskAsCompleted(@PathVariable int index) {
        taskService.markTaskAsCompleted(index);
    }
}

class Task {
    private final SimpleLongProperty id;
    private final SimpleStringProperty description;
    private final SimpleStringProperty status;

    public Task(Long id, String description) {
        this.id = new SimpleLongProperty(id);
        this.description = new SimpleStringProperty(description);
        this.status = new SimpleStringProperty("Pending"); // Default to Pending
    }

    // Getters for properties (required for JavaFX binding)
    public Long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(Long id) {
        this.id.set(id);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
