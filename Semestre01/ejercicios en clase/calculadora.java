import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class calculadora implements ActionListener {
    private JTextField textField;
    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";

    public static void main(String[] args) {
        new calculadora().createGUI();
    }

    public void createGUI() {
        // Ventana
        JFrame frame = new JFrame("Calculadora en Java, papa");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(textField);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.DARK_GRAY);

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLACK);
            button.setBorder(new LineBorder(Color.BLACK, 2));
            button.addActionListener(this);
            panel.add(button);
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            textField.setText(textField.getText() + command);
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+" -> textField.setText(String.valueOf(num1 + num2));
                case "-" -> textField.setText(String.valueOf(num1 - num2));
                case "*" -> textField.setText(String.valueOf(num1 * num2));
                case "/" -> {
                    if (num2 == 0) {
                        textField.setText("Error: Div/0");
                    } else {
                        textField.setText(String.valueOf(num1 / num2));
                    }
                }
            }
        } else {
            num1 = Double.parseDouble(textField.getText());
            operator = command;
            textField.setText("");
        }
    }
}
