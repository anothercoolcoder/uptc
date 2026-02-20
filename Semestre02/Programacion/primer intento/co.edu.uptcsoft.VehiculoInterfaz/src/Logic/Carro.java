package Logic;

public class Carro extends Vehiculo implements ControlVelocidad{

    public Carro(byte velocidad, byte velocidadMax, String placa) {
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
        return velocidad+1;
    }

    @Override
    public int Frenar() {
        return 0;
    }

}
