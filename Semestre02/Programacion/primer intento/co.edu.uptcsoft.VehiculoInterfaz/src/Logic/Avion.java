package Logic;

public class Avion extends Vehiculo implements ControlVelocidad {
    public Avion(byte velocidad, byte velocidadMax, String placa) {
        super(velocidad, velocidadMax, placa);
    }

    @Override
    public String velocidadActual() {
        return super.velocidadActual();
    }

    @Override
    public boolean estado() {
        return false;
    }

    @Override
    public int Acelerar() {
        return ControlVelocidad.super.Acelerar();
    }

    @Override
    public int Frenar() {
        return ControlVelocidad.super.Frenar();
    }
}
