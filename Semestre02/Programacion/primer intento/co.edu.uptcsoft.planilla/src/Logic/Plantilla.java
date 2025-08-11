package Logic;

import java.util.ArrayList;
import java.util.Comparator;

public class Plantilla {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    public void agregarEstudiante(Estudiante e){
        estudiantes.add(e);
    }
    public String mostrarPlantilla(){
        StringBuilder sb = new StringBuilder("Listado de estudiantes\n");
        int index = 1; // en la primera iteracion es el valor original
        for (Estudiante e : estudiantes){
            sb.append(index++).append(". ").append(e.toString()).append("\n");
        }
        return sb.toString();
    }
    public void ordenarDefinitiva(){
        estudiantes.sort( (a,b)-> Double.compare(b.getDefinitiva(),a.getDefinitiva()));
    }
    public void ordenarNombre(){
        estudiantes.sort(Comparator.comparing(Estudiante::getNombre));
    }
    public ArrayList<String> getEstudiantes(){
        ArrayList<String> nombres = new ArrayList<>();
        for (Estudiante e : estudiantes){
            nombres.add(e.getNombre());
        }
        return nombres;
    }
    public Estudiante buscar(String nombre){
        for(Estudiante e : estudiantes){
            if(e.getNombre().equalsIgnoreCase(nombre)){
                return e;
            }
        }
        return null;
    }
    public boolean editarNombre(String actual, String nuevo){
        Estudiante e = buscar(actual);
        if (e != null){
            e.setNombre(nuevo.toUpperCase());
            return true;
        }
        return false;
    }
    public boolean editarNota(String nombre, int indexNota, double nuevaNota){
        Estudiante e = buscar(nombre);
        if(e != null && indexNota >= 0 && indexNota <e.cantidadNotas()){
            e.setNota(indexNota, nuevaNota);
            return true;
        }
        return false;
    }
    public boolean borrar(String name){
        for (int i = 0; i < estudiantes.size(); i++) {
            if(estudiantes.get(i).getNombre().equalsIgnoreCase(name)){
                estudiantes.remove(i);
                return true;
            }
        }
        return false;
    }

}
