package parcial2_andres_nino.controller;

import java.util.List;
import java.sql.SQLException;

import parcial2_andres_nino.dao.ClienteDao;
import parcial2_andres_nino.model.ClienteModel;

public class ClienteController {
    private ClienteDao clienteDao = new ClienteDao();
    
    public boolean registrarUsuario(int id, String nombre, int edad, boolean licencia, String password,int prestamos, boolean deudas,boolean estado) {
        try {
            // if (usuarioDAO.buscarPorEmail(email) != null) {
            //     return false;
            // }
            ClienteModel cliente = new ClienteModel(id, nombre, edad, licencia, password, prestamos, deudas, estado);
            clienteDao.crear(cliente);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
