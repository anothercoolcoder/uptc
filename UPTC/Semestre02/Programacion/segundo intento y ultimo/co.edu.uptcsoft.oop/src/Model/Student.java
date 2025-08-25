package Model;

public class Student {
    private String name, school;

    public Student(String name, String school) {
        this.name   = name;
        this.school = school;
    }
    public Student(){
        this.name   =   "Maria";
        this.school =   "Sistemas";
    }

    @Override
    public String toString() {
        return
                "Nombre: " + name + "\n" +
                "Escuela: " + school;
    }
}
