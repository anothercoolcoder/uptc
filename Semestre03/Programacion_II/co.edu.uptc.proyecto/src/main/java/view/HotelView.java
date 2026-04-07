package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HotelView extends JFrame {

    public JTextField txtId = new JTextField(10);
    public JTextField txtNombre = new JTextField(10);
    public JTextField txtPrecio = new JTextField(10);
    public JTable tabla;
    public DefaultTableModel modelo;
    public JButton btnGuardar = new JButton("Guardar");

    // 🎨 Colores suaves
    private final Color FONDO = new Color(245, 247, 250);
    private final Color AZUL = new Color(52, 152, 219);
    private final Color VERDE = new Color(46, 204, 113);
    private final Color ROJO = new Color(231, 76, 60);

    public HotelView() {
        setTitle("Sistema Hotelero");
        setSize(750, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(FONDO);
        setLayout(new BorderLayout(10, 10));

        // --- FORM ---
        JPanel form = new JPanel(new GridLayout(7, 1, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        form.setBackground(Color.WHITE);

        form.add(label("ID"));
        form.add(estiloCampo(txtId));

        form.add(label("Nombre"));
        form.add(estiloCampo(txtNombre));

        form.add(label("Precio"));
        form.add(estiloCampo(txtPrecio));

        estiloBoton(btnGuardar, VERDE);
        form.add(btnGuardar);

        add(form, BorderLayout.WEST);

        // --- TABLA ---
        modelo = new DefaultTableModel(
                new String[]{"ID", "Nombre", "Precio", "", ""}, 0
        ) {
            public boolean isCellEditable(int r, int c) {
                return c >= 3;
            }
        };

        tabla = new JTable(modelo);
        tabla.setRowHeight(28);
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tabla.setSelectionBackground(new Color(220, 235, 250));

        // Botones
        tabla.getColumnModel().getColumn(3)
                .setCellRenderer(new ButtonRenderer("Editar", AZUL));
        tabla.getColumnModel().getColumn(3)
                .setCellEditor(new ButtonEditor("Editar", AZUL));

        tabla.getColumnModel().getColumn(4)
                .setCellRenderer(new ButtonRenderer("X", ROJO));
        tabla.getColumnModel().getColumn(4)
                .setCellEditor(new ButtonEditor("Eliminar", ROJO));

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(scroll, BorderLayout.CENTER);
    }

    // 🎨 Label bonito
    private JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("Segoe UI", Font.BOLD, 12));
        return l;
    }

    // 🎨 Campo bonito
    private JTextField estiloCampo(JTextField txt) {
        txt.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        return txt;
    }

    // 🎨 Botón bonito
    private void estiloBoton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
    }

    // --- RENDER ---
    class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
        public ButtonRenderer(String text, Color color) {
            setText(text);
            setBackground(color);
            setForeground(Color.WHITE);
            setFocusPainted(false);
        }

        public Component getTableCellRendererComponent(JTable t, Object v,
                boolean s, boolean f, int r, int c) {
            return this;
        }
    }

    // --- EDITOR ---
    class ButtonEditor extends DefaultCellEditor {
        JButton btn = new JButton();
        String accion;

        public ButtonEditor(String accion, Color color) {
            super(new JCheckBox());
            this.accion = accion;

            btn.setBackground(color);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);

            btn.addActionListener(e -> fireEditingStopped());
        }

        public Component getTableCellEditorComponent(JTable t, Object v,
                boolean s, int r, int c) {
            btn.setText(accion);
            return btn;
        }

        public Object getCellEditorValue() {
            return accion;
        }
    }
}