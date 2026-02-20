package Gui;

import Logic.Estudiante;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Gui {
    private Set<Estudiante> estudiantesDentro = new HashSet<>();
    public void vista(){
            JOptionPane.showMessageDialog(null, "Buenos dias, bienvenido");
        while(true){
            Object[] options = {"Entrar", "Salir"};
            String choice = (String) JOptionPane.showInputDialog(
                    null,
                    "Elija una opcion",
                    "Opciones",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (choice == null){
                JOptionPane.showMessageDialog(null, "Saliendo");
                return;
            }
            switch (choice){
                case "Entrar":
                    entrada();
                    break;
                case "Salir":
                    salida();
                    break;
            }

        }

    }
    public void entrada(){
        int codigo = pedirCodigo();
        String nombre = pedirNombre();

        Estudiante nuevo = new Estudiante(codigo);

        if (estudiantesDentro.contains(nuevo)) {
            JOptionPane.showMessageDialog(null, "Ya ha entrado. Debe salir antes de volver a entrar.");
        } else {
            estudiantesDentro.add(nuevo);
            JOptionPane.showMessageDialog(null, "Entrada registrada. Bienvenido " + nombre);
        }
    }
    public void salida(){
        int codigo = pedirCodigo();
        Estudiante temp = new Estudiante(codigo); // El nombre no interesa

        if (estudiantesDentro.contains(temp)) {
            estudiantesDentro.remove(temp);
            JOptionPane.showMessageDialog(null, "Salida registrada.");
        } else {
            JOptionPane.showMessageDialog(null, "No ha ingresado previamente.");
        }
    }
    public int pedirCodigo() {
        while (true) {
            try {
                String codigo = JOptionPane.showInputDialog(null, "Ingrese su código (9 dígitos)");

                if (codigo == null) throw new NumberFormatException("Operación cancelada.");

                if (codigo.matches("\\d{9}")) {
                    return Integer.parseInt(codigo);
                } else {
                    throw new NumberFormatException("El código debe tener exactamente 9 dígitos numéricos.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido: " + e.getMessage());
            }

        }
    }
    public String pedirNombre() {
        while (true) {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre");
            if (nombre != null && !nombre.trim().isEmpty()) {
                return nombre.trim();
            } else {
                JOptionPane.showMessageDialog(null, "Nombre inválido");
            }
        }
    }
}
