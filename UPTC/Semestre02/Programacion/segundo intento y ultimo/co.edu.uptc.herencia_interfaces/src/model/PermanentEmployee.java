package model;

import java.text.DecimalFormat;

public class PermanentEmployee extends Employee{
    public double salary;

    public PermanentEmployee(String name, int id, int quantity, double lateHours, double nigthHours, double sundayHours, double salary) {
        super(name, id, quantity, lateHours, nigthHours, sundayHours);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return (salary/30)*quantity;
    }
    public double calculateHour(){
        return salary/240;
    }

    @Override
    public double calculateSalaryFinal() {
        return calculateAuxTrans() + calculateSalary() - calculateHealth() - calculateRetirement();
    }

    @Override
    public double calculateAuxTrans() {
        if (salary < salaryMin * 2){
            return auxTrans;
        }else{
            return 0;
        }
    }

    @Override
    public double calculateHealth(){
        if (calculateSalary()<salaryMin){
            return salaryMin * 0.04;
        }else {
            return calculateSalary() * 0.04;
        }
    }

    @Override
    public double calculateRetirement() {
        if (calculateSalary()<salaryMin){
            return salaryMin * 0.04;
        }else {
            return calculateSalary()*0.04;
        }
    }

    @Override
    public double calculateLateHours() {
        return (calculateHour()*1.25)*lateHours;
    }

    @Override
    public double calculateNigthHours() {
        return (calculateHour()*1.75)*nigthHours;
    }

    @Override
    public double calculateSundayHours() {
        return (calculateHour()*1.75)*sundayHours;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + " | " +
                "Auxilio de transporte: " + df.format(calculateAuxTrans()) + " \t| " +
                "Horas extras: " + df.format(calculateLateHours()) + " \t| " +
                "Horas extras nocturnas: " + df.format(calculateNigthHours()) + " \t| " +
                "Horas extras dominicales: " + df.format(calculateSundayHours()) + " \t| " +
                "Salud: -" + df.format(calculateHealth()) +" \t| "+
                "Pension: -" + df.format(calculateRetirement()) +" \t| "+
                "Salario total: " + df.format(calculateSalaryFinal());
    }

}
