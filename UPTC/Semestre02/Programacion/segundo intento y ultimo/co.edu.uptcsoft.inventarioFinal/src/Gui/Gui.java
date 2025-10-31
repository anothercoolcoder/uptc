package Gui;

import control.Control;

import javax.swing.*;

public class Gui {
    Control control = new Control();
    public Gui() {
        control.defaulter();
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
    public void menuUser(){
        
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
                    null,
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
                case "Salir" -> JOptionPane.showMessageDialog(null, "Saliendo...");
                default -> JOptionPane.showMessageDialog(null, "Opcion invalida");
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

        int result = JOptionPane.showConfirmDialog(null, panel, "Añada un producto",JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION){
                String name = nameField.getText();
                String amount = amountField.getText();
                String category = (String) categoryBox.getSelectedItem();

                String message = control.createProduct(amount,name,category);
                JOptionPane.showMessageDialog(null, message);
        }
    }
    public void deleteProduct() {
        String[] options = control.Ids();
        String selection = (String) JOptionPane.showInputDialog(
                null,
                "Escoja el identificador que desea borrar",
                "Menu principal",
                JOptionPane.QUESTION_MESSAGE,
                null,
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
                null,
                options,
                options[0]
        );
        JTextField amountField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JComboBox<String> categoryBox = new JComboBox<>(new String[]{"Papeleria","Aseo","Miscelanea"});

        JPanel panel = new JPanel(); // mandar vacio, arreglar
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Cantidad: "));
        panel.add(amountField);
        panel.add(new JLabel("Nombre: "));
        panel.add(nameField);
        panel.add(new JLabel("Categoria: "));
        panel.add(categoryBox);

        int result = JOptionPane.showConfirmDialog(null, panel, "Actulice el producto",JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION){
            String name = nameField.getText();
            String amount = amountField.getText();
            String category = (String) categoryBox.getSelectedItem();

            String message = control.updateProduct(selection,amount,name,category);
            JOptionPane.showMessageDialog(null, message);
        }
    }
    public void showProducts() {
        JOptionPane.showMessageDialog(null, control.showProducts());
    }
}
