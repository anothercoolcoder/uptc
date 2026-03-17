package gui;

import javax.swing.*;
import java.awt.*;
import dao.UsuariosDAO;
import view.EstudianteView;

public class login extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;

    public login() {

        setTitle("Sistema de Estudiantes");
        setSize(400, 300);
        setLocationRelativeTo(null); // center window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ----- TITLE -----
        JLabel title = new JLabel("Inicio de Sesión", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        // ----- CENTER PANEL -----
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));

        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();

        centerPanel.add(new JLabel("Usuario"));
        centerPanel.add(txtUsuario);
        centerPanel.add(new JLabel("Contraseña"));
        centerPanel.add(txtPassword);

        add(centerPanel, BorderLayout.CENTER);

        // ----- BUTTON PANEL -----
        JPanel buttonPanel = new JPanel();

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setPreferredSize(new Dimension(120, 35));

        buttonPanel.add(btnEntrar);
        add(buttonPanel, BorderLayout.SOUTH);

        // ----- LOGIN LOGIC -----
        btnEntrar.addActionListener(e -> {

            String user = txtUsuario.getText();
            String password = new String(txtPassword.getPassword());

            UsuariosDAO us = new UsuariosDAO();

            if (us.validarUsuario(user, password)) {

                EstudianteView window = new EstudianteView();
                window.setVisible(true);

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Usuario o contraseña incorrectos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }
}