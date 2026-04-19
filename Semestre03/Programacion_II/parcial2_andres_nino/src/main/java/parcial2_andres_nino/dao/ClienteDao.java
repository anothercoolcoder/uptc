package parcial2_andres_nino.dao;

import parcial2_andres_nino.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import parcial2_andres_nino.config.ConnectionMySQL;

public class ClienteDao {
    public void crear(ClienteModel ClienteModel) throws SQLException {
        String sql = "INSERT INTO ClienteModels (id, nombre, edad, licencia,password,prestamos,deudas,estado) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionMySQL.getConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, ClienteModel.getId());
            ps.setString(2, ClienteModel.getNombre());
            ps.setInt(3, ClienteModel.getEdad());
            ps.setBoolean(4, ClienteModel.isLicencia());
            ps.setString(5, ClienteModel.getPassword());
            ps.setInt(6, ClienteModel.getPrestamos());
            ps.setBoolean(7, ClienteModel.isDeudas());
            ps.setBoolean(8, ClienteModel.isEstado());            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ClienteModel.setId(rs.getInt(1));
            }
        }
    }
    public List<ClienteModel> listarTodos() throws SQLException {
        List<ClienteModel> ClienteModels = new ArrayList<>();
        String sql = "SELECT * FROM clientes ORDER BY id";
        try (Connection con = ConnectionMySQL.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ClienteModels.add(mapearClienteModel(rs));
            }
        }
        return ClienteModels;
    }
    public ClienteModel mapearClienteModel(ResultSet rs) throws SQLException {
        ClienteModel cliente = new ClienteModel(
            rs.getInt("id"),
            rs.getString("nombre"),
            rs.getInt("edad"),
            rs.getBoolean("licencia"),
            rs.getString("password"),
            rs.getInt("prestamos"),
            rs.getBoolean("deudas"),
            rs.getBoolean("estado"));
        return cliente;
    }

    public void eliminar(int id) throws SQLException {
        String deleteCliente = "DELETE FROM clientes WHERE id = ?";
        try (Connection con = ConnectionMySQL.getConexion();
             PreparedStatement ps = con.prepareStatement(deleteCliente)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    public ClienteModel validarLogin(int id, String password) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id = ? AND password = ?";
        try (Connection con = ConnectionMySQL.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapearClienteModel(rs);
            }
        }
        return null;
    }
    // public String conteoDeudores() throws SQLException {
    //     String sql = "SELECT COUNT(*) FROM usuarios WHERE deudas = ?";
    //     try (Connection con = ConnectionMySQL.getConexion();
    //          PreparedStatement ps = con.prepareStatement(sql)) {
    //         ps.setString(1, rol);
    //         ResultSet rs = ps.executeQuery();
    //         if (rs.next()) {
    //             return rs.getInt(1);
    //         }
    //     }
    //     return 0;
    // }

}
