package Logic;

import Model.Peaje;
import Model.Puerta;
import Model.Vehiculo;

public class Logic {
    Peaje peaje;
    public String interfaceVehiculo(int saldo, boolean tipoDePago, String tipoDeVehiculo) {
        Model.Vehiculo vehiculo = new Vehiculo(saldo, tipoDePago, tipoDeVehiculo);
        return "El vehiculo ha sido creado";
    }

    public String interfaceDoor(boolean state, boolean tipoDePago){
        Puerta puerta = new Puerta(state,tipoDePago);
        peaje.addDoor(puerta.toString());
        return puerta.toString();
    }

    public String validacion(Vehiculo vehiculo, Puerta puerta){
        if (puerta.state){
            if (vehiculo.isTipoDePago() == puerta.tipoDePago){

                switch (vehiculo.getTipoDeVehiculo()){
                    case "grande":
                        if (vehiculo.getSaldo() >= peaje.tarifaG){
                            return "Puede pasar";
                        }else {
                            return "No puede pasar, no le alcanza el saldo";
                        }
                    case "pequeño":
                        if (vehiculo.getSaldo()>= peaje.tarifaP){
                            return "Puede pasar";
                        }else{
                            return "No puede pasar, no le alcanza el saldo";
                        }
                    default:
                        return "Este vehiculo no esta permitido";
                }
            }else {
                return "No puede pasar, el tipo de pago no es el mismo";
            }
        } else {
            return "La puerta esta cerrada";
        }

    }

    public String[] showDoors(){
        return peaje.showDoors();
    }
    public String interfacePeaje(double tarifaG, double tarifaP, int puertas){
        peaje = new Peaje(tarifaG, tarifaP, puertas);
        return peaje.toString();
    }
}
