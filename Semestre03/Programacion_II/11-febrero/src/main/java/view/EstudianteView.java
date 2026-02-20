package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.*;
import model.*;

public class EstudianteView extends JFrame {
    private StudentController controller = new StudentController();

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtCarrera;

    private JTable tabla;
    private DefaultTableModel modelo;

    public EstudianteView() {
        // --- Configuración de la Ventana ---
        setTitle("Estudiantes Programación 2 2026");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Panel de Formulario ---
        JPanel panelForm = new JPanel();
        txtId = new JTextField(5);
        txtNombre = new JTextField(10);
        txtEdad = new JTextField(3);
        txtCarrera = new JTextField(10);
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(Color.GREEN);
        
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(Color.ORANGE);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(Color.RED);

        JButton btnVer = new JButton("Ver");
        btnVer.setBackground(Color.CYAN); // Cambiado a Cyan para que resalte

        // Añadir componentes al panel
        panelForm.add(new JLabel("ID:"));
        panelForm.add(txtId);
        panelForm.add(new JLabel("Nombre:"));
        panelForm.add(txtNombre);
        panelForm.add(new JLabel("Edad:"));
        panelForm.add(txtEdad);
        panelForm.add(new JLabel("Carrera:"));
        panelForm.add(txtCarrera);
        panelForm.add(btnAgregar);
        panelForm.add(btnActualizar);
        panelForm.add(btnEliminar);
        panelForm.add(btnVer); // ¡IMPORTANTE! Añadirlo al panel

        panelForm.setPreferredSize(new Dimension(600, 100));

        // --- Configuración de Tabla ---
        String[] columnas = {"ID", "Nombre", "Edad", "Carrera"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // --- LISTENERS (Dentro del constructor) ---

        btnAgregar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String carrera = txtCarrera.getText();
                controller.crearEstudiante(id, nombre, edad, carrera);
                actualizarTabla();
                limpiar();
            } catch (NumberFormatException ex) {
                System.out.println("Error: ID y Edad deben ser números.");
            }
        });

        btnActualizar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String carrera = txtCarrera.getText();
                controller.actualizarEstudiante(id, nombre, edad, carrera);
                actualizarTabla();
                limpiar();
            } catch (NumberFormatException ex) {
                System.out.println("Error en los datos de actualización.");
            }
        });

        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                int id = (int) modelo.getValueAt(fila, 0);
                controller.eliminarEstudiante(id);
                actualizarTabla();
                limpiar();
            }
        });

        // Evento para el botón Ver
        btnVer.addActionListener(e -> {
            System.out.println("¡Funciona! Abriendo ventana Prueba...");
            Prueba p = new Prueba();
            p.setVisible(true);
        });

        tabla.getSelectionModel().addListSelectionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtId.setText(modelo.getValueAt(fila, 0).toString());
                txtNombre.setText(modelo.getValueAt(fila, 1).toString());
                txtEdad.setText(modelo.getValueAt(fila, 2).toString());
                txtCarrera.setText(modelo.getValueAt(fila, 3).toString());
            }
        });

        cargarDatosIniciales();
        setVisible(true);
    }

    // --- Métodos de apoyo ---
    private void actualizarTabla() {
        modelo.setRowCount(0);
        for (Student e : controller.listarEstudiantes()) {
            modelo.addRow(new Object[]{e.getId(), e.getName(), e.getAge(), e.getMajor()});
        }
    }

    private void limpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtCarrera.setText("");
    }

    private void cargarDatosIniciales() {
        controller.crearEstudiante(1, "Jorge", 31, "Ingenieria");
        controller.crearEstudiante(2, "Alejandra", 30, "Diseño");
        actualizarTabla();
    }
}