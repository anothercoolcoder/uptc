package Model;

public class Vehiculo {
    int saldo;
    boolean tipoDePago;
    String tipoDeVehiculo;

    public int getSaldo() {
        return saldo;
    }

    public boolean isTipoDePago() {
        return tipoDePago;
    }


    public String getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }


    public Vehiculo(int saldo, boolean tipoDePago, String tipoDeVehiculo) {
        this.saldo = saldo;
        this.tipoDePago = tipoDePago;
        this.tipoDeVehiculo = tipoDeVehiculo;
    }
    public String getTipoPago(){
        if (tipoDePago){
            return "Efectivo";
        }else {
            return "Tarjeta";
        }
    }

    @Override
    public String toString() {
        return  "Tipo: " + tipoDeVehiculo + '\n' +
                "Tipo de pago:" + getTipoPago() + "\n"+
                "Saldo: $" + saldo;
    }
}
