// package parcial2_andres_nino.view;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JPanel;

// import parcial2_andres_nino.controller.ClienteController;

// import java.awt.*;


// public class MainView extends JFrame{
//     public JButton btnRegistrar;
//     public ClienteController clienteController;
//     public void initComponents(){
        
//         setTitle("Parqueadero");
//         setSize(400, 300);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         JPanel mainPanel = new JPanel(new GridBagLayout());
//         setLocationRelativeTo(null);
//         btnRegistrar = new JButton("Registrarse");
//             btnRegistrar.setBackground(new Color(64, 64, 64));
//             btnRegistrar.setForeground(Color.WHITE);
//             btnRegistrar.setFocusPainted(false);
//             mainPanel.add(btnRegistrar);
//             btnRegistrar.addActionListener(e -> abrirRegistro());
//     }
    
//     public void abrirRegistro() {
//         new RegistroView().setVisible(true);
//         dispose();
//     }
// }
