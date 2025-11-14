package gui;

import control.Control;

import javax.swing.*;

public class Gui {
    Control control = new Control();
    public Gui() {
        menu();
    }
    public void menu(){
        String selection;
        do {
            String[] options = {"Registrar","Votar", "Salir"};

            selection = (String) JOptionPane.showInputDialog(
                    null,
                    "Elija la opcion deseada",
                    "Menu principal",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            switch (selection){
                case "Registrar" -> registerVoter();
                case "Salir" -> {
                    JOptionPane.showMessageDialog(null, "Saliendo");
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                }
            }
        }while (selection != "Salir");

    }

    public void registerVoter(){
        String id =JOptionPane.showInputDialog(
                null,
                "Ingrese su cedula",
                "Menu principal",
                JOptionPane.QUESTION_MESSAGE
        );

        String name =JOptionPane.showInputDialog(
                null,
                "Ingrese su nombre",
                "Menu principal",
                JOptionPane.QUESTION_MESSAGE
        );
        JOptionPane.showMessageDialog(null,control.createVoter(id,name));
    }

}
