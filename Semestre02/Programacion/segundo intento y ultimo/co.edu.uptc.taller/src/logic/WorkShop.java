package logic;

import java.util.ArrayList;
import model.Car;
import model.Employee;

public class WorkShop {
    private ArrayList<Car> carList;
    private ArrayList<Employee> employeeList;

    public void addCar(Car car){
        carList.add(car);
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void asignCar(Car car, Employee employee) {
        int index = employeeList.indexOf(employee);
        if(index != -1){
            employeeList.get(index).setCarsServiced(carList);
        }
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
}
