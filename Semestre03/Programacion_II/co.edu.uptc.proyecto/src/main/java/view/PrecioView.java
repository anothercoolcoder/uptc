package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.PreciosController;
import model.PrecioModel;

public class PrecioView extends JFrame {
    private PreciosController preciosController = new PreciosController();

    private JTextField txtId, txtNombre,txtPrecio;
    private JTable tabla;
    private DefaultTableModel modelo;

    public PrecioView(){
        setTitle(("Gestor de precios"));
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel();
        txtId = new JTextField(5);
        txtNombre = new JTextField(20);
        txtPrecio = new JTextField(20);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnVolver = new JButton("Volver");

        panelForm.add(new JLabel("ID"));
        panelForm.add(txtId);

        panelForm.add(new JLabel("Nombre"));
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Precio"));
        panelForm.add(txtPrecio);

        panelForm.add(btnAgregar);
        panelForm.add(btnVolver);

        panelForm.setPreferredSize(new Dimension(600,80));
        String[] columnas = {"Id", "Nombre","Precio"};
        modelo = new DefaultTableModel(columnas,0);
        tabla = new JTable(modelo);

        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(tabla),BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            preciosController.createPrecio(id, nombre,precio);
            actualizarTabla();
            limpiar();
        });
            cargarDatosIniciales();

        btnVolver.addActionListener(e -> {
            setVisible(false);
        });
    }

        private void actualizarTabla(){
            modelo.setRowCount(0);
            for(PrecioModel e : preciosController.listPrecioModels()) {
                modelo.addRow(new Object[]{e.getId(),e.getNombre(),e.getPrecio()
                });
            }
        }
        private void limpiar(){
            txtId.setText("");
            txtNombre.setText("");
        }
        private void cargarDatosIniciales(){
            preciosController.createPrecio(1, "Gaseosa", 2000.0);
            preciosController.createPrecio(2, "Papas", 3000.0);
            preciosController.createPrecio(3, "Chocoramo", 4000.0);

            actualizarTabla();
        }
    }
