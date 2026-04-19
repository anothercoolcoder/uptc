import view.*;
import controller.HotelController;

import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.sql.*;

import config.DbConfig;

public class Main {

    public static void main(String[] args) {
    // 1. Mostrar el Splash inmediatamente
    SplashView splash = new SplashView();
    splash.setVisible(true);

    // 2. Crear un hilo de fondo para que no se congele la pantalla
    Thread hiloCarga = new Thread(() -> {
        try {
            // Simulamos la carga de la DB o archivos
            for (int i = 0; i <= 100; i += 20) {
                Thread.sleep(500); // 0.5 segundos por paso
                // Actualizamos la barra de progreso si tu SplashView tiene el método
                // SwingUtilities.invokeLater(() -> splash.setProgreso(i)); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3. Cuando termine la carga, cerramos Splash y abrimos Login en el hilo de Swing
        SwingUtilities.invokeLater(() -> {
            splash.dispose();
            
            LoginView login = new LoginView();
            login.setVisible(true);
            
            login.btnIngresar.addActionListener(e -> autenticar(login));
        });
    });

    hiloCarga.start(); // ¡Arrancamos el hilo!
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