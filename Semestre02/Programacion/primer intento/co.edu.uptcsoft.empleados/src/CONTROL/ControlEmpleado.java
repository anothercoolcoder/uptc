package CONTROL;

import LOGIC.EmpleadoPorHoras;
import LOGIC.EmpleadoTiempoCompleto;
import LOGIC.Pasante;

public class ControlEmpleado {
    public String interfazEmpleadoPorHoras(String nombre, String id, String tarifaPorHoras, String horasTrabajadas){
        double tarifaPorHorasD = Double.parseDouble(tarifaPorHoras);
        int horasTrabajadasD = Integer.parseInt(horasTrabajadas);
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras(nombre, id,tarifaPorHorasD,horasTrabajadasD);
        return String.valueOf(empleadoPorHoras);
    }

    public String interfazEmpleadoTiempoCompleto(String nombre, String id, String salarioMensual){
        double salarioMensualD = Double.parseDouble(salarioMensual);
        EmpleadoTiempoCompleto empleadoTiempoCompleto = new EmpleadoTiempoCompleto(nombre, id, salarioMensualD);
        return String.valueOf(empleadoTiempoCompleto);
    }

    public String interfazPasante(String nombre, String id, String bono){
        double bonoD = Double.parseDouble(bono);
        Pasante pasante = new Pasante(nombre, id, bonoD);
        return String.valueOf(pasante);
    }
}
