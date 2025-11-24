package gui;

import control.Control;

import javax.swing.*;
import java.awt.*;

public class Gui {
    Control control = new Control();
    ImageIcon raw = new ImageIcon("src/icons/user.png");
    Image scaled = raw.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    Icon user = new ImageIcon(scaled);
    ImageIcon rawAdmin = new ImageIcon("src/icons/admin.png");
    Image scaledAdmin = rawAdmin.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    Icon admin = new ImageIcon(scaledAdmin);

    public Gui() {
        menu();
    }
    public void menu(){
        String selection;
        String[] options ={"Usuario", "Administrador", "Salir"};
        do{
            selection = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona una opcion",
                    "Menu principal",
                    JOptionPane.QUESTION_MESSAGE,
                    admin,
                    options,
                    options[0]
            );
            if (selection == null){
                break;
            }
            switch (selection){
                case "Usuario" -> menuUser();
                case "Administrador" -> menuAdmin();
                case "Salir" -> JOptionPane.showMessageDialog(null, "Saliendo...","Hasta luego",JOptionPane.INFORMATION_MESSAGE,admin);
                default -> JOptionPane.showMessageDialog(null, "Opcion invalida","Error",JOptionPane.ERROR_MESSAGE,admin);
            }
        }while (!"Salir".equalsIgnoreCase(selection));
    }
    public void menuUser(){
        String selection;

        String[] options = {"Pedir un producto","Salir"};
        do {
            selection = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona una opcion",
                    "Menu principal",
                    JOptionPane.QUESTION_MESSAGE,
                    user,
                    options,
                    options[0]
            );
            if (selection == null){
                break;
            }
            switch (selection){
                case "Pedir un producto" -> askProduct();
                case "Salir" -> JOptionPane.showMessageDialog(
                        null,
                        "Saliendo...",
                        "Hasta luego",
                        JOptionPane.INFORMATION_MESSAGE,
                        user
                );
                default -> JOptionPane.showMessageDialog(
                        null,
                        "Opcion invalida",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        user
                );
            }
        }while (!"Salir".equalsIgnoreCase(selection));
    }
    public void askProduct() {
        String[] options = control.Ids();
        if (options == null || options.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos disponible","Informacion inventario",JOptionPane.ERROR_MESSAGE,user);
            return;
        }

        String selection = (String) JOptionPane.showInputDialog(
                null,
                "Elije el id del producto",
                "Ordenar producto",
                JOptionPane.QUESTION_MESSAGE,
                user,
                options,
                options[0]
        );

        if (selection == null) return;

        JTextField amountField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Cantidad: "));
        panel.add(amountField);

        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Producto solicitado",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                user
        );

        if (result != JOptionPane.OK_OPTION) return;

        int amount = -1;

        while (true) {
            try {
                amount = Integer.parseInt(amountField.getText());
                if (amount <= 0) {
                    throw new IllegalArgumentException("Cantidad debe ser positiva.");
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Ingrese un numero valido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        user
                );
                amountField.setText("");

                int retry = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "Solicitar un producto",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.ERROR_MESSAGE,
                        user
                );
                if (retry != JOptionPane.OK_OPTION) return;

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Cantidad debe ser positiva.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        user
                );
                amountField.setText("");

                int retry = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "Request product",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.ERROR_MESSAGE,
                        user
                );
                if (retry != JOptionPane.OK_OPTION) return;
            }
        }

        String message = control.askProduct(selection, String.valueOf(amount));
        JOptionPane.showMessageDialog(null, message);
    }
    public void menuAdmin(){
        String selection;
        String[] options ={"Añadir existencia", "Borrar existencia", "Actualizar existencia", "Mostrar productos", "Salir"};
        do{
            selection = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona una opcion",
                    "Menu principal",
                    JOptionPane.QUESTION_MESSAGE,
                    admin,
                    options,
                    options[0]
            );
            if (selection == null){
                break;
            }
            switch (selection){
                case "Añadir existencia" -> addProduct();
                case "Borrar existencia" -> deleteProduct();
                case "Actualizar existencia" -> updateProduct();
                case "Mostrar productos" -> showProducts();
                case "Salir" -> JOptionPane.showMessageDialog(null, "Saliendo...","Hasta luego",JOptionPane.INFORMATION_MESSAGE,admin);
                default -> JOptionPane.showMessageDialog(null, "Opcion invalida", "Error",JOptionPane.ERROR_MESSAGE,admin);
            }
        }while (!"Salir".equalsIgnoreCase(selection));
    }
    public void addProduct() {
        JTextField amountField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JComboBox<String> categoryBox = new JComboBox<>(new String[]{"Papeleria","Aseo","Miscelanea"});

        JPanel panel = new JPanel(); // mandar vacio
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Cantidad: "));
        panel.add(amountField);
        panel.add(new JLabel("Nombre: "));
        panel.add(nameField);
        panel.add(new JLabel("Categoria: "));
        panel.add(categoryBox);

        int result = JOptionPane.showConfirmDialog(null, panel, "Añada un producto",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,admin);
        if (result == JOptionPane.OK_OPTION){
                String name = nameField.getText();
                int amount = -1;
                String category = (String) categoryBox.getSelectedItem();
            while (true){
                try{
                    amount = Integer.parseInt(amountField.getText());
                    if (amount <= 0){
                        throw new IllegalArgumentException("La cantidad ha de ser positiva");
                    }
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Entre un numero valido para cantidad",
                            "Error",
                            JOptionPane.ERROR_MESSAGE,
                            admin);
                    amountField.setText("");
                    int retry = JOptionPane.showConfirmDialog(
                            null,
                            panel,
                            "Añada un producto",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            admin
                    );
                    if (retry != JOptionPane.OK_OPTION) return;
                } catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(
                            null,
                            "La cantidad debe ser un numero positivo",
                            "Error",
                            JOptionPane.OK_CANCEL_OPTION,
                            admin
                    );
                    amountField.setText("");
                    int retry = JOptionPane.showConfirmDialog(
                            null,
                            panel,
                            "Añada un producto",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            admin
                    );
                    if (retry != JOptionPane.OK_OPTION)return;
                }
            }
                String message = control.createProduct(String.valueOf(amount),name,category);
                JOptionPane.showMessageDialog(null, message);
        }
    }
    public void deleteProduct() {
        String[] options = control.Ids();
        if (options == null || options.length == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay productos para borrar.",
                    "Inventario vacío",
                    JOptionPane.ERROR_MESSAGE,
                    admin
            );
            return;
        }

        String selection = (String) JOptionPane.showInputDialog(
                null,
                "Escoja el identificador que desea borrar",
                "Menu principal",
                JOptionPane.QUESTION_MESSAGE,
                admin,
                options,
                options[0]
        );
        JOptionPane.showMessageDialog(
                null,
                control.deleteProduct(selection)
        );
    }
    public void updateProduct() {

        String[] options = control.Ids();
        String selection = (String) JOptionPane.showInputDialog(
                null,
                "Escoja el identificador que desea actualizar",
                "Menu principal",
                JOptionPane.QUESTION_MESSAGE,
                admin,
                options,
                options[0]
        );
        JTextField amountField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JComboBox<String> categoryBox = new JComboBox<>(new String[]{"Papeleria","Aseo","Miscelanea"});

        JPanel panel = new JPanel(); // mandar vacio
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Cantidad: "));
        panel.add(amountField);
        panel.add(new JLabel("Nombre: "));
        panel.add(nameField);
        panel.add(new JLabel("Categoria: "));
        panel.add(categoryBox);

        int result = JOptionPane.showConfirmDialog(null, panel, "Actualizar producto",
                JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,admin);

        if (result != JOptionPane.OK_OPTION) return;

        // Validate name
        String name = nameField.getText().trim();
        while (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío",
                    "Error", JOptionPane.ERROR_MESSAGE,admin);

            result = JOptionPane.showConfirmDialog(null, panel,
                    "Actualizar producto", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,admin);

            if (result != JOptionPane.OK_OPTION) return;

            name = nameField.getText().trim();
        }

        // Validate amount
        int amount = -1;
        while (true) {
            try {
                amount = Integer.parseInt(amountField.getText());
                if (amount <= 0)
                    throw new IllegalArgumentException("Debe ser positivo.");
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Cantidad inválida. Use un número positivo.",
                        "Error", JOptionPane.ERROR_MESSAGE,admin);

                amountField.setText("");

                result = JOptionPane.showConfirmDialog(null, panel,
                        "Actualizar producto", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,admin);

                if (result != JOptionPane.OK_OPTION) return;
            }
        }

        String category = (String) categoryBox.getSelectedItem();

        String message = control.updateProduct(selection,
                String.valueOf(amount), name, category);

        JOptionPane.showMessageDialog(null, message,"Resultado",JOptionPane.INFORMATION_MESSAGE,admin);
    }
    public void showProducts() {
        JOptionPane.showMessageDialog(null, control.showProducts(),"Lista de productos",JOptionPane.INFORMATION_MESSAGE,admin);
    }
}
