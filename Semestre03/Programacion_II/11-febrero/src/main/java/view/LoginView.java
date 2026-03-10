package view;
import javax.swing.*;

import dao.UsuariosDao;

import java.awt.*;
import java.io.FileInputStream;
import java.util.Properties;

public class LoginView extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;

    public LoginView() {
        setTitle("Login - Sistema 2026");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Usuario:"));
        txtUser = new JTextField();
        add(txtUser);

        add(new JLabel("Contraseña:"));
        txtPass = new JPasswordField();
        add(txtPass);

        JButton btnLogin = new JButton("Ingresar");
        add(btnLogin);

        btnLogin.addActionListener(e -> validar());
        setVisible(true);
    }

    private void validar() {
    UsuariosDao dao = new UsuariosDao();
    
    String user = txtUser.getText();
    String pass = new String(txtPass.getPassword());

    if (dao.validarUsuario(user, pass)) {
        dispose(); 
        new EstudianteView();
    } else {
        JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        txtPass.setText(""); 
    }
}
}