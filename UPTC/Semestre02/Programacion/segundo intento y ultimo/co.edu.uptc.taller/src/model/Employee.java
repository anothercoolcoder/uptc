package model;

import java.util.ArrayList;

public class Employee {
    protected String name, lastName;
    protected int idEmployee;
    protected ArrayList<Car> carsServiced;

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setCarsServiced(ArrayList<Car> carsServiced) {
        this.carsServiced = carsServiced;
    }

    public String getName(){
        return name;
    }
    public int getCarsServiced(){
        return carsServiced.size();
    }
    public void setCarsServiced(Car car){
        carsServiced.add(car);
    }
    public ArrayList<Car> showCar(){
        return carsServiced;
    }
}
