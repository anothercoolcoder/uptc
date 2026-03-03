package uptc.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uptc.controller.PaisController;

public class PaisView extends JFrame {
    private JTable tablaDeptos;
    private DefaultTableModel modelo;
    private JButton btnVer;
    private PaisController controlador;

    public PaisView() {
        controlador = new PaisController();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Consulta de Departamentos - Colombia");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    private void inicializarComponentes() {
        btnVer = new JButton("Ver Departamentos");
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(btnVer);
        add(panelSuperior, BorderLayout.NORTH);

        String[] columnas = {"Nombre del Departamento"};
        modelo = new DefaultTableModel(columnas, 0);
        tablaDeptos = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tablaDeptos);
        add(scrollPane, BorderLayout.CENTER);

        btnVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.cargarDepartamentosEnTabla(modelo, "Colombia");
                
                if (modelo.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos. Revisa el archivo XML.");
                }
            }
        });
    }

    
}