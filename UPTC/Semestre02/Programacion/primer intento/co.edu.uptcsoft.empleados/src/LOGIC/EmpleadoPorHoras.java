package LOGIC;

public class EmpleadoPorHoras extends Empleado{
    private double tarifaPorHoras;
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, String id, double tarifaPorHoras, int horasTrabajadas) {
        super(nombre, id);
        this.tarifaPorHoras = tarifaPorHoras;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return tarifaPorHoras * horasTrabajadas;
    }
}
