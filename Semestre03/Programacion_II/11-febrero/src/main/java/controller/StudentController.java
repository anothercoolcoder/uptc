package controller;

import java.util.List;

import dao.EstudianteDao;
import model.Estudiante;

public class StudentController {
    private EstudianteDao dao = new EstudianteDao();

    public void crearEstudiante(int id, String nombre, int edad, int carrera) {
        dao.crear(new Estudiante(id, nombre, edad, carrera));
    }

    public List<Estudiante> listarEstudiantes() {
        return dao.listar();
    }

    public void actualizarEstudiante(int id, String nombre, int edad, int carrera) {
        dao.actualizar(new Estudiante(id, nombre, edad, carrera));
    }

    public void eliminarEstudiante(int id) {
        dao.eliminar(id);
    }
}