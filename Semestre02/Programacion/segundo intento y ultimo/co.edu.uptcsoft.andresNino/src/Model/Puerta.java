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
            return "Tarjeta";
        }else {
            return "Efectivo";
        }
    }
    @Override
    public String toString() {
        return  "Puerta" + "\n" +
                "Estado: " + isState() + "\n" +
                "Tipo de pago: " + isTipoDePago() + "\n";
    }
}
