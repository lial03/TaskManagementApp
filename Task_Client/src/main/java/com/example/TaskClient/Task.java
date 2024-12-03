package com.example.TaskClient;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Task {
    private final SimpleLongProperty id;
    private final SimpleStringProperty description;
    private final SimpleStringProperty status;

    public Task(long id, String description) {
        this.id = new SimpleLongProperty(id);
        this.description = new SimpleStringProperty(description);
        this.status = new SimpleStringProperty("Pending");
    }

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
