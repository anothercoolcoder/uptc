import view.*;
import controller.HotelController;

import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.sql.*;

import config.DbConfig;

public class Main {

    public static void main(String[] args) {

        // Ejecutar Swing en el hilo correcto
        SwingUtilities.invokeLater(() -> {

            // 1. Splash
            SplashView splash = new SplashView();
            splash.setVisible(true);

            try {
                Thread.sleep(2000); // Simulación de carga (2 segundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            splash.dispose();

            // 2. Login
            LoginView login = new LoginView();
            login.setVisible(true);

            login.btnIngresar.addActionListener(e -> autenticar(login));
        });
    }

    private static void autenticar(LoginView login) {
        String user = login.txtUsuario.getText();
        String pass = new String(login.txtPassword.getPassword());

        if (validarUsuario(user, pass)) {
            login.dispose();

            // 3. Abrir sistema principal
            HotelView vista = new HotelView();
            new HotelController(vista);
            vista.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(
                login,
                "Usuario o contraseña incorrectos",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private static boolean validarUsuario(String user, String pass) {
        String sql = "SELECT 1 FROM usuarios WHERE username = ? AND password = ?";

        try (Connection con = DbConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}