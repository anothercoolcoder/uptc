package Gui;
import Control.Control;
import Logic.Estudiante;

import javax.swing.*;
import java.util.ArrayList;

public class Gui{
    Control control = new Control();
    public void vista() {
        addStudents();
    }
    public double pedirNota(String mensaje){
        while (true){
            try{
                String input = JOptionPane.showInputDialog(mensaje + "(0.0 a 5.0)");
                double nota = Double.parseDouble(input);
                if (nota>= 0 && nota <= 5){
                    return nota;
                }
                else throw new NumberFormatException();
            } catch (NumberFormatException e ){
                JOptionPane.showMessageDialog(null, "Nota invalida");
            }
        }
    }
    public void addStudents(){
        int cantidad;

        try{
            String input = JOptionPane.showInputDialog("¿Cuantos estudiantes?");
            cantidad = Integer.parseInt(input);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Valor invalido");
            JOptionPane.showMessageDialog(null, "Se tomara el valor de 2");
            cantidad = 2;
        }
        for (int i = 0; i < cantidad; i++){
            double[] notas = new double[3];
            String nombre;
            String regex = "^[a-zA-Z]{3,10}";
            while(true){
                nombre = JOptionPane.showInputDialog("Nombre del estudiante " + (i+1)).toUpperCase();
                if (nombre.matches(regex)){
                    JOptionPane.showMessageDialog(null, "Tu nombre es correcto.");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Tu nombre no tiene que tener numeros y ha de ser mayor de 2 digitos");
                }
            }

            for (int j = 0; j < notas.length;j++){
                notas[j] = pedirNota("Nota " + (j+1));
            }

            control.agregarEstudiante(nombre, notas);
        }
        JOptionPane.showMessageDialog(null, control.mostrarPlantilla());
        opciones();
    }
    public void opciones(){
        Object[] options = {"Organizar", "Borrar", "Editar", "Cancelar"};
        String choice = (String) JOptionPane.showInputDialog(
                null,
                "¿Que quieres hacer?",
                "Opciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if(choice == null || choice.equals("Cancelar")){
            JOptionPane.showMessageDialog(null, "Cancelando");
            return;
        }
        switch (choice){
            case "Organizar":
                JOptionPane.showMessageDialog(null, "Proceso de organizar iniciado");
                ordenarOpciones();
                JOptionPane.showMessageDialog(null, "Proceso de organizar finalizado");
                break;
            case "Borrar":
                JOptionPane.showMessageDialog(null, "Proceso de borrar iniciado");
                borrarNombre();
                JOptionPane.showMessageDialog(null, "Proceso de borrar finalizado");
                break;
            case "Editar":
                JOptionPane.showMessageDialog(null, "Proceso de editar iniciado");
                editar();
                JOptionPane.showMessageDialog(null, "Proceso de editar finalizado");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Cancelando");
                break;
        }
    }
    public void ordenarOpciones(){
        Object[] options = {"Definitiva", "Nombre", "Cancelar"};
        String choice = (String)
                JOptionPane.showInputDialog(
                null,
                "¿Que quieres hacer?",
                "Opciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        if(choice == null || choice.equals("Cancelar")){
            JOptionPane.showMessageDialog(null, "Cancelando");
            return;
        }
        switch (choice){
            case "Definitiva":
                JOptionPane.showMessageDialog(null, "Ordenando por definitiva...");
                control.ordenarDefinitiva();
                JOptionPane.showMessageDialog(null, control.mostrarPlantilla());
                break;
            case "Nombre":
                JOptionPane.showMessageDialog(null, "Ordenando por nombre...");
                control.ordenarNombre();
                JOptionPane.showMessageDialog(null, control.mostrarPlantilla());
                break;
            default:
                JOptionPane.showMessageDialog(null, "No se realizaron cambios");
                JOptionPane.showMessageDialog(null, control.mostrarPlantilla());
                break;
        }
    } // ordenar nombre y definitiva
    public void borrarNombre(){
        Object[] options = control.obtenerNombres().toArray();
        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona al estudiante a borrar",
                "Borrar estudiante",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        if (choice != null){
            boolean borrado = control.borrarEstudiante(choice);
            if(borrado){
                JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar al estudiante");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operacion cancelada");
        }

        JOptionPane.showMessageDialog(null, control.mostrarPlantilla());
    }
    public void editar(){
        Object[] options = control.obtenerNombres().toArray();
        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona el estudiante a editar",
                "Editar estudiante",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        Estudiante estudiante = control.buscarEstudiante(choice);
        ArrayList<String> campos = new ArrayList<>();
        campos.add("Nombre");
        for(int i = 1; i <= estudiante.cantidadNotas();i++){
            campos.add("Nota " + i);
        }
        String[] camposArray = campos.toArray(new String[0]);

        String campo = (String) JOptionPane.showInputDialog(
                null,
                "¿Que desea editar?",
                "Editar campo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                camposArray,
                camposArray[0]
        );
        switch (campo){
            case "Nombre":
                String nuevoNombre = JOptionPane.showInputDialog(null, "Nuevo nombre: ");
                if(nuevoNombre != null && !nuevoNombre.trim().isEmpty()){
                    if (control.editarNombre(choice, nuevoNombre)){
                        JOptionPane.showMessageDialog(null, "Nombre actualizado");
                    }
                }
                break;
            default:
                try{
                    int index = Integer.parseInt(campo.split(" ")[1])-1;
                    double nuevaNota = pedirNota("Nueva "+ campo);
                    if (control.editarNota(choice, index, nuevaNota)){
                        JOptionPane.showMessageDialog(null, "Nota actualizada");
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar la nota");
                }

                break;
        }

        JOptionPane.showMessageDialog(null, control.mostrarPlantilla());
    }
}