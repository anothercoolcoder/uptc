package logic;

import model.Employee;
import model.HourlyEmployee;
import model.Nomine;
import model.PermanentEmployee;

public class Logic {
    Nomine nomine = new Nomine();

    public String createPermanentEmployee(String name, int id,double salary, int workedDays, Double lateHours, Double nigthHours, Double sundayHours){
        PermanentEmployee permanentEmployee = new PermanentEmployee(name, id,workedDays,lateHours,nigthHours,sundayHours,salary);
        nomine.employees.add(permanentEmployee);
        return "Ha sido agregado exitosamente, un nuevo empleado ";
    }
    public String createHourlyEmployee(String name, int id, double tarifedHour, int workedHours, double lateHours, double nigthHours, double sundayHours){
        HourlyEmployee hourlyEmployee = new HourlyEmployee(name,id, workedHours,lateHours,nigthHours,sundayHours,tarifedHour);
        nomine.employees.add(hourlyEmployee);
        return "Ha sido agregado exitosamente, un nuevo empleado por horas";
    }
    public String showNomine(){
        return nomine.toString();
    }
    public void defaultEmployees(){
        HourlyEmployee andres = new HourlyEmployee("Andres",1,20,2,3,4,5000);
        HourlyEmployee julian = new HourlyEmployee("Julian",2,45,4,3,6,7000);
        PermanentEmployee Andrea = new PermanentEmployee("Andrea",3,4,5,6,6,1200000);
        PermanentEmployee Jesus = new PermanentEmployee("Jesus ",4,6,7,3,2,2000000);
        nomine.employees.add(andres);
        nomine.employees.add(Jesus);
        nomine.employees.add(Andrea);
        nomine.employees.add(julian);
    }

}
