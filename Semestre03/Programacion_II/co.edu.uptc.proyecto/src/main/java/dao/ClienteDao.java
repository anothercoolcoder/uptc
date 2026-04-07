package dao;

import config.ConnectionRedis;
import config.DbConfig;
import dao.JsonPersistence;
import model.ClienteModel;
import redis.clients.jedis.Jedis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
public class ClienteDao {
    private final JsonPersistence jsonPersistence;

    public ClienteDao() {
        this.jsonPersistence = new JsonPersistence();
    }
    public boolean eliminarCliente(String id) {
    String sql = "DELETE FROM clientes WHERE id = ?";

    try (Connection con = DbConfig.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, id);

        int filas = ps.executeUpdate();

        if (filas > 0) {
            sincronizarJson(); // 🔥 importante
            return true;
        }

    } catch (SQLException e) {
        System.err.println("Error al eliminar: " + e.getMessage());
    }
    return false;
    }
    public boolean actualizarCliente(ClienteModel cliente) {
    String sql = "UPDATE clientes SET nombre = ?, precio = ? WHERE id = ?";

    try (Connection con = DbConfig.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, cliente.getNombre());
        ps.setDouble(2, cliente.getPrecioHabitacion());
        ps.setString(3, cliente.getId());

        int filas = ps.executeUpdate();

        if (filas > 0) {
            sincronizarJson(); // 🔥 importante
            return true;
        }

    } catch (SQLException e) {
        System.err.println("Error al actualizar: " + e.getMessage());
    }
    return false;
}

    // MÉTODO: Crear con Sincronización
    public boolean registrarCliente(ClienteModel cliente) {
        String sql = "INSERT INTO clientes (id, nombre, precio) VALUES (?, ?, ?)";
        
        try (Connection con = DbConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // 1. Guardar en MySQL
            ps.setString(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setDouble(3, cliente.getPrecioHabitacion());
            int filasAfecadas = ps.executeUpdate();

            // 2. Si se guardó en MySQL, sincronizamos el JSON
            if (filasAfecadas > 0) {
                sincronizarJson();
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en MySQL: " + e.getMessage());
        }
        return false;
    }

    
    public List<ClienteModel> listarClientes() {
    List<ClienteModel> lista = new ArrayList<>();
    String sql = "SELECT * FROM clientes";

    try (Connection con = DbConfig.getConnection();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            lista.add(new ClienteModel(
                rs.getString("id"),
                rs.getString("nombre"),
                rs.getDouble("precio")
            ));
        }
        System.out.println("MySQL: Se recuperaron " + lista.size() + " registros.");
    } catch (SQLException e) {
        System.err.println("Error al leer de MySQL: " + e.getMessage());
    }
    return lista;
    }

    // MÉTODO: Leer (Fuente de verdad: MySQL)
    public List<ClienteModel> listarDesdeMySQL() {
        List<ClienteModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection con = DbConfig.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new ClienteModel(
                    rs.getString("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Utilidad privada para mantener el JSON al día con la DB
    private void sincronizarJson() {
    List<ClienteModel> listaActualizada = listarClientes();

    // 🔥 SIEMPRE guardar, incluso si está vacío
    jsonPersistence.guardarTodo(listaActualizada);

    System.out.println("JSON sincronizado correctamente.");
}
}
