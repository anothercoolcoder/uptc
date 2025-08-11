package LOGICA;

public class Vehiculo {
    private byte capacidad, nivel, tanqueoParcial;

    public Vehiculo(byte capacidad, byte nivel) {
        setCapacidad(capacidad);
        setNivel(nivel);
    }

    public void setCapacidad(byte capacidad) {
        this.capacidad = capacidad;
    }

    public void setNivel(byte nivel) {
        this.nivel = nivel;
    }

    public byte getCapacidad() {
        return capacidad;
    }

    public byte getNivel() {
        return nivel;
    }
}
