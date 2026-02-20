package Control;

import Logic.Criptomoneda;
import Logic.Paypal;
import Logic.TarjetaDeCredito;

public class Controller {
public String interfazTarjeta(String num, String monto){
    int montoD = Integer.parseInt(monto);
    TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito(num, montoD);
    return tarjetaDeCredito.procesarPago(montoD);
}
public String interfazCriptomoneda(String tipo, String n){
    int nI = Integer.parseInt(n);
    Criptomoneda criptomoneda = new Criptomoneda(tipo, nI);
    return criptomoneda.procesarPago(nI);
}

public String interfazPaypal(String email, String m){
    int mI = Integer.parseInt(m);
    Paypal paypal = new Paypal(email, mI);
    return paypal.procesarPago(mI);
}
}
