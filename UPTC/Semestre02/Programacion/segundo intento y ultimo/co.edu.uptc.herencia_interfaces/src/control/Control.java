package control;

import logic.Logic;

public class Control {
    Logic logic = new Logic();
    public String createPermanentEmployee(String name, String id, String baseSalary, String workedDays, String lateHours, String nigthHours, String sundayHours) {
        return logic.createPermanentEmployee(name, Integer.parseInt(id),Double.parseDouble(baseSalary), Integer.parseInt(workedDays), Double.parseDouble(lateHours),Double.parseDouble(nigthHours),Double.parseDouble(sundayHours));
    }
    public String createHourlyEmployee(String name, String id, String tarifeHour, String workedHours, String lateHours, String nigthHours, String sundayHours) {
        return logic.createHourlyEmployee(name, Integer.parseInt(id),Double.parseDouble(tarifeHour), Integer.parseInt(workedHours),Double.parseDouble(lateHours),Double.parseDouble(nigthHours),Double.parseDouble(sundayHours));
    }
    public String showNomine(){
        return logic.showNomine();
    }
    public void defaulter (){
        logic.defaultEmployees();
    }
}
