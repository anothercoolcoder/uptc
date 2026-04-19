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
    private String idEditando = null;

    public HotelController(HotelView vista) {
        this.vista = vista;
        this.dao = new ClienteDao();
        vista.btnGuardar.addActionListener(this);
        vista.tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = vista.tabla.getSelectedRow();
                int col = vista.tabla.getSelectedColumn();
                String id = vista.tabla.getValueAt(fila, 0).toString();
                if (col == 3) cargarParaEditar(fila, id);
                else if (col == 4) eliminarCliente(id);
            }
        });
        actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        guardar();
    }

    private void guardar() {
        try {
            String nombre = vista.txtNombre.getText();
            double precio = Double.parseDouble(vista.txtPrecio.getText());

            if (idEditando != null) {
                dao.actualizarCliente(new ClienteModel(idEditando, nombre, precio));
                JOptionPane.showMessageDialog(vista, "Cliente actualizado");
                idEditando = null;
                vista.btnGuardar.setText("Guardar");
            } else {
                dao.registrarCliente(new ClienteModel(vista.txtId.getText(), nombre, precio));
                JOptionPane.showMessageDialog(vista, "Cliente guardado");
            }

            actualizarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Precio inválido");
        }
    }

    private void cargarParaEditar(int fila, String id) {
        idEditando = id;
        vista.txtId.setText(id);
        vista.txtNombre.setText(vista.tabla.getValueAt(fila, 1).toString());
        vista.txtPrecio.setText(vista.tabla.getValueAt(fila, 2).toString());
        vista.btnGuardar.setText("Actualizar");
    }

    private void eliminarCliente(String id) {
        int confirm = JOptionPane.showConfirmDialog(vista, "¿Eliminar cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION && dao.eliminarCliente(id)) {
            JOptionPane.showMessageDialog(vista, "Cliente eliminado");
            actualizarTabla();
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
        for (ClienteModel c : dao.listarClientes()) {
            modelo.addRow(new Object[]{c.getId(), c.getNombre(), c.getPrecioHabitacion(), "Editar", "Eliminar"});
        }
    }
}