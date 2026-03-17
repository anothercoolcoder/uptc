package dao;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Util.QueryConstants;
import config.ConnectionMySQL;

public class EstudiantesDAOMySQL {
    public void crear(Estudiante e){
        try (Connection con = ConnectionMySQL.getConexion();
        PreparedStatement ps = con.prepareStatement(QueryConstants.INSERTAR_ESTUDIANTE)){
        ps.setInt(1, e.getId());
        ps.setString(   2  , e.getNombre());
        ps.setInt(3, e.getEdad());
        ps.setInt(4, e.getCodigoCarrera());

        ps.executeUpdate();

    } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Estudiante> listar(){
        List<Estudiante> lista = new ArrayList<>();
        try (Connection con = ConnectionMySQL.getConexion();
        PreparedStatement ps = con.prepareStatement(QueryConstants.LISTAR_ESTUDIANTE);
        ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                Estudiante e = new Estudiante(
               rs.getInt("id"),
               rs.getString("nombre"),
               rs.getInt("edad"),
               rs.getInt("codigoCarrera")
            );
            lista.add(e);
            }
    } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}