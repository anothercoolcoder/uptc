// package parcial2_andres_nino.view;

// import javax.swing.*;
// import java.awt.*;
// import parcial2_andres_nino.controller.ClienteController;
// import parcial2_andres_nino.dao.ClienteDao;
// import parcial2_andres_nino.model.ClienteModel;

// public class RegistroView extends JFrame{
//     public JTextField txtId;
//     public JTextField txtNombre;
//     public JTextField txtEdad;
//     public JTextField txtEmail;
//     public JTextField txtLicencia;
//     public JTextField txtPrestamos;
//     public JTextField txtDeudas;
//     public JTextField txtEstado;


//     public JPasswordField txtPassword;
//     public JPasswordField txtConfirmPassword;
//     public JButton btnRegistrar;
//     public JButton btnCancelar;
//     public ClienteController clienteController;
    
//     public void registrar() {
//         int id = Integer.parseInt(txtId.getText());
//         String nombre = txtNombre.getText();
//         int edad = Integer.parseInt(txtEdad.getText());
//         boolean licencia = Boolean.parseBoolean(txtLicencia.getText());
//         int prestamos = Integer.parseInt(txtPrestamos.getText());
//         boolean deudas = Boolean.parseBoolean(txtDeudas.getText());
//         boolean estado = Boolean.parseBoolean(txtEstado.getText());

//         String password = new String(txtPassword.getPassword());
//         String confirmPassword = new String(txtConfirmPassword.getPassword());
        
//         // if (id.isEmpty() || nombre.isEmpty() || edad.isEmpty() || licencia || password.isEmpty()) {
//         //     JOptionPane.showMessageDialog(this, "Por favor complete todos los campos");
//         //     return;
//         // }
        
//         if (!password.equals(confirmPassword)) {
//             JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
//             return;
//         }
        
//         if (clienteController.registrarUsuario(id, nombre, edad, licencia, confirmPassword, prestamos, deudas, estado)) {
//             JOptionPane.showMessageDialog(this, "Registro exitoso! Por favor inicie sesión");
//             volverMain();
//         } else {
//             JOptionPane.showMessageDialog(this, "El email ya está registrado");
//         }
//     }
//     private void volverMain() {
//         new MainView().setVisible(true);
//         dispose();
//     }
// }
