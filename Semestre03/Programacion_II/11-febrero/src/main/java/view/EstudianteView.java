package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.*;
import dao.GestionDAO;
import dao.UsuariosDao;
import model.Facultad;
import model.Carrera;
import model.Student;
public class EstudianteView extends JFrame {
    private StudentController controller = new StudentController();
    private GestionDAO gestion = new GestionDAO();

    private JTextField txtId, txtNombre, txtEdad;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JComboBox<Facultad> cbFacultad;
    private JComboBox<Carrera> cbCarrera;

    public EstudianteView() {
        // --- Configuración de la Ventana ---
        setTitle("Estudiantes Programación 2 2026");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Panel de Formulario ---
        JPanel panelForm = new JPanel();
        txtId = new JTextField(5);
        txtNombre = new JTextField(10);
        txtEdad = new JTextField(3);
        
        cbFacultad = new JComboBox<>();
        cbCarrera = new JComboBox<>();

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(Color.GREEN);
        
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(Color.ORANGE);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(Color.RED);

        JButton btnVer = new JButton("Ver");
        btnVer.setBackground(Color.CYAN);

        // Añadir componentes al panel
        panelForm.add(new JLabel("ID:"));
        panelForm.add(txtId);
        panelForm.add(new JLabel("Nombre:"));
        panelForm.add(txtNombre);
        panelForm.add(new JLabel("Edad:"));
        panelForm.add(txtEdad);
        panelForm.add(new JLabel("Facultad:"));
        panelForm.add(cbFacultad);
        panelForm.add(new JLabel("Carrera:"));
        panelForm.add(cbCarrera);
        
        panelForm.add(btnAgregar);
        panelForm.add(btnActualizar);
        panelForm.add(btnEliminar);
        panelForm.add(btnVer);

        panelForm.setPreferredSize(new Dimension(900, 100));

        // --- Configuración de Tabla ---
        String[] columnas = {"ID", "Nombre", "Edad", "Carrera ID"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // --- LÓGICA DE CARGA (COMBOBOX) ---
        cargarFacultades();

        cbFacultad.addActionListener(e -> {
            actualizarComboCarreras();
        });

        // --- LISTENERS DE BOTONES ---

        btnAgregar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                Carrera carrera = (Carrera) cbCarrera.getSelectedItem();
                
                if (carrera == null) {
                    JOptionPane.showMessageDialog(this, "Seleccione una carrera válida");
                    return;
                }

                controller.crearEstudiante(id, nombre, edad, carrera.getCodigoCarrera());
                actualizarTabla();
                limpiar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: ID y Edad deben ser números.");
            }
        });

        btnActualizar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                Carrera carrera = (Carrera) cbCarrera.getSelectedItem();
                
                controller.actualizarEstudiante(id, nombre, edad, carrera.getCodigoCarrera());
                actualizarTabla();
                limpiar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar.");
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

        btnVer.addActionListener(e -> {
            System.out.println("Abriendo ventana de prueba...");
        });

        // Carga inicial de datos en tabla
        cargarDatosPrueba();
        setVisible(true);
    }

    // --- MÉTODOS DE APOYO ---

    private void cargarFacultades() {
        cbFacultad.removeAllItems();
        for (Facultad f : gestion.getFacultades())
            cbFacultad.addItem(f);
        }
    

private void actualizarComboCarreras() {
    cbCarrera.removeAllItems();
    Facultad seleccionada = (Facultad) cbFacultad.getSelectedItem();
    if (seleccionada != null && seleccionada.getCarreras() != null) {
        for (Carrera c : seleccionada.getCarreras()) {
            cbCarrera.addItem(c);
        }
    }
}

   private void actualizarTabla() {
    modelo.setRowCount(0);
    for (Student e : controller.listarEstudiantes()) {
        // Opcional: obtener el nombre de la carrera mediante el ID
        Carrera c = gestion.getCarreraPorCodigo(e.getCodigoCarrera());
        String nombreCarrera = (c != null) ? c.getNombre() : "No asignada";

        modelo.addRow(new Object[]{
            e.getId(), 
            e.getNombre(), 
            e.getEdad(), 
            nombreCarrera // Se ve mucho mejor el nombre que el número
        });
    }
}

    private void limpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
    }

    private void cargarDatosPrueba() {
        controller.crearEstudiante(1, "Jorge", 31, 2);
        controller.crearEstudiante(2, "Alejandra", 30, 1);
        actualizarTabla();
    }
}
