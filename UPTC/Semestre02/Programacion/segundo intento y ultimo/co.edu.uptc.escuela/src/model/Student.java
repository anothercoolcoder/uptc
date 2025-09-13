package model;

public class Student extends Person{
    protected String code;

    public Student(String name, String id, String code) {
        super(name, id);
        this.code = code;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + " " + name + " " + id + " ";
    }
}
