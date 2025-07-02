
/*
 * TaskBoardGUI.java
 * GUI version of the task board using Java Swing.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// --- Model ---
class Task {
    private static int count = 1;
    private int id;
    private String title;
    private String description;
    private String status;

    public Task(String title, String description) {
        this.id = count++;
        this.title = title;
        this.description = description;
        this.status = "To Do";
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String toString() {
        return id + ". [" + status + "] " + title + " - " + description;
    }
}

// --- Controller ---
class TaskController {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String title, String desc) {
        tasks.add(new Task(title, desc));
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public boolean updateTaskStatus(int id, String newStatus) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }
}

// --- View ---
public class TaskBoardGUI {
    private JFrame frame;
    private JTextField titleField, descField, idField;
    private JComboBox<String> statusBox;
    private JTextArea taskList;
    private TaskController controller;

    public TaskBoardGUI() {
        controller = new TaskController();
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Task Board");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top panel (Add Task)
        JPanel topPanel = new JPanel(new GridLayout(3, 2));
        titleField = new JTextField();
        descField = new JTextField();
        JButton addButton = new JButton("Add Task");

        topPanel.add(new JLabel("Title:"));
        topPanel.add(titleField);
        topPanel.add(new JLabel("Description:"));
        topPanel.add(descField);
        topPanel.add(addButton);

        // Center (Task list)
        taskList = new JTextArea();
        taskList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Bottom panel (Update Task)
        JPanel bottomPanel = new JPanel(new GridLayout(2, 2));
        idField = new JTextField();
        statusBox = new JComboBox<>(new String[] {"To Do", "In Progress", "Done"});
        JButton updateButton = new JButton("Update Status");

        bottomPanel.add(new JLabel("Task ID:"));
        bottomPanel.add(idField);
        bottomPanel.add(statusBox);
        bottomPanel.add(updateButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Actions
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            String desc = descField.getText();
            if (!title.isEmpty()) {
                controller.addTask(title, desc);
                titleField.setText("");
                descField.setText("");
                refreshTasks();
            }
        });

        updateButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String status = (String) statusBox.getSelectedItem();
                if (controller.updateTaskStatus(id, status)) {
                    refreshTasks();
                } else {
                    JOptionPane.showMessageDialog(frame, "Task not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid ID.");
            }
        });

        frame.setVisible(true);
    }

    private void refreshTasks() {
        StringBuilder sb = new StringBuilder();
        for (Task task : controller.getAllTasks()) {
            sb.append(task).append("\n");
        }
        taskList.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskBoardGUI::new);
    }
}
