package Logic;

import Model.Peaje;
import Model.Puerta;
import Model.Vehiculo;

import java.util.ArrayList;
import java.util.Random;

public class Logic {
    ArrayList<Vehiculo> Vehiculos = new ArrayList<>();
    Peaje peaje;
    Random random = new Random();
    public String vehiculosMostrar(){
        StringBuilder st = new StringBuilder();
        int count = 1;
        for (Vehiculo c: Vehiculos){
            st.append("#" + count + " "+ c.toString()+ "\n");
            count++;
        }
        return st.toString();
    }
    public String interfaceVehiculo(int saldo, boolean tipoDePago, String tipoDeVehiculo) {
        Vehiculo vehiculo = new Vehiculo(saldo, tipoDePago, tipoDeVehiculo);
        Vehiculos.add(vehiculo);
        return "El vehiculo ha sido creado" + "\n";
    }
    public String interfaceDoor(boolean state, boolean tipoDePago){
        Puerta puerta = new Puerta(state,tipoDePago);
        peaje.addDoor(puerta);
        return peaje.puertas.get(peaje.puertas.indexOf(puerta)).toString();
    }
    public String validacion(int index){
        Vehiculo vehiculo = Vehiculos.get(index-1);
        Puerta puerta = peaje.puertas.get(random.nextInt(peaje.puertas.size()));

        if (puerta.state){
            if (vehiculo.isTipoDePago() == puerta.tipoDePago){

                switch (vehiculo.getTipoDeVehiculo()){
                    case "grande":
                        if (vehiculo.getSaldo() >= peaje.tarifaG){
                            return "Puede pasar en la puerta #" + ((peaje.puertas.indexOf(puerta))+1) + "\n";
                        }else {
                            return "No puede pasar, no le alcanza el saldo para la puerta #"+ ((peaje.puertas.indexOf(puerta))+1) + "\n";
                        }
                    case "pequeño":
                        if (vehiculo.getSaldo()>= peaje.tarifaP){
                            return "Puede pasar en la puerta" + ((peaje.puertas.indexOf(puerta))+1) + "\n";
                        }else{
                            return "No puede pasar, no le alcanza el saldo para la puerta #" + ((peaje.puertas.indexOf(puerta))+1) + "\n";
                        }
                    default:
                        return "Este vehiculo no esta permitido"+ "\n";
                }
            }else {
                return "No puede pasar, el tipo de pago no es el mismo en la puerta #"+ ((peaje.puertas.indexOf(puerta))+1) + "\n";
            }
        } else {
            return "La puerta #"+ ((peaje.puertas.indexOf(puerta))+1) + " esta cerrada"+ "\n";
        }

    }
    public String showDoors(){
        StringBuilder st = new StringBuilder();
        int count = 1;
        for (Puerta p : peaje.puertas){
            st.append("#"+ count  + " " + p.toString() + "\n");
            count++;
        }
        return st.toString();
    }
    public String interfacePeaje(double tarifaG, double tarifaP, int puertas){
        peaje = new Peaje(tarifaG, tarifaP, puertas);
        return peaje.toString();
    }
}
