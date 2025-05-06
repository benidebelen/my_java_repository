import java.awt.*;
import java.awt.event.*;

public class  LabActivity4EmpInfoSystemGUI extends Frame implements ActionListener {

    private Label firstNameLabel, lastNameLabel, ageLabel, hoursLabel, wageLabel, outputLabel;
    private TextField firstNameText, lastNameText, ageText, hoursText, wageText;
    private Button submitButton;
    private TextArea outputArea;
    private Panel inputPanel;
    private Panel outputPanel; 
    private Panel buttonPanel;

    public LabActivity4EmpInfoSystemGUI() {
        setTitle("Laboratory Activity 4");
        setLayout(new BorderLayout(10, 10));
        setSize(400, 450); 
        setLocationRelativeTo(null);
        setResizable(false);

        inputPanel = new Panel(new GridLayout(5, 2, 5, 5));
        firstNameLabel = new Label("First Name");
        lastNameLabel = new Label("Last Name");
        ageLabel = new Label("Age");
        hoursLabel = new Label("Hours Worked");
        wageLabel = new Label("Hourly Rate");
        firstNameText = new TextField(20);
        lastNameText = new TextField(20);
        ageText = new TextField(5);
        hoursText = new TextField(10);
        wageText = new TextField(10);
        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameText);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameText);
        inputPanel.add(ageLabel);
        inputPanel.add(ageText);
        inputPanel.add(hoursLabel);
        inputPanel.add(hoursText);
        inputPanel.add(wageLabel);
        inputPanel.add(wageText);

        buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        submitButton = new Button("Submit");
        submitButton.addActionListener(this);
        buttonPanel.add(submitButton);

        outputPanel = new Panel(new BorderLayout());
        outputLabel = new Label("Output:");
        outputArea = new TextArea(5, 35);
        outputArea.setEditable(false);
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(outputArea, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton) {
            String firstName = firstNameText.getText().trim();
            String lastName = lastNameText.getText().trim();
            String ageStr = ageText.getText().trim();
            String hoursStr = hoursText.getText().trim();
            String wageStr = wageText.getText().trim();

            if (firstName.isEmpty() || lastName.isEmpty() || ageStr.isEmpty() || hoursStr.isEmpty() || wageStr.isEmpty()) {
                outputArea.setText("Error: All fields must be filled out.");
                return;
            }

            try {
                int age = Integer.parseInt(ageStr);
                double hoursWorked = Double.parseDouble(hoursStr);
                double hourlyWage = Double.parseDouble(wageStr);

                String fullName = firstName + " " + lastName;
                double dailyWage = hoursWorked * hourlyWage;

                outputArea.setText(String.format("Full Name: %s\nAge: %d years old\nDaily Salary: PHP %.2f",
                        fullName, age, dailyWage));

            } catch (NumberFormatException nfe) {
                if (!ageStr.matches("\\d*")) {
                    outputArea.setText("Error: Age must be a valid integer.");
                } else {
                    outputArea.setText("Error: Hours worked and hourly rate must be valid numbers.");
                }
            } catch (Exception ex) {
                outputArea.setText("An unexpected error occurred.");
            }
        }
    }

    public static void main(String[] args) {
        new LabActivity4EmpInfoSystemGUI();
    }
}