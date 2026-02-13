package view;

import controller.StudentController;

public class StudentView {
    private StudentController controller = new StudentController();

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