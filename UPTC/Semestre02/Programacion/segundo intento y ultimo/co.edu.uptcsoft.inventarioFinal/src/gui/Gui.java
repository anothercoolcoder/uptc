package gui;

import javax.swing.*;
import java.awt.*;

public class Gui {
    public Gui() {
        menu();
    }
    /*
    * Menu usuario
    * Menu Administrador
    * */
    public static void menu(){
        String selection;
        String[] options ={"Usuario", "Administrador", "Salir"};
        do{
            selection = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona una opcion",
                    "Menu principal",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (selection == null){
                break;
            }
            switch (selection){
                case "Usuario" -> menuUser();
                case "Administrador" -> menuAdmin();
                case "Salir" -> JOptionPane.showMessageDialog(null, "Saliendo...");
                default -> JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        }while (!"Salir".equalsIgnoreCase(selection));
    }
    public static void menuUser(){
        
    }
    public static void menuAdmin(){
        String selection;
        String[] options ={"Añadir existencia", "Borrar existencia", "Actualizar existencia", "Mostrar Productos", "Salir"};
        do{
            selection = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona una opcion",
                    "Menu principal",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (selection == null){
                break;
            }
            switch (selection){
                case "Añadir existencia" -> addProduct();
                case "Borrar existencia" -> menuAdmin();
                case "Actualizar existencia" -> menuAdmin();
                case "Mostrar productos" -> menuAdmin();
                case "Salir" -> JOptionPane.showMessageDialog(null, "Saliendo...");
                default -> JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        }while (!"Salir".equalsIgnoreCase(selection));
    }
    public static void addProduct(){
        String selection;
        String[] options ={"Añadir existencia", "Borrar existencia", "Actualizar existencia", "Mostrar Productos", "Salir"};
        do{
            selection = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona una opcion",
                    "Menu principal",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (selection == null){
                break;
            }
            switch (selection){
                case "Añadir existencia" -> addProduct();
                case "Borrar existencia" -> menuAdmin();
                case "Actualizar existencia" -> menuAdmin();
                case "Mostrar productos" -> menuAdmin();
                case "Salir" -> JOptionPane.showMessageDialog(null, "Saliendo...");
                default -> JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        }while (!"Salir".equalsIgnoreCase(selection));
    }
    }
}
