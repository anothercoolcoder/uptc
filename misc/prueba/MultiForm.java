import javax.swing.*;

public class MultiForm {
    public static void main(String[] args) {
        // Create components
        JTextField nameField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JTextField quantityField = new JTextField(10);
        JComboBox<String> categoryBox = new JComboBox<>(new String[]{"Electronics", "Food", "Clothes"});

        // Build the panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // vertical layout
        panel.add(new JLabel("Product Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryBox);

        // Show the form
        int result = JOptionPane.showConfirmDialog(null, panel, "Add Product", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            String category = (String) categoryBox.getSelectedItem();

            JOptionPane.showMessageDialog(null, 
                "Product saved:\n" +
                "Name: " + name + "\n" +
                "Price: " + price + "\n" +
                "Quantity: " + quantity + "\n" +
                "Category: " + category);
        }
    }
}
