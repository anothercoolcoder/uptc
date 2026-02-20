package Logic;

public interface ModoPago {
    default String validarPago(){
        return "Validando pago";
    }

    String procesarPago(int n);
}
