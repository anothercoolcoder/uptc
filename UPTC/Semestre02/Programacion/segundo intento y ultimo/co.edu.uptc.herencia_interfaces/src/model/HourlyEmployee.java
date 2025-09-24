package model;

public class HourlyEmployee extends Employee{
    public double tarifeHour;

    public HourlyEmployee(String name, int id, int quantity, double lateHours, double nigthHours, double sundayHours, double tarifeHour) {
        super(name, id, quantity, lateHours, nigthHours, sundayHours);
        this.tarifeHour = tarifeHour;
    }

    @Override
    public double calculateSalary() {
        return (tarifeHour * quantity);
    }

    @Override
    public double calculateSalaryFinal() {
        return calculateSalary() + calculateAuxTrans() - calculateHealth() - calculateRetirement();
    }

    @Override
    public double calculateAuxTrans() {
        if (calculateSalary()<salaryMin*2){
            return (auxTrans/240) * quantity;
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
            return calculateSalary()*0.12;
        }
    }

    @Override
    public double calculateLateHours() {
        return (tarifeHour*1.25)*lateHours;
    }

    @Override
    public double calculateNigthHours() {
        return (tarifeHour*1.75)*nigthHours;
    }

    @Override
    public double calculateSundayHours() {
        return (tarifeHour*1.75)*sundayHours;
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
