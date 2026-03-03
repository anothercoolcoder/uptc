package uptc.model;

import java.util.ArrayList;
import java.util.List;


public class PaisModel {
    public int id;
    public String nombre;
    public List<String> departamentos = new ArrayList<>();
    public PaisModel(int id, String nombre, List<String> departamentos) {
        this.id = id;
        this.nombre = nombre;
        this.departamentos = departamentos;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<String> getDepartamentos() {
        return departamentos;
    }
    public void setDepartamentos(List<String> departamentos) {
        this.departamentos = departamentos;
    }
    @Override
    public String toString() {
        return "Pais [id=" + id + ", nombre=" + nombre + ", departamentos=" + departamentos + "]";
    }
    
}
