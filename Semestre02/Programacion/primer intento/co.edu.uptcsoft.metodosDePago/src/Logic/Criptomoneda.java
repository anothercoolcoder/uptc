package Logic;

public class Criptomoneda implements ModoPago{
    private String tipo;

    @Override
    public String procesarPago(int n) {
        return "Procesando con criptomoneda de tipo "+ tipo+" con un monto de $"+n;
    }

    public Criptomoneda(String tipo, int n) {
        this.tipo = tipo;
    }
}
