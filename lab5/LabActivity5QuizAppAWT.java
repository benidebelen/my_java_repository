import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT extends JFrame implements ActionListener {
    String[] questions = {
        "Which of the following is an input device?",
        "What is CS stands for?",
        "Which of the following is an app for coding?"
    };

    String[][] options = {
        {"A. Keyboard", "B. Printer", "C. Monitor", "D. Speaker"},
        {"A. Call Sign", "B. Computer Science", "C. Cheese Sauce", "D. Chicken Sausage"},
        {"A. Browser", "B. Visual Studio", "C. Calculator", "D. Notes"}
    };

    int[] answers = {0, 1, 1};

    JLabel questionLabel, feedbackLabel;
    JRadioButton[] choices = new JRadioButton[4];
    ButtonGroup choicesGroup;
    JButton nextButton;

    int currentQuestion = 0;
    int score = 0;

    public LabActivity5QuizAppAWT() {
        setTitle("Quiz App");
        setSize(500, 300);
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel questionPanel = new JPanel();
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionPanel.add(questionLabel);
        add(questionPanel, BorderLayout.NORTH);              

        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 20, 10));
        choicesGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            choices[i] = new JRadioButton("");
            choices[i].setFont(new Font("Dialog", Font.PLAIN, 14));
            choices[i].setForeground(Color.BLUE);
            choices[i].setBackground(Color.WHITE); 
            choicesGroup.add(choices[i]);
            centerPanel.add(choices[i]);
        }
        centerPanel.setBackground(Color.WHITE);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());

       feedbackLabel = new JLabel(" ", JLabel.CENTER);
       feedbackLabel.setForeground(Color.BLACK);
       feedbackLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
       feedbackLabel.setOpaque(true);
       bottomPanel.add(feedbackLabel, BorderLayout.NORTH);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Dialog", Font.BOLD, 14));
        nextButton.setBackground(Color.WHITE);
        nextButton.addActionListener(this);
        bottomPanel.add(nextButton, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        updateQuestion();

        setVisible(true);
    }

    public void updateQuestion() {
        questionLabel.setText(questions[currentQuestion]);
        for (int i = 0; i < 4; i++) {
            choices[i].setText(options[currentQuestion][i]);
            choices[i].setSelected(false);
        }
        feedbackLabel.setText(" ");
    }

    public void actionPerformed(ActionEvent e) {
        int selectedIndex = -1;
        for (int i = 0; i < 4; i++) {
            if (choices[i].isSelected()) {
                selectedIndex = i;
                break;
            }
        }

        if (selectedIndex == -1) {
            feedbackLabel.setText("Please select an answer.");
            return;
        }

        if (selectedIndex == answers[currentQuestion]) {
            score++;
        }

        currentQuestion++;
        if (currentQuestion < questions.length) {
            updateQuestion();
        } else {
            questionLabel.setText("You got " + score + " out of " + questions.length + " correct!");
            for (JRadioButton cb : choices) cb.setEnabled(false);
            nextButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LabActivity5QuizAppAWT::new);
    }
}