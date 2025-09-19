package model;

public abstract class Person {
    protected String name, id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public abstract int calculateSalary();

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
