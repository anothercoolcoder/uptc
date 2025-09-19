package model;

public abstract class Employee implements Payable{
    protected String name;
    protected int id,quantity;
    double lateHours, nigthHours, sundayHours;

    public Employee(String name, int id, int quantity, double lateHours, double nigthHours, double sundayHours) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.lateHours = lateHours;
        this.nigthHours = nigthHours;
        this.sundayHours = sundayHours;
    }
}
