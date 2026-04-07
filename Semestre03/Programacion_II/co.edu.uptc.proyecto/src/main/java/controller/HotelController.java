package controller;

import dao.ClienteDao;
import model.ClienteModel;
import view.HotelView;

import java.awt.event.*;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HotelController implements ActionListener {

    private HotelView vista;
    private ClienteDao dao;

    // 🔥 Control de edición
    private boolean editando = false;

    public HotelController(HotelView vista) {
        this.vista = vista;
        this.dao = new ClienteDao();

        vista.btnGuardar.addActionListener(this);

        // 🔥 Detectar clicks en la tabla
        vista.tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = vista.tabla.getSelectedRow();
                int columna = vista.tabla.getSelectedColumn();

                String id = vista.tabla.getValueAt(fila, 0).toString();

                if (columna == 3) {
                    cargarParaEditar(fila);
                } else if (columna == 4) {
                    eliminarCliente(id);
                }
            }
        });

        actualizarTabla();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            guardar();
        }
    }

    private void guardar() {
        try {
            String id = vista.txtId.getText();
            String nombre = vista.txtNombre.getText();
            double precio = Double.parseDouble(vista.txtPrecio.getText());

            ClienteModel cliente = new ClienteModel(id, nombre, precio);

            if (editando) {
                // 🔥 UPDATE
                if (dao.actualizarCliente(cliente)) {
                    JOptionPane.showMessageDialog(vista, "Cliente actualizado");
                }
                editando = false;
                vista.btnGuardar.setText("Guardar");

            } else {
                // 🔥 INSERT
                if (dao.registrarCliente(cliente)) {
                    JOptionPane.showMessageDialog(vista, "Cliente guardado");
                }
            }

            actualizarTabla();
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Precio inválido");
        }
    }

    private void cargarParaEditar(int fila) {
        vista.txtId.setText(vista.tabla.getValueAt(fila, 0).toString());
        vista.txtNombre.setText(vista.tabla.getValueAt(fila, 1).toString());
        vista.txtPrecio.setText(vista.tabla.getValueAt(fila, 2).toString());

        editando = true;
        vista.btnGuardar.setText("Actualizar");
    }

    private void eliminarCliente(String id) {
        int confirm = JOptionPane.showConfirmDialog(
                vista,
                "¿Eliminar cliente?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            if (dao.eliminarCliente(id)) {
                JOptionPane.showMessageDialog(vista, "Cliente eliminado");
                actualizarTabla();
            }
        }
    }

    private void limpiarCampos() {
        vista.txtId.setText("");
        vista.txtNombre.setText("");
        vista.txtPrecio.setText("");
    }

    public void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        List<ClienteModel> lista = dao.listarClientes();

        for (ClienteModel c : lista) {
            modelo.addRow(new Object[]{
                    c.getId(),
                    c.getNombre(),
                    c.getPrecioHabitacion(),
                    "Editar",
                    "Eliminar"
            });
        }
    }
}