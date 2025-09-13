package Control;

import Logic.Logic;

public class Control {
    Logic logic = new Logic();

    public String createVehiculo(String saldo, String tipoDePago, String tipoDeVehiculo){
        return logic.interfaceVehiculo(Integer.parseInt(saldo),Boolean.parseBoolean(tipoDePago),tipoDeVehiculo.toLowerCase());
    }
    public String createPeaje(String tarifaG, String tarifaP, String cantidadPuertas){
        return logic.interfacePeaje(Double.parseDouble(tarifaG),Double.parseDouble(tarifaP),Integer.parseInt(cantidadPuertas));
    }
    public String createDoor(String state, String tipoDePago){
        return logic.interfaceDoor(Boolean.parseBoolean(state),Boolean.parseBoolean(tipoDePago));
    }
    public String showDoors(){
        return logic.showDoors();
    }
    public String showCars(){
        return logic.vehiculosMostrar();
    }
    public String mandarCarro(String index){
        return logic.validacion(Integer.parseInt(index));
    }

}
