package model;

import java.util.ArrayList;

public class Professor extends Employee {
    protected ArrayList<Subject> subjects = new ArrayList<>();
    public Professor(String name, String id) {
        super(name, id);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "subjects=" + subjects +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
