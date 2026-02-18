import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SwingTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SwingTest().createUI();
        });
    }

    private void createUI() {
        JFrame frame = new JFrame("Swing Render Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ----- Panel superior -----
        JPanel topPanel = new JPanel();

        JTextField txtName = new JTextField(10);
        JButton btnAdd = new JButton("Agregar");

        // Forzar color visible (algunos LookAndFeel lo ignoran)
        btnAdd.setBackground(Color.GREEN);
        btnAdd.setOpaque(true);
        btnAdd.setBorderPainted(false);

        topPanel.add(new JLabel("Nombre:"));
        topPanel.add(txtName);
        topPanel.add(btnAdd);

        // ----- Tabla -----
        String[] columns = {"ID", "Nombre"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        // ----- Acción botón -----
        btnAdd.addActionListener(e -> {
            String name = txtName.getText();
            if (!name.isEmpty()) {
                model.addRow(new Object[]{
                        model.getRowCount() + 1,
                        name
                });
                txtName.setText("");
            }
        });

        // ----- Agregar al frame -----
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
