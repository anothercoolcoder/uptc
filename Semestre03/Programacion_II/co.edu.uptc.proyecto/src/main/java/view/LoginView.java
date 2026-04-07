package view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    public JTextField txtUsuario;
    public JPasswordField txtPassword;
    public JButton btnIngresar;

    public LoginView() {
        setTitle("Acceso al Sistema - UPTC");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(236, 240, 241));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Usuario:"), gbc);
        
        gbc.gridx = 1;
        txtUsuario = new JTextField(15);
        add(txtUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        txtPassword = new JPasswordField(15);
        add(txtPassword, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        btnIngresar = new JButton("Iniciar Sesión");
        btnIngresar.setBackground(new Color(41, 128, 185));
        btnIngresar.setForeground(Color.WHITE);
        add(btnIngresar, gbc);
    }
}