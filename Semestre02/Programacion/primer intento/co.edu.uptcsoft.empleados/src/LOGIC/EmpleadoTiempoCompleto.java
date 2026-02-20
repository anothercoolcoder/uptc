package LOGIC;

public class EmpleadoTiempoCompleto extends Empleado{
    private double salarioMensual;

    public EmpleadoTiempoCompleto(String nombre, String id, double salarioMensual) {
        super(nombre, id);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSalario() {
        return salarioMensual;
    }
}
