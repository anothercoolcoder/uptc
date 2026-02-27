package uptc.view;

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

import uptc.controller.VideoJuegoController;
import uptc.model.VideoJuegoModel;

public class VideoJuegoView extends JFrame {
    private VideoJuegoController videoJuegoController = new VideoJuegoController();

    private JTextField txtId, txtStock,txtTitulo,txtCategoria,txtPrecio;
    private JTable tabla;
    private DefaultTableModel modelo;

    public VideoJuegoView(){
        setTitle(("Libreria de juegos de Andres Niño"));
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel();
        txtId = new JTextField(5);
        txtStock = new JTextField(5);
        txtTitulo = new JTextField(20);
        txtCategoria = new JTextField(20);
        txtPrecio = new JTextField(10);

        JButton btnAgregar = new JButton("Agregar");

        panelForm.add(new JLabel("ID"));
        panelForm.add(txtId);

        panelForm.add(new JLabel("Stock"));
        panelForm.add(txtStock);

        panelForm.add(new JLabel("Titulo"));
        panelForm.add(txtTitulo);

        panelForm.add(new JLabel("Categoria"));
        panelForm.add(txtCategoria);

        panelForm.add(new JLabel("Precio"));
        panelForm.add(txtPrecio);

        panelForm.add(btnAgregar);

        panelForm.setPreferredSize(new Dimension(600,80));
        String[] columnas = {"ID", "STOCK","TITULO","CATEGORIA","PRECIO"};
        modelo = new DefaultTableModel(columnas,0);
        tabla = new JTable(modelo);

        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(tabla),BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            int stock = Integer.parseInt(txtStock.getText());
            String titulo = txtTitulo.getText();
            String categoria = txtCategoria.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            videoJuegoController.createVideoGame(id, stock, titulo, categoria, precio);
            actualizarTabla();
            limpiar();
        });
            cargarDatosIniciales();
    }

        private void actualizarTabla(){
            modelo.setRowCount(0);
            for(VideoJuegoModel e : videoJuegoController.listVideoJuegos()) {
                modelo.addRow(new Object[]{e.getId(),e.getStock(),e.getTitulo(),e.getcategoria(),e.getPrecio()
                });
            }
        }
        private void limpiar(){
            txtId.setText("");
            txtStock.setText("");
            txtTitulo.setText("");
            txtCategoria.setText("");
            txtPrecio.setText("");
        }
        private void cargarDatosIniciales(){
            videoJuegoController.createVideoGame(1, 12, "Mewgenics", "Roguelite", 54000);
            videoJuegoController.createVideoGame(2, 15, "Hades", "Roguelite", 20000);
            videoJuegoController.createVideoGame(3, 53, "Halo", "Shooter", 40000);
            actualizarTabla();
        }
    }
