package view;

import javax.swing.*;
import java.awt.*;

public class SplashView extends JWindow { // JWindow no tiene bordes ni botones de cerrar
    private JProgressBar progressBar;

    public SplashView() {
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.WHITE);
        content.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2));

        // Imagen o Logo (Opcional: puedes poner un JLabel con un Icon)
        JLabel lblTexto = new JLabel("Cargando Sistema Hotelero UPTC...", SwingConstants.CENTER);
        lblTexto.setFont(new Font("Segoe UI", Font.BOLD, 18));
        content.add(lblTexto, BorderLayout.CENTER);

        // Barra de progreso
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(41, 128, 185));
        content.add(progressBar, BorderLayout.SOUTH);

        add(content);
        setSize(400, 200);
        setLocationRelativeTo(null);
    }

    public void setProgreso(int valor) {
        progressBar.setValue(valor);
    }
}