package control;

import logic.Logic;

public class Control {
    Logic logic = new Logic();
    public String createCar(String saldo, String tipoDePago, String vehiculo){
        return logic.createCar(Integer.parseInt(saldo), Boolean.parseBoolean(tipoDePago),vehiculo);

    }
}
