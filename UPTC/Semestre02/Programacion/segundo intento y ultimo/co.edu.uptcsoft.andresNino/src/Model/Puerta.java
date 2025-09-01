package Model;

public class Puerta {
    public boolean state;
    public boolean tipoDePago;

    public Puerta(boolean state, boolean tipoDePago) {
        this.state = state;
        this.tipoDePago = tipoDePago;
    }

    public String isState() {
        if (state){
            return "Abierta";
        }else {
            return "Cerrado";
        }
    }

    public String isTipoDePago() {
        if (tipoDePago){
            return "Efectivo";
        }else {
            return "Tarjeta";
        }
    }

    @Override
    public String toString() {
        return  "Estado: " + isState() + "\n" +
                "Tipo de pago: " + isTipoDePago();
    }
}
