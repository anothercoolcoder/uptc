import javax.swing.*;

public class FormularioMultiple {
    public static void main(String[] args) {
        JTextField nombre = new JTextField();
        JTextField edad = new JTextField();
        JTextField correo = new JTextField();
        JTextField ciudad = new JTextField();

        Object[] message = {
            "Nombre:", nombre,
            "Edad:", edad,
            "Correo:", correo,
            "Ciudad:", ciudad
        };

        int option = JOptionPane.showConfirmDialog(
                null,
                message,
                "Formulario de usuario",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) {
            String info = """
                    Datos ingresados:
                    Nombre: %s
                    Edad: %s
                    Correo: %s
                    Ciudad: %s
                    """.formatted(
                    nombre.getText(),
                    edad.getText(),
                    correo.getText(),
                    ciudad.getText()
            );
            JOptionPane.showMessageDialog(null, info);
        } else {
            JOptionPane.showMessageDialog(null, "Formulario cancelado.");
        }
    }
}
 