package model;

public class Employee extends Person{
    public Employee(String name, String id) {
        super(name, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
