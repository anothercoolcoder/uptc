package logic;

import model.Car;

public class Logic {
    public String createCar(int saldo, boolean tipoDePago,String vehiculo ){
        Car car = new Car(saldo, vehiculo,tipoDePago);
        return car.toString();
    }
}

