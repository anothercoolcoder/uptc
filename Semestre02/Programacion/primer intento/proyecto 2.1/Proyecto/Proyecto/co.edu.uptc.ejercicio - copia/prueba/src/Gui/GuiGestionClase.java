package Gui;

import Control.Control;
import Logic.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class GuiGestionClase {
    private Control conversor;
    public GuiGestionClase() {
        this.conversor = new Control();
    }
    public void mostrarMenuPrincipal() {
        Object[] opciones = {"Estudiante", "Instructor"};
        String eleccion;

        do {
            eleccion = (String) JOptionPane.showInputDialog(null,
                    "Seleccione un rol: ",
                    "MENÚ PRINCIPAL",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    "Estudiante"
            );

            if (eleccion == null ) break;

            switch (eleccion) {
                case "Estudiante":
                    menuAccesoEstudiante();
                    break;
                case "Instructor":
                    menuAccesoInstructor();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Cancelando");
                    break;
            }
        } while (true);

        JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
    }
    private void menuAccesoEstudiante() {
        Object[] opciones = {"Registrarse", "Ingresar", "Volver"};
        Object opcionSeleccionada;

        do {
            opcionSeleccionada = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:",
                    "ACCESO ESTUDIANTE",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    "Registrarse");

            if (opcionSeleccionada == null || opcionSeleccionada.equals("Volver")) break;

            switch (opcionSeleccionada.toString()) {
                case "Registrarse":
                    registrarEstudiante();
                    break;
                case "Ingresar":
                    ingresarEstudiante();
                    break;
                case "Volver":
                    JOptionPane.showMessageDialog(null,"Volviendo...");
                    break;
            }
        } while (true);
    }
    private void registrarEstudiante() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField nombreField = new JTextField(10);
        JTextField emailField = new JTextField(10);


        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Email:"));
        panel.add(emailField);

        int result;
        do {
            result = JOptionPane.showConfirmDialog(null, panel, "Registro Estudiante", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    String nombre = nombreField.getText().trim();
                    String email = emailField.getText().trim().replaceAll("\\s+", "");
                    String id = generarIdAleatorio();

                    if (nombre.isEmpty() || email.isEmpty()) {
                        throw new IllegalArgumentException("Todos los campos deben estar llenos.");
                    }
                    if (nombre.matches(".*\\d.*")) {
                        throw new IllegalArgumentException("El nombre no puede contener números.");
                    }
                    if (!email.matches("^[\\w.%-]+@uptc\\.edu\\.co$")) {
                        throw new IllegalArgumentException("El correo debe pertenecer a la universidad UPTC: @uptc.edu.co");
                    }
                    String resultado = conversor.registrarEstudiante(nombre, email, id);
                    JOptionPane.showMessageDialog(null, "ID generado: " + id + "\n" + resultado);
                    break;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            } else {
                break;
            }
        } while (true);
    }

    private void ingresarEstudiante() {
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del estudiante:");
        Estudiante estudiante = conversor.buscarEstudiante(id);
        if (estudiante != null) {
            JOptionPane.showMessageDialog(null, "Bienvenido " + estudiante.getNombre());
            menuEstudiante(estudiante);
        } else {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
        }
    }
    private void menuEstudiante(Estudiante estudiante) {
        Object[] opciones = {"Ver cursos disponibles", "Inscribirse en curso", "Ver mis cursos", "Volver"};
        Object opcionSeleccionada;

        do {
            opcionSeleccionada = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:",
                    "MENÚ ESTUDIANTE",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    "Ver cursos disponibles");

            if (opcionSeleccionada == null || opcionSeleccionada.equals("Volver")) break;

            switch (opcionSeleccionada.toString()) {
                case "Ver cursos disponibles":
                    verCursosDisponibles();
                    break;
                case "Inscribirse en curso":
                    inscribirseDisponibles(estudiante.getId());
                    break;
                case "Ver mis cursos":
                    verMisCursos(estudiante);
                    break;
            }
        } while (true);
    }
    private void verCursosDisponibles() {
    StringBuilder sb = new StringBuilder();
    for (Curso curso : conversor.obtenerCursosDisponibles()) {
        sb.append("- ").append(curso.getNombre())
                .append("\n  Descripción: ").append(curso.getDescripcion())
                .append("\n  Lecciones:\n");

        for (Leccion leccion : curso.getLecciones()) {
            sb.append("    * ").append(leccion.getTitulo())
                    .append(" (Duración: ").append(leccion.getDuracion()).append(" mins)\n");
        }
        sb.append("\n");
    }

    JOptionPane.showMessageDialog(null, sb.toString().isEmpty() ? "No hay cursos disponibles" : sb.toString());
}
    private void inscribirseEnCurso(Estudiante estudiante) {
            String nombreCurso = JOptionPane.showInputDialog(null, "Nombre del curso para inscribirse:");
            String resultado = conversor.inscribirEstudianteCurso(estudiante.getId(), nombreCurso);
            JOptionPane.showMessageDialog(null, resultado);
        }
    private void verMisCursos(Estudiante estudiante) {
        List<Curso> cursos = conversor.obtenerCursosEstudiante(estudiante.getId());

        for (Curso curso : cursos) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("Curso: " + curso.getNombre()));

            List<JCheckBox> checkBoxes = new ArrayList<>();
            for (Leccion leccion : curso.getLecciones()) {
                JCheckBox checkBox = new JCheckBox(leccion.getTitulo(), leccion.isCompletada());
                checkBoxes.add(checkBox);
                panel.add(checkBox);
            }

            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Marcar lecciones como completadas", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                for (int i = 0; i < checkBoxes.size(); i++) {
                    boolean completado = checkBoxes.get(i).isSelected();
                    Leccion leccion = curso.getLecciones().get(i);
                    leccion.setCompletada(completado);

                    conversor.actualizarEstadoLeccion(estudiante.getId(), curso.getNombre(), leccion);
                }
            }
        }
    }

    private void menuAccesoInstructor() {
        Object[] opciones = {"Registrarse", "Ingresar", "Volver"};
        Object opcionSeleccionada;

        do {
            opcionSeleccionada = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:",
                    "ACCESO INSTRUCTOR",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    "Registrarse");
            if (opcionSeleccionada == null || opcionSeleccionada.equals("Volver")) break;

            switch (opcionSeleccionada.toString()) {
                case "Registrarse":
                    registrarInstructor();
                    break;
                case "Ingresar":
                    ingresarInstructor();
                    break;
            }
        } while (true);
    }
    private void registrarInstructor() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField nombreField = new JTextField(10);
        JTextField emailField = new JTextField(10);

        String[] tipos = {"creador", "director"};
        JComboBox<String> tipoBox = new JComboBox<>(tipos);

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Email:"));
        panel.add(emailField);

        panel.add(new JLabel("Tipo:"));
        panel.add(tipoBox);

        int result;
        do {
            result = JOptionPane.showConfirmDialog(null, panel, "Registro Instructor", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    String nombre = nombreField.getText();
                    String email = emailField.getText().trim().replaceAll("\\s+", "");
                    String id = generarIdAleatorio();

                    if (nombre.isEmpty() || email.isEmpty()) {
                        throw new IllegalArgumentException("Todos los campos deben estar llenos.");
                    }

                    if (nombre.matches(".*\\d.*")) {
                        throw new IllegalArgumentException("El nombre no puede contener números.");
                    }
                    if (!email.matches("^[\\w.%-]+@uptc\\.edu\\.co$")) {
                        throw new IllegalArgumentException("El correo debe pertenecer a la universidad UPTC: @uptc.edu.co");
                    }

                    String resultado = conversor.registrarInstructor(nombre, email, id, tipoBox.getSelectedItem().toString());
                    JOptionPane.showMessageDialog(null, "ID generado: " + id + "\n" + resultado);
                    break;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            } else {
                break;
            }
        } while (true);
    }

    private void ingresarInstructor() {
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del instructor:");
        Instructor instructor = conversor.buscarInstructor(id);
        if (instructor != null) {
            JOptionPane.showMessageDialog(null, "Bienvenido " + instructor.getNombre());
            if (instructor instanceof InstructorRector) {
                menuInstructorCreador((InstructorRector) instructor);
            } else if (instructor instanceof InstructorDirector) {
                menuInstructorDirector((InstructorDirector) instructor);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Instructor no encontrado");
        }
    }
    private void menuInstructorCreador(InstructorRector instructor) {
        Object[] opciones = {"Crear curso", "Crear nueva leccion" ,"Volver"};
        Object opcionSeleccionada;

        do {
            opcionSeleccionada = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:",
                    "MENÚ INSTRUCTOR RECTOR",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (opcionSeleccionada == null || opcionSeleccionada.equals("Volver")) break;

            if (opcionSeleccionada.toString().equals("Crear curso")) {
                crearCurso(instructor);
            }
            switch (opcionSeleccionada.toString()) {
                case "Crear nueva leccion":
                    editarLeccion(instructor);
                    break;
            }
        } while (true);
    }
    private void menuInstructorDirector(InstructorDirector instructor) {
        Object[] opciones = {"Eliminar curso", "Cambiar descripción","Ver estudiantes inscritos", "Volver"};
        Object opcionSeleccionada;

        do {
            opcionSeleccionada = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:",
                    "MENÚ INSTRUCTOR DIRECTOR",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (opcionSeleccionada == null || opcionSeleccionada.equals("Volver")) break;

            switch (opcionSeleccionada.toString()) {
                case "Eliminar curso":
                    eliminarCurso(instructor);
                    break;
                case "Cambiar descripción":
                    modificarDescripcionCurso(instructor);
                    break;
                case "Ver estudiantes inscritos":
                    verInscritos(instructor);
                    break;
            }
        } while (true);
    }
    private void crearCurso(InstructorRector instructor) {
        JTextField nombreField = new JTextField();
        JTextField descripcionField = new JTextField();
        Object[] campos = {
                "Nombre del curso:", nombreField,
                "Descripción:", descripcionField
        };
        int result = JOptionPane.showConfirmDialog(null, campos, "Crear Curso", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String resultado = conversor.crearNuevoCurso(nombreField.getText(), descripcionField.getText(), instructor.getId());
            JOptionPane.showMessageDialog(null, resultado);
        }
    }
    private void eliminarCurso(InstructorDirector instructor) {
        String nombre = JOptionPane.showInputDialog(null, "Nombre del curso a eliminar:");
        String resultado = conversor.eliminarCurso(nombre, instructor.getId());
        JOptionPane.showMessageDialog(null, resultado);
    }
    private void modificarDescripcionCurso(InstructorDirector instructor) {
        JTextField nombreField = new JTextField();
        JTextField descripcionField = new JTextField();
        Object[] campos = {
                "Nombre del curso:", nombreField,
                "Nueva descripción:", descripcionField
        };
        int result = JOptionPane.showConfirmDialog(null, campos, "Modificar Descripción", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String resultado = conversor.modificarDescripcionCurso(nombreField.getText(), instructor.getId(), descripcionField.getText());
            JOptionPane.showMessageDialog(null, resultado);
        }
    }
    private void editarLeccion(InstructorRector instructorRector) {
        List<String> opciones = conversor.obtenerCursos();
        if (opciones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay cursos disponibles");
            return;
        }

        String eleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el curso a editar",
                "Cursos",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones.toArray(),
                opciones.get(0)
        );

        if (eleccion == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
            return;
        }

        Curso curso = conversor.obtenerCursoPorNombre(eleccion);
        if (curso == null) {
            JOptionPane.showMessageDialog(null, "Curso no encontrado.");
            return;
        }

        JTextField tituloField = new JTextField();
        JTextField contenidoField = new JTextField();
        JTextField duracionField = new JTextField();

        Object[] campos = {
                "Título de la lección:", tituloField,
                "Contenido de la lección:", contenidoField,
                "Duración (minutos):", duracionField
        };

        int result = JOptionPane.showConfirmDialog(null, campos, "Agregar nueva lección", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String titulo = tituloField.getText().trim();
                String contenido = contenidoField.getText().trim();
                String duracionTexto = duracionField.getText().trim();

                if (titulo.isEmpty() || contenido.isEmpty() || duracionTexto.isEmpty()) {
                    throw new IllegalArgumentException("Todos los campos deben estar llenos.");
                }

                int duracion = Integer.parseInt(duracionTexto);
                if (duracion <= 0) {
                    throw new IllegalArgumentException("La duración debe ser un número positivo.");
                }

                String resultado = conversor.agregarLeccionACurso(curso.getNombre(), titulo, contenido, duracion);
                JOptionPane.showMessageDialog(null, resultado);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La duración debe ser un número válido.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        }
    }
    public void inscribirseDisponibles(String id){
        List<String> opciones2 = conversor.obtenerCursos();
        if(opciones2.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay cursos disponibles");
            return;
        }
        String eleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el curso al cual desea inscribirse",
                "Inscripciones de cursos",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones2.toArray(),
                opciones2.get(0)
        );
        if (eleccion != null){
            String resultado = conversor.inscribirEstudianteCurso(id, eleccion);
            JOptionPane.showMessageDialog(null, resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        }

    }
    public String cursosDiponibles(String id){
        List<String> opciones2 = conversor.obtenerCursos();
        if(opciones2.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay cursos disponibles");
            return null;
        }

        String eleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el curso que desea ver",
                "Inscritos en cursos ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones2.toArray(),
                opciones2.get(0)
        );
        return eleccion;
    }
    private void verInscritos (Instructor instructor){
        String nombreCurso = cursosDiponibles(instructor.getId()); // obtiene el curso seleccionado
        if (nombreCurso != null) {
            String resultado = conversor.estudiantesInscritos(nombreCurso, instructor.getId());
            JOptionPane.showMessageDialog(null, resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        }
    }
    private String generarIdAleatorio() {
        return String.valueOf((int)(Math.random() * 900000 + 100000)); // Genera un número de 6 dígitos
    }

}