package Gui;

import Control.Conversion;
import Logic.*;
import java.util.Scanner;

public class GuiGestionClase {
    private Scanner sc;
    private Conversion conversor;

    public GuiGestionClase() {
        this.sc = new Scanner(System.in);
        this.conversor = new Conversion();
    }

    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ingresar como estudiante");
            System.out.println("2. Ingresar como instructor");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    menuAccesoEstudiante();
                    break;
                case 2:
                    menuAccesoInstructor();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while(opcion != 3);
    }

    private void menuAccesoEstudiante() {
        int opcion;
        do {
            System.out.println("\n--- ACCESO ESTUDIANTE ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Ingresar");
            System.out.println("3. Volver");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    ingresarEstudiante();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while(opcion != 3);
    }

    private void menuEstudiante(Estudiante estudiante) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ESTUDIANTE ---");
            System.out.println("1. Inscribirse en curso");
            System.out.println("2. Ver mis cursos");
            System.out.println("3. Volver");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    inscribirseEnCurso(estudiante);
                    break;
                case 2:
                    verMisCursos(estudiante);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while(opcion != 3);
    }

    private void registrarEstudiante() {
        System.out.println("\n--- REGISTRO ESTUDIANTE ---");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("ID: ");
        String id = sc.nextLine();

        String resultado = conversor.registrarEstudiante(nombre, email, id);
        System.out.println("\n" + resultado);
    }

    private void ingresarEstudiante() {
        System.out.println("\n--- INGRESO ESTUDIANTE ---");
        System.out.print("ID del estudiante: ");
        String id = sc.nextLine();

        Estudiante estudiante = conversor.buscarEstudiante(id);
        if (estudiante != null) {
            System.out.println("\nBienvenido " + estudiante.getNombre());
            menuEstudiante(estudiante);
        } else {
            System.out.println("Estudiante no encontrado");
        }
    }

    private void inscribirseEnCurso(Estudiante estudiante) {
        System.out.println("\n--- INSCRIPCIÓN EN CURSO ---");
        System.out.print("Nombre del curso: ");
        String nombreCurso = sc.nextLine();

        String resultado = conversor.inscribirEstudianteCurso(estudiante.getId(), nombreCurso);
        System.out.println("\n" + resultado);
    }

    private void verMisCursos(Estudiante estudiante) {
        String cursos = conversor.listarCursosEstudiante(estudiante.getId());
        System.out.println("\n--- MIS CURSOS ---");
        System.out.println(cursos);
    }

    private void menuAccesoInstructor() {
        int opcion;
        do {
            System.out.println("\n--- ACCESO INSTRUCTOR ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Ingresar");
            System.out.println("3. Volver");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    registrarInstructor();
                    break;
                case 2:
                    ingresarInstructor();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while(opcion != 3);
    }

    private void registrarInstructor() {
        System.out.println("\n--- REGISTRO INSTRUCTOR ---");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Tipo (creador/director): ");
        String tipo = sc.nextLine();

        String resultado = conversor.registrarInstructor(nombre, email, id, tipo);
        System.out.println("\n" + resultado);
    }

    private void ingresarInstructor() {
        System.out.println("\n--- INGRESO INSTRUCTOR ---");
        System.out.print("ID del instructor: ");
        String id = sc.nextLine();

        Instructor instructor = conversor.buscarInstructor(id);
        if (instructor != null) {
            System.out.println("\nBienvenido " + instructor.getNombre());
            menuInstructor(instructor);
        } else {
            System.out.println("Instructor no encontrado");
        }
    }

    private void menuInstructor(Instructor instructor) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ INSTRUCTOR ---");
            System.out.println("1. Crear curso (solo creadores)");
            System.out.println("2. Gestionar cursos (solo directores)");
            System.out.println("3. Volver");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    if (instructor instanceof InstructorCreador) {
                        crearCurso((InstructorCreador) instructor);
                    } else {
                        System.out.println("Esta opción es solo para instructores creadores");
                    }
                    break;
                case 2:
                    if (instructor instanceof InstructorDirector) {
                        gestionarCursos((InstructorDirector) instructor);
                    } else {
                        System.out.println("Esta opción es solo para instructores directores");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while(opcion != 3);
    }

    private void crearCurso(InstructorCreador instructor) {
        System.out.println("\n--- CREAR CURSO ---");
        System.out.print("Nombre del curso: ");
        String nombre = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        String resultado = conversor.crearCurso(nombre, descripcion, instructor.getId());
        System.out.println("\n" + resultado);
    }

    private void gestionarCursos(InstructorDirector instructor) {
        System.out.println("\n--- GESTIONAR CURSOS ---");
        System.out.print("Nombre del curso a gestionar: ");
        String nombreCurso = sc.nextLine();

        String resultado = conversor.asignarCursoInstructor(nombreCurso, instructor.getId());
        System.out.println("\n" + resultado);
    }
}