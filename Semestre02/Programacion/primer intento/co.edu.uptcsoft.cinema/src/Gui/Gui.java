package Gui;

import Control.Control;
import javax.swing.*;

public class Gui {
    public void vista() {
        int filas = 0;
        int columnas = 0;

        // Captura robusta de filas y columnas
        try {
            filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la sala:"));
            columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de asientos por fila:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar solo números. El programa se cerrará.");
            return;
        }

        Control control = new Control(filas, columnas);
        String[] opciones = {"Entrar al cine", "Salir"};
        boolean enEjecucion = true;

        while (enEjecucion) {
            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú del Cine",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {
                case 0:
                    String entrada = JOptionPane.showInputDialog("Ingrese su asiento en formato fila-columna (ej: 2-4):");

                    if (entrada == null || !entrada.matches("\\d+-\\d+")) {
                        JOptionPane.showMessageDialog(null, "Formato inválido. Use fila-columna (ej: 3-5).");
                        break;
                    }

                    String[] partes = entrada.split("-");
                    int fila = 0;
                    int columna = 0;

                    try {
                        fila = Integer.parseInt(partes[0]);
                        columna = Integer.parseInt(partes[1]);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar números válidos para fila y columna.");
                        break;
                    }

                    if (!control.asientoValido(fila, columna)) {
                        JOptionPane.showMessageDialog(null, "El asiento está fuera de rango.");
                    } else if (control.asientoOcupado(fila, columna)) {
                        JOptionPane.showMessageDialog(null, "¡Ese asiento ya está ocupado!");
                    } else {
                        control.reservarAsiento(fila, columna);
                        JOptionPane.showMessageDialog(null, "¡Asiento reservado exitosamente!");
                    }
                    break;

                case 1:
                default:
                    enEjecucion = false;
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema del cine!");
    }
}
