package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import controller.*;
import dao.GestionDao;
import model.*;

public class EstudianteView extends JFrame {

    public StudentController controller = new StudentController();
    public GestionDao gestion = new GestionDao();
    public Prueba prueba = new Prueba();

    public JTextField txtId, txtNombre, txtEdad;
    public JTable tabla;
    public DefaultTableModel modelo;
    public JComboBox<Facultad> cbFacultad;
    public JComboBox<Carrera> cbCarrera;

    public EstudianteView() {

        setTitle("Sistema de Gestión de Estudiantes");
        setSize(900,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        // ---------- TITULO ----------
        JLabel titulo = new JLabel("Gestión de Estudiantes", JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titulo.setBorder(new EmptyBorder(10,10,10,10));
        add(titulo, BorderLayout.NORTH);

        // ---------- PANEL FORMULARIO ----------
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(new TitledBorder("Datos del Estudiante"));
        GridBagConstraints g = new GridBagConstraints();

        g.insets = new Insets(5,8,5,8);
        g.fill = GridBagConstraints.HORIZONTAL;

        txtId = new JTextField(10);
        txtNombre = new JTextField(15);
        txtEdad = new JTextField(5);

        cbFacultad = new JComboBox<>();
        cbCarrera = new JComboBox<>();

        g.gridx=0; g.gridy=0; panelForm.add(new JLabel("ID"),g);
        g.gridx=1; panelForm.add(txtId,g);

        g.gridx=2; panelForm.add(new JLabel("Nombre"),g);
        g.gridx=3; panelForm.add(txtNombre,g);

        g.gridx=4; panelForm.add(new JLabel("Edad"),g);
        g.gridx=5; panelForm.add(txtEdad,g);

        g.gridx=0; g.gridy=1; panelForm.add(new JLabel("Facultad"),g);
        g.gridx=1; panelForm.add(cbFacultad,g);

        g.gridx=2; panelForm.add(new JLabel("Carrera"),g);
        g.gridx=3; panelForm.add(cbCarrera,g);

        // ---------- BOTONES ----------
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,10));

        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnVer = new JButton("Ver");

        btnAgregar.setBackground(new Color(46,204,113));
        btnActualizar.setBackground(new Color(241,196,15));
        btnEliminar.setBackground(new Color(231,76,60));
        btnVer.setBackground(new Color(52,152,219));

        btnAgregar.setForeground(Color.WHITE);
        btnEliminar.setForeground(Color.WHITE);

        panelBotones.add(btnVer);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnAgregar);

        JPanel top = new JPanel(new BorderLayout());
        top.add(panelForm,BorderLayout.CENTER);
        top.add(panelBotones,BorderLayout.SOUTH);

        add(top,BorderLayout.CENTER);

        // ---------- TABLA ----------
        String[] columnas = {"ID","Nombre","Edad","Carrera"};
        modelo = new DefaultTableModel(columnas,0){
            public boolean isCellEditable(int r,int c){return false;}
        };

        tabla = new JTable(modelo);
        tabla.setRowHeight(22);
        tabla.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(new TitledBorder("Lista de Estudiantes"));

        add(scroll,BorderLayout.SOUTH);

        // ---------- LOGICA ORIGINAL ----------

        cargarFacultades();
        actualizarComboCarreras();

        cbFacultad.addActionListener(e -> actualizarComboCarreras());

        btnAgregar.addActionListener(e -> {
            try{
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                int edad = Integer.parseInt(txtEdad.getText());

                Carrera c = (Carrera) cbCarrera.getSelectedItem();

                controller.crearEstudiante(id,nombre,edad,c.getCodigoCarrera());
                actualizarTabla();
                limpiar();

            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Datos inválidos");
            }
        });

        btnActualizar.addActionListener(e -> {
            try{
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                int edad = Integer.parseInt(txtEdad.getText());

                Carrera c = (Carrera) cbCarrera.getSelectedItem();

                controller.actualizarEstudiante(id,nombre,edad,c.getCodigoCarrera());
                actualizarTabla();
                limpiar();

            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Error al actualizar");
            }
        });

        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                int id = (int)modelo.getValueAt(fila,0);
                controller.eliminarEstudiante(id);
                actualizarTabla();
            }
        });

        btnVer.addActionListener(e -> prueba.setVisible(true));

        if(controller.listarEstudiantes().isEmpty()){
            cargarDatosPrueba();
        }

        actualizarTabla();

        setVisible(true);
    }

    // ---------- METODOS ----------

    private void cargarFacultades(){
        cbFacultad.removeAllItems();
        for(Facultad f: gestion.getFacultades()){
            cbFacultad.addItem(f);
        }
    }

    private void actualizarComboCarreras(){
        cbCarrera.removeAllItems();
        Facultad f = (Facultad) cbFacultad.getSelectedItem();

        if(f!=null){
            for(Carrera c : f.getCarreras()){
                cbCarrera.addItem(c);
            }
        }
    }

    private void actualizarTabla(){
        modelo.setRowCount(0);

        for(Estudiante e : controller.listarEstudiantes()){
            Carrera c = gestion.getCarreraPorCodigo(e.getCodigoCarrera());

            modelo.addRow(new Object[]{
                e.getId(),
                e.getNombre(),
                e.getEdad(),
                c!=null ? c.getNombre() : "No asignada"
            });
        }
    }

    private void limpiar(){
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
    }

    private void cargarDatosPrueba(){
        controller.crearEstudiante(1,"Jorge",31,2);
        controller.crearEstudiante(2,"Alejandra",30,1);
    }
}
