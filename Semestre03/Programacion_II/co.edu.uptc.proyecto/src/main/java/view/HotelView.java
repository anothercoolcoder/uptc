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

import controller.HotelController;
import model.RoomModel;

public class HotelView extends JFrame {
    private HotelController HotelController = new HotelController();

    private JTextField txtId, txtNombre,txtCuenta,txtPrecio;
    private JTable tabla;
    private DefaultTableModel modelo;

    public HotelView(){
        setTitle(("Hotel de Andres Niño"));
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel();
        txtId = new JTextField(5);
        txtNombre = new JTextField(20);
        txtCuenta = new JTextField(20);
        txtPrecio = new JTextField(10);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnPrecios = new JButton("Gestor de precios");

        panelForm.add(new JLabel("ID"));
        panelForm.add(txtId);

        panelForm.add(new JLabel("Nombre"));
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Cuenta"));
        panelForm.add(txtCuenta);

        panelForm.add(new JLabel("Precio"));
        panelForm.add(txtPrecio);

        panelForm.add(btnAgregar);
        panelForm.add(btnPrecios);

        panelForm.setPreferredSize(new Dimension(600,80));
        String[] columnas = {"Id", "Nombre","Cuenta","Precio"};
        modelo = new DefaultTableModel(columnas,0);
        tabla = new JTable(modelo);

        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(tabla),BorderLayout.CENTER);
        
        if (HotelController.listRoomModels().isEmpty()) {
            cargarDatosIniciales();
        }else{
            System.out.println("La lista no esta vacia, entonces no necesito cargar datos iniciales para los huspedes");
        }
        actualizarTabla();

        btnAgregar.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            HotelController.createRoom(id, nombre);
            actualizarTabla();
            limpiar();
        });

        
        btnPrecios.addActionListener(e -> {
            PrecioView precioView = new PrecioView();
            precioView.setVisible(true);
        });

        tabla.getSelectionModel().addListSelectionListener(
            e -> {
                int fila = tabla.getSelectedRow();
            if(fila>= 0){
                txtId.setText(modelo.getValueAt(fila, 0).toString());
                txtNombre.setText(modelo.getValueAt(fila, 1).toString());
            }}
        );

    }

        private void actualizarTabla(){
            modelo.setRowCount(0);
            for(RoomModel e : HotelController.listRoomModels()) {
                modelo.addRow(new Object[]{e.getId(),e.getNombreHuesped()
                });
            }
        }
        private void limpiar(){
            txtId.setText("");
            txtNombre.setText("");
        }
        private void cargarDatosIniciales(){
            HotelController.createRoom(1, "Andres");
            HotelController.createRoom(2, "Roberto");
            actualizarTabla();
        }
    }
