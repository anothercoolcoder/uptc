import javax.swing.*;

public class SoloJOptionPane {
    public static void main(String[] args) {
        // Usamos un spinner DENTRO del JOptionPane
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1)); // de 0 a 100, paso 1

        int option = JOptionPane.showConfirmDialog(
                null,
                spinner,
                "Ingrese un número entero",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) {
            int value = (int) spinner.getValue();
            JOptionPane.showMessageDialog(null, "Ingresaste: " + value);
        }
    }
}
