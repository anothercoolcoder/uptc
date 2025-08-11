package LOGIC;

public class Pasante extends Empleado{
    private double bono;
    public Pasante(String nombre, String id, double bono) {
        super(nombre, id);
        this.bono = bono;
    }

    @Override
    public double calcularSalario() {
        return bono;
    }
}
