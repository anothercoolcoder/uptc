package Logic;

public class TarjetaDeCredito implements ModoPago{
    private String numero;
    @Override
    public String procesarPago(int n) {
        return "Procesando con tarjeta numero "+ numero +" con un monto de: $" + n;
    }

    public TarjetaDeCredito(String numero,int n) {
        this.numero = numero;
    }
}
