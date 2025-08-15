package Logic;

public class Paypal implements ModoPago {
    private String email;
    @Override
    public String procesarPago(int n) {
        return "Procesando con paypal del correo "+email+ " con un monto de: $"+n;
    }

    public Paypal(String email, int n) {
        this.email = email;
    }
}
