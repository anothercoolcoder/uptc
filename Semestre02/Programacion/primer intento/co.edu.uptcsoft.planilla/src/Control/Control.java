package Control;

import Logic.Estudiante;
import Logic.Plantilla;

import java.util.ArrayList;

public class Control {
    private Plantilla plantilla = new Plantilla();
    public void agregarEstudiante(String nombre, double[] notas) {
        Estudiante e = new Estudiante(nombre, notas);
        plantilla.agregarEstudiante(e);
    }
    public String mostrarPlantilla() {
        return plantilla.mostrarPlantilla();
    }
    public void ordenarDefinitiva() {
        plantilla.ordenarDefinitiva();
    }
    public ArrayList<String> obtenerNombres() {
        return plantilla.getEstudiantes();
    }
    public void ordenarNombre() {
        plantilla.ordenarNombre();
    }
    public boolean editarNombre(String actual, String nuevo) {
        return plantilla.editarNombre(actual, nuevo);
    }
    public boolean editarNota(String nombre, int index, double nuevaNota) {
        return plantilla.editarNota(nombre, index, nuevaNota);
    }
    public boolean borrarEstudiante(String nombre){
        return plantilla.borrar(nombre);
    }
    public Estudiante buscarEstudiante(String nombre){
        return plantilla.buscar(nombre);
    }
}
