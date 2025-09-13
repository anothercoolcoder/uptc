package model;

public class Administrative extends Employee{
    private String independience;

    public Administrative(String name, String id, String independience) {
        super(name, id);
        this.independience = independience;
    }

    @Override
    public String toString() {
        return "Administrative{" +
                "independience='" + independience + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
