package Util;

public class QueryConstants {
    public static final String INSERTAR_ESTUDIANTE = "INSERT INTO estudiante(id,nombre,edad,codigoCarrera) VALUES (?,?,?,?)";
    public static final String LISTAR_ESTUDIANTE = "SELECT * FROM estudiante";
    public static final String BUSCAR_ESTUDIANTE = "SELECT * FROM estudiante WHERE id=?";
    public static final String ACTUALIZAR_ESTUDIANTE = "UPDATE estudiante SET nombre=?, edad=?,WHERE id=?";
    public static final String ELIMINAR_ESTUDIANTE = "DELETE FROM estudiante WHERE id=?";
}