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
            JOptionPane.showMessageDialog(
                    null,
                    "No hay productos disponibles",
                    "Informacion inventario",
                    JOptionPane.WARNING_MESSAGE,
                    user
            );
            return;
        }

        String selection = (String) JOptionPane.showInputDialog(
                null,
                "Elije el nombre del producto",
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
                String amountText = amountField.getText().trim();
                if (amountText.isEmpty()) {
                    throw new IllegalArgumentException("Debe ingresar una cantidad");
                }

                amount = Integer.parseInt(amountText);

                if (amount <= 0) {
                    throw new IllegalArgumentException("La cantidad debe ser un número positivo");
                }
                if (amount > 30) {
                    throw new IllegalArgumentException("No puede pedir más de 30 unidades por pedido");
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
                        JOptionPane.QUESTION_MESSAGE,
                        user
                );
                if (retry != JOptionPane.OK_OPTION) return;

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Error",
                        JOptionPane.WARNING_MESSAGE,
                        user
                );
                amountField.setText("");

                int retry = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "Solicitar un producto",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        user
                );
                if (retry != JOptionPane.OK_OPTION) return;
            }
        }

        String message = control.askProduct(selection, String.valueOf(amount));
        JOptionPane.showMessageDialog(
                null,
                message,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE,
                user
        );
    }

    public void menuAdmin(){
        // Verificar stock bajo al entrar al menú de administrador
        if (control.hasLowStock()) {
            String lowStockMessage = "ALERTA DE STOCK BAJO\n\n" +
                    "Los siguientes productos tienen menos de 10 unidades:\n\n" +
                    control.checkLowStock();

            JOptionPane.showMessageDialog(
                    null,
                    lowStockMessage,
                    "Alerta de Inventario",
                    JOptionPane.WARNING_MESSAGE,
                    admin
            );
        }

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
                case "Salir" -> JOptionPane.showMessageDialog(
                        null,
                        "Saliendo...",
                        "Hasta luego",
                        JOptionPane.INFORMATION_MESSAGE,
                        admin
                );
                default -> JOptionPane.showMessageDialog(
                        null,
                        "Opcion invalida",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        admin
                );
            }
        }while (!"Salir".equalsIgnoreCase(selection));
    }

    public void addProduct() {
        JTextField amountField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JComboBox<String> categoryBox = new JComboBox<>(new String[]{"Papeleria","Aseo","Miscelanea"});

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nombre: "));
        panel.add(nameField);
        panel.add(new JLabel("Cantidad: "));
        panel.add(amountField);
        panel.add(new JLabel("Categoria: "));
        panel.add(categoryBox);

        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Añadir producto",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                admin
        );

        if (result != JOptionPane.OK_OPTION) return;

        String name = nameField.getText().trim();
        int amount = -1;
        String category = (String) categoryBox.getSelectedItem();

        // Validar nombre
        while (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "El nombre no puede estar vacío",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    admin
            );
            nameField.setText("");

            result = JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Añadir producto",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    admin
            );
            if (result != JOptionPane.OK_OPTION) return;

            name = nameField.getText().trim();
        }

        // Validar cantidad
        while (true){
            try{
                String amountText = amountField.getText().trim();
                if (amountText.isEmpty()) {
                    throw new IllegalArgumentException("Debe ingresar una cantidad");
                }

                amount = Integer.parseInt(amountText);

                if (amount <= 0){
                    throw new IllegalArgumentException("La cantidad debe ser positiva");
                }
                if (amount > 200){
                    throw new IllegalArgumentException("La cantidad no puede exceder 200");
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Ingrese un número válido para cantidad",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        admin
                );
                amountField.setText("");

                result = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "Añadir producto",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        admin
                );
                if (result != JOptionPane.OK_OPTION) return;

            } catch (IllegalArgumentException e){
                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Error",
                        JOptionPane.WARNING_MESSAGE,
                        admin
                );
                amountField.setText("");

                result = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "Añadir producto",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        admin
                );
                if (result != JOptionPane.OK_OPTION) return;
            }
        }

        String message = control.createProduct(String.valueOf(amount), name, category);
        JOptionPane.showMessageDialog(
                null,
                message,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE,
                admin
        );
    }

    public void deleteProduct() {
        String[] options = control.Ids();
        if (options == null || options.length == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay productos para borrar.",
                    "Inventario vacío",
                    JOptionPane.WARNING_MESSAGE,
                    admin
            );
            return;
        }

        String selection = (String) JOptionPane.showInputDialog(
                null,
                "Escoja el producto que desea borrar",
                "Borrar producto",
                JOptionPane.QUESTION_MESSAGE,
                admin,
                options,
                options[0]
        );

        if (selection == null) return;

        String message = control.deleteProduct(selection);
        JOptionPane.showMessageDialog(
                null,
                message,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE,
                admin
        );
    }

    public void updateProduct() {
        String[] options = control.Ids();
        if (options == null || options.length == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay productos para actualizar.",
                    "Inventario vacío",
                    JOptionPane.WARNING_MESSAGE,
                    admin
            );
            return;
        }

        String selection = (String) JOptionPane.showInputDialog(
                null,
                "Escoja el producto que desea actualizar",
                "Actualizar producto",
                JOptionPane.QUESTION_MESSAGE,
                admin,
                options,
                options[0]
        );

        if (selection == null) return;

        JTextField amountField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JComboBox<String> categoryBox = new JComboBox<>(new String[]{"Papeleria","Aseo","Miscelanea"});

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nuevo nombre: "));
        panel.add(nameField);
        panel.add(new JLabel("Nueva cantidad: "));
        panel.add(amountField);
        panel.add(new JLabel("Nueva categoria: "));
        panel.add(categoryBox);

        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Actualizar producto",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                admin
        );

        if (result != JOptionPane.OK_OPTION) return;

        // Validar nombre
        String name = nameField.getText().trim();
        while (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "El nombre no puede estar vacío",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    admin
            );

            result = JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Actualizar producto",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    admin
            );

            if (result != JOptionPane.OK_OPTION) return;

            name = nameField.getText().trim();
        }

        // Validar cantidad
        int amount = -1;
        while (true) {
            try {
                String amountText = amountField.getText().trim();
                if (amountText.isEmpty()) {
                    throw new IllegalArgumentException("Debe ingresar una cantidad");
                }

                amount = Integer.parseInt(amountText);

                if (amount <= 0) {
                    throw new IllegalArgumentException("La cantidad debe ser un número positivo");
                }
                if (amount > 200) {
                    throw new IllegalArgumentException("La cantidad no puede exceder 200");
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Ingrese un número válido para cantidad",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        admin
                );

                amountField.setText("");

                result = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "Actualizar producto",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        admin
                );

                if (result != JOptionPane.OK_OPTION) return;

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Error",
                        JOptionPane.WARNING_MESSAGE,
                        admin
                );

                amountField.setText("");

                result = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "Actualizar producto",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        admin
                );

                if (result != JOptionPane.OK_OPTION) return;
            }
        }

        String category = (String) categoryBox.getSelectedItem();

        String message = control.updateProduct(
                selection,
                String.valueOf(amount),
                name,
                category
        );

        JOptionPane.showMessageDialog(
                null,
                message,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE,
                admin
        );
    }

    public void showProducts() {
        String productList = control.showProducts();
        JOptionPane.showMessageDialog(
                null,
                productList,
                "Lista de productos",
                JOptionPane.INFORMATION_MESSAGE,
                admin
        );
    }
}