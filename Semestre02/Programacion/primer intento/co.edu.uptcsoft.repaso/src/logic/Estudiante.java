package logic;

public class Estudiante {
    private String nombre,codigo;

    public Estudiante(String nom, String cod){

        setNombre(nom);
        setCodigo(cod);
    }
    public Estudiante(){


    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
