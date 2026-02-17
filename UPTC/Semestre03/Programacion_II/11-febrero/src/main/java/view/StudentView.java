package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.StudentController;
import model.Student;

public class StudentView extends JFrame {
    private StudentController controller = new StudentController();

    private JTextField txtId, txtName, txtAge, txtMajor;
    private JTable table;
    private DefaultTableModel model;
    public StudentView(){
        setTitle("Estudiantes Programacion 2 2026");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel();
        txtId = new JTextField(5);
        txtName = new JTextField(10);
        txtAge = new JTextField(5);
        txtMajor = new JTextField(12);

        JButton addButton = new JButton("Agregar");
        
        panelForm.add(new JLabel("ID:"));
        panelForm.add(txtId);
        panelForm.add(new JLabel("Nombre:"));
        panelForm.add(txtName);
        panelForm.add(new JLabel("Edad:"));
        panelForm.add(txtAge);
        panelForm.add(new JLabel("Carrera:"));
        panelForm.add(txtMajor);
        panelForm.add(addButton);
        addButton.setBackground(Color.GREEN);

        panelForm.setPreferredSize(new Dimension(600,80));
        String[] columnas = {"ID","Nombre","Edad", "Carrera"};
        model = new DefaultTableModel(columnas, 0);
        table = new JTable(model);

        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        addButton.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            int age = Integer.parseInt(txtAge.getText());
            String major = txtMajor.getText();
            controller.createStudent(id, name, age, major);
            actualizarTabla();
            limpiar();
        });
        cargarDatosIniciales();
    }

    private void actualizarTabla(){
        model.setRowCount(0);
        for(Student e : controller.listarEstudiantes()){
            model.addRow(new Object[]{
                e.getId(),
                e.getName(),
                e.getAge(),
                e.getMajor()
            });
        }
    }

    private void limpiar(){
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtMajor.setText("");
    }
    private void cargarDatosIniciales(){
        controller.createStudent(1, "Jorge", 31, "ingenieria");
        controller.createStudent(2, "Alejandra", 30, "Diseño");
        actualizarTabla();  
    }
   
    public void createStudents() {
        controller.createStudent(1, "Jorge", 31, "Ingenieria");
        controller.createStudent(2, "Alejandra", 30, "Diseño");
        controller.createStudent(3, "Diana", 22, "Geologia");
        controller.createStudent(4, "Luis", 21, "Medicina");
    }

    public void listar() {
        controller.listarEstudiantes().forEach(System.out::println);
    }
}