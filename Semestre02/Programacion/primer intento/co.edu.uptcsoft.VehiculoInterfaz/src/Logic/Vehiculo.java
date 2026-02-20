package Logic;

public abstract class Vehiculo {
    protected byte velocidad, velocidadMax;
    protected String placa;

    public Vehiculo(byte velocidad, byte velocidadMax, String placa) {
        this.velocidad = velocidad;
        this.velocidadMax = velocidadMax;
        this.placa = placa;
    }

    public String velocidadActual(){
        return "La velocidad actual es "+ velocidad + "km/hora";
    };

    abstract boolean estado();
}
