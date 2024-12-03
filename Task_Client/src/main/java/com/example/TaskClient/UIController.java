package com.example.TaskClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class UIController {
    @FXML
    private TableView<Task> tasks;
    @FXML
    private Button addTask;
    @FXML
    private Button deleteTask;
    @FXML
    private Button markCompleted;

    private final ObservableList<Task> taskList = FXCollections.observableArrayList();
    private long taskIdCounter = 1;

    @FXML
    public void initialize() {
        TableColumn<Task, Long> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());

        TableColumn<Task, String> descriptionColumn = new TableColumn<>("Task");
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());

        TableColumn<Task, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        tasks.getColumns().setAll(idColumn, descriptionColumn, statusColumn);
        tasks.setItems(taskList);
        
    }


    @FXML
    public void add(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Task");
        dialog.setHeaderText("Enter task description:");
        dialog.setContentText("Task:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(description -> {
            Task newTask = new Task(taskIdCounter++, description);
            taskList.add(newTask);
        });
    }

    @FXML
    public void delete(ActionEvent event) {
        Task selectedTask = tasks.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            taskList.remove(selectedTask);
        }
    }

    @FXML
    public void markAsCompleted(ActionEvent event) {
        Task selectedTask = tasks.getSelectionModel().getSelectedItem();
        if (selectedTask != null && "Pending".equals(selectedTask.getStatus())) {
            selectedTask.setStatus("Completed");
        }
    }

}
