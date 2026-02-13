package controller;

import java.util.List;

import dao.StudentDao;
import model.Student;

public class StudentController {
    private StudentDao dao = new StudentDao();

    public void createStudent(int id, String nombre, int edad, String carrera) {
        dao.create(new Student(id, nombre, edad, carrera));
    }

    public List<Student> listarEstudiantes() {
        return dao.list();
    }

    public void updateStudent(int id, String nombre, int edad, String carrera) {
        dao.update(new Student(id, nombre, edad, carrera));
    }

    public void eliminarEstudiante(int id) {
        dao.remove(id);
    }
}