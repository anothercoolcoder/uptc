package Gui;

import Logic.Estudiante;
import Logic.Instructor;
import Logic.Curso;
import Logic.Leccion;
import Control.ControlClase;
import java.util.Scanner;
import java.util.List;

public class GuiGestionClase {
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n----BIENVENIDO A CURSOS EN LINEA----");
            System.out.println("-----------------MENU----------------");
            System.out.println("1. Ingresar como estudiante");
            System.out.println("2. Ingresar como instructor");
            System.out.println("3. Crear nuevo usuario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        gestionarEstudiante();
                        break;
                    case 2:
                        gestionarInstructor();
                        break;
                    case 3:
                        gestionUsuario();
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("ERROR: Debe ingresar un número válido.");
                sc.next();
            }
        } while (opcion != 4);
    }

    private void gestionarInstructor() {
        System.out.println("\n--- GESTIÓN DE INSTRUCTOR ---");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrarse");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                iniciarSesionInstructor();
                break;
            case 2:
                registrarInstructor();
                break;
            default:
                System.out.println("Opción inválida. Regresando al menú principal...");
        }
    }

    private void iniciarSesionInstructor() {
        System.out.print("Ingrese su correo: ");
        String email = sc.nextLine();

        for (Instructor instructor : ControlClase.getInstructores()) {
            if (instructor.getEmail().equals(email)) {
                System.out.println("\nBienvenido, " + instructor.getNombre() + ".");
                if (instructor.esCreador()) {
                    menuInstructorCreador(instructor);
                } else if (instructor.esDirector()) {
                    menuInstructorDirector(instructor);
                }
                return;
            }
        }
        System.out.println("Correo no encontrado. Regístrese primero.");
    }

    private void menuInstructorCreador(Instructor instructor) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ INSTRUCTOR CREADOR ---");
            System.out.println("1. Crear nuevo curso");
            System.out.println("2. Cambiar nombre de curso");
            System.out.println("3. Ver mis cursos");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearCurso(instructor);
                    break;
                case 2:
                    cambiarNombreCurso(instructor);
                    break;
                case 3:
                    verCursosInstructor(instructor);
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    private void menuInstructorDirector(Instructor instructor) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ INSTRUCTOR DIRECTOR ---");
            System.out.println("1. Cambiar nombre de lecciones");
            System.out.println("2. Cambiar cantidad de lecciones");
            System.out.println("3. Cambiar duración de lecciones");
            System.out.println("4. Ver cursos asignados");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    cambiarNombreLecciones(instructor);
                    break;
                case 2:
                    cambiarCantidadLecciones(instructor);
                    break;
                case 3:
                    cambiarDuracionLecciones(instructor);
                    break;
                case 4:
                    verCursosInstructor(instructor);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private void crearCurso(Instructor instructor) {
        System.out.print("\nIngrese el nombre del curso: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la descripción del curso: ");
        String descripcion = sc.nextLine();

        Curso nuevoCurso = new Curso(nombre, descripcion, true);
        nuevoCurso.setInstructor(instructor);
        ControlClase.agregarCurso(nuevoCurso);

        System.out.println("\nCurso creado exitosamente!");
    }

    private void cambiarNombreCurso(Instructor instructor) {
        List<Curso> cursos = ControlClase.getCursosPorInstructor(instructor);
        if (cursos.isEmpty()) {
            System.out.println("\nNo tiene cursos asignados.");
            return;
        }

        System.out.println("\n--- SUS CURSOS ---");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
        }

        System.out.print("Seleccione el número del curso a modificar: ");
        int numCurso = sc.nextInt();
        sc.nextLine();

        if (numCurso < 1 || numCurso > cursos.size()) {
            System.out.println("Número de curso inválido.");
            return;
        }

        System.out.print("Ingrese el nuevo nombre para el curso: ");
        String nuevoNombre = sc.nextLine();

        cursos.get(numCurso - 1).setNombre(nuevoNombre);
        System.out.println("\nNombre del curso actualizado exitosamente!");
    }

    private void cambiarNombreLecciones(Instructor instructor) {
        List<Curso> cursos = ControlClase.getCursosPorInstructor(instructor);
        if (cursos.isEmpty()) {
            System.out.println("\nNo tiene cursos asignados.");
            return;
        }

        System.out.println("\n--- SUS CURSOS ---");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
        }

        System.out.print("Seleccione el número del curso: ");
        int numCurso = sc.nextInt();
        sc.nextLine();

        if (numCurso < 1 || numCurso > cursos.size()) {
            System.out.println("Número de curso inválido.");
            return;
        }

        Curso curso = cursos.get(numCurso - 1);
        List<Leccion> lecciones = curso.getLecciones();

        if (lecciones.isEmpty()) {
            System.out.println("\nEste curso no tiene lecciones.");
            return;
        }

        System.out.println("\n--- LECCIONES DEL CURSO ---");
        for (int i = 0; i < lecciones.size(); i++) {
            System.out.println((i + 1) + ". " + lecciones.get(i).getTitulo());
        }

        System.out.print("Seleccione el número de la lección a modificar: ");
        int numLeccion = sc.nextInt();
        sc.nextLine();

        if (numLeccion < 1 || numLeccion > lecciones.size()) {
            System.out.println("Número de lección inválido.");
            return;
        }

        System.out.print("Ingrese el nuevo nombre para la lección: ");
        String nuevoNombre = sc.nextLine();

        lecciones.get(numLeccion - 1).setTitulo(nuevoNombre);
        System.out.println("\nNombre de lección actualizado exitosamente!");
    }

    private void verCursosInstructor(Instructor instructor) {
        List<Curso> cursos = ControlClase.getCursosPorInstructor(instructor);

        if (cursos.isEmpty()) {
            System.out.println("\nNo tiene cursos asignados.");
            return;
        }

        System.out.println("\n--- SUS CURSOS ---");
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            System.out.println((i + 1) + ". " + curso.getNombre() +
                    " (" + curso.getLecciones().size() + " lecciones)");
        }
    }

    private void gestionarEstudiante() {
        System.out.println("\n--- GESTIÓN DE ESTUDIANTE ---");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrarse");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                iniciarSesionEstudiante();
                break;
            case 2:
                registrarEstudiante();
                break;
            default:
                System.out.println("Opción inválida. Regresando al menú principal...");
        }
    }

    private void iniciarSesionEstudiante() {
        System.out.print("Ingrese su correo: ");
        String email = sc.nextLine();
        for (Estudiante estudiante : ControlClase.getEstudiantes()) {
            if (estudiante.getEmail().equals(email)) {
                System.out.println("Bienvenido, " + estudiante.getNombre() + ".");
                return;
            }
        }
        System.out.println("Correo no encontrado. Regístrese primero.");
    }

    private void gestionUsuario() {
        System.out.println("\n--- CREACIÓN DE USUARIO ---");
        System.out.println("1. Registrarse como estudiante");
        System.out.println("2. Registrarse como instructor");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                registrarEstudiante();
                break;
            case 2:
                registrarInstructor();
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void registrarEstudiante() {
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su correo: ");
        String email = sc.nextLine();
        System.out.println("Ingrese su id");
        String id = sc.nextLine();

        Estudiante nuevoEstudiante = new Estudiante(nombre, email, id);
        ControlClase.agregarEstudiante(nuevoEstudiante);
        System.out.println("Estudiante registrado exitosamente!");
    }

    private void registrarInstructor() {
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su correo: ");
        String email = sc.nextLine();
        System.out.println("Ingrese su id");
        String id = sc.nextLine();

        System.out.print("Tipo de instructor (creador/director): ");
        String tipo = sc.nextLine().toLowerCase();

        if (!tipo.equals("creador") && !tipo.equals("director")) {
            System.out.println("Tipo de instructor no válido. Debe ser 'creador' o 'director'.");
            return;
        }

        Instructor nuevoInstructor = new Instructor(nombre, email,id, tipo);
        ControlClase.agregarInstructor(nuevoInstructor);
        System.out.println("Instructor registrado exitosamente!");
    }

    private void cambiarCantidadLecciones(Instructor instructor) {
        List<Curso> cursos = ControlClase.getCursosPorInstructor(instructor);
        if (cursos.isEmpty()) {
            System.out.println("\nNo tiene cursos asignados.");
            return;
        }

        System.out.println("\n--- SUS CURSOS ---");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre() +
                    " (" + cursos.get(i).getLecciones().size() + " lecciones)");
        }

        System.out.print("Seleccione el número del curso: ");
        int numCurso = sc.nextInt();
        sc.nextLine();

        if (numCurso < 1 || numCurso > cursos.size()) {
            System.out.println("Número de curso inválido.");
            return;
        }

        Curso curso = cursos.get(numCurso - 1);

        System.out.println("\n1. Agregar nueva lección");
        System.out.println("2. Eliminar última lección");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                agregarNuevaLeccion(curso);
                break;
            case 2:
                if (curso.getLecciones().isEmpty()) {
                    System.out.println("No hay lecciones para eliminar.");
                } else {
                    curso.getLecciones().remove(curso.getLecciones().size() - 1);
                    System.out.println("Última lección eliminada.");
                }
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void cambiarDuracionLecciones(Instructor instructor) {
        List<Curso> cursos = ControlClase.getCursosPorInstructor(instructor);
        if (cursos.isEmpty()) {
            System.out.println("\nNo tiene cursos asignados.");
            return;
        }

        System.out.println("\n--- SUS CURSOS ---");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
        }

        System.out.print("Seleccione el número del curso: ");
        int numCurso = sc.nextInt();
        sc.nextLine();

        if (numCurso < 1 || numCurso > cursos.size()) {
            System.out.println("Número de curso inválido.");
            return;
        }

        Curso curso = cursos.get(numCurso - 1);
        List<Leccion> lecciones = curso.getLecciones();

        if (lecciones.isEmpty()) {
            System.out.println("\nEste curso no tiene lecciones.");
            return;
        }

        System.out.println("\n--- LECCIONES DEL CURSO ---");
        for (int i = 0; i < lecciones.size(); i++) {
            Leccion leccion = lecciones.get(i);
            System.out.println((i + 1) + ". " + leccion.getTitulo() +
                    " (Duración actual: " + leccion.getDuracion() + " minutos)");
        }

        System.out.print("Seleccione el número de la lección a modificar: ");
        int numLeccion = sc.nextInt();
        sc.nextLine();

        if (numLeccion < 1 || numLeccion > lecciones.size()) {
            System.out.println("Número de lección inválido.");
            return;
        }

        System.out.print("Ingrese la nueva duración en minutos: ");
        int nuevaDuracion = sc.nextInt();
        sc.nextLine();

        if (nuevaDuracion <= 0) {
            System.out.println("La duración debe ser un número positivo.");
            return;
        }

        lecciones.get(numLeccion - 1).setDuracion(nuevaDuracion);
        System.out.println("\nDuración de la lección actualizada exitosamente!");
    }

    private void agregarNuevaLeccion(Curso curso) {
        System.out.print("\nIngrese el título de la nueva lección: ");
        String titulo = sc.nextLine();

        System.out.print("Ingrese el contenido de la lección: ");
        String contenido = sc.nextLine();

        System.out.print("Ingrese la duración en minutos: ");
        int duracion = sc.nextInt();
        sc.nextLine();

        if (duracion <= 0) {
            System.out.println("La duración debe ser un número positivo.");
            return;
        }

        Leccion nuevaLeccion = new Leccion(titulo, contenido, duracion);
        curso.agregarLeccion(nuevaLeccion);
        System.out.println("Nueva lección agregada exitosamente!");
    }
}