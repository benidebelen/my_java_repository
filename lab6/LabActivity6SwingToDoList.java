import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LabActivity6SwingToDoList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoListViewer());
    }
}

class ToDoListViewer extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private static boolean isFormOpen = false;

    public ToDoListViewer() {
        setTitle("To-Do List Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new Object[]{"Task Name", "Task Description", "Status"}, 0);
        table = new JTable(tableModel);
       
        addButton = new JButton("Add Task");
        addButton.addActionListener(e -> {
            if (!isFormOpen) {
                isFormOpen = true;
                new ToDoForm(ToDoListViewer.this);
            }
        });

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(addButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        setVisible(true);
    }

    public void addTask(String name, String description, String status) {
        tableModel.addRow(new Object[]{name, description, status});
    }

    public void setFormOpen(boolean open) {
        isFormOpen = open;
    
    }
}

class ToDoForm extends JFrame {
    private JTextField nameField;
    private JTextArea descArea;
    private JComboBox<String> statusBox;
    private JButton saveButton;

    public ToDoForm(ToDoListViewer parent) {
        setTitle("Add New Task");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                parent.setFormOpen(false);
                dispose();
            }
        });

        JPanel formPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(Color.PINK);

        formPanel.add(new JLabel("Task Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);
        formPanel.setBackground(Color.decode("#FFB6C1"));

        formPanel.add(new JLabel("Task Description:"));
        descArea = new JTextArea(3, 20);
        formPanel.add(new JScrollPane(descArea));
        formPanel.setBackground(Color.decode("#FFB6C1"));

        formPanel.add(new JLabel("Status:"));
        statusBox = new JComboBox<>(new String[]{"Not Started", "Ongoing", "Completed"});
        formPanel.add(statusBox);
        formPanel.setBackground(Color.decode("#FFB6C1"));

        add(formPanel, BorderLayout.CENTER);

        saveButton = new JButton("Save Task");
        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String desc = descArea.getText().trim();
            String status = (String) statusBox.getSelectedItem();

            if (name.isEmpty() || desc.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            parent.addTask(name, desc, status);
            parent.setFormOpen(false);
            dispose();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}