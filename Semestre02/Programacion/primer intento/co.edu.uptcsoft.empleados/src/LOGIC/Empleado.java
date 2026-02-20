package LOGIC;

public abstract class Empleado {
    protected String nombre, id;

    public Empleado(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public abstract double calcularSalario();

    public String getNombre(){
        return nombre;
    }

    public String getId() {
        return id;
    }

    public void mostrarInformacion(){
        System.out.println("Nombre: "+ nombre);
        System.out.println("ID: "+ id);
        System.out.println("Salario: " + calcularSalario());
    }
}
