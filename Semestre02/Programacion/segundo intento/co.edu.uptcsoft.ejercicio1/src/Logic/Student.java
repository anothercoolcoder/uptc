package Logic;

public class Student {
    private String name;
    private double grade1;
    private double grade2;
    private double grade3;
    private double average;

    public Student(String name, double grade1, double grade2, double grade3) {
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.average = (grade1 + grade2 + grade3)/3;
    }

    @Override
    public String toString() {
        return "Estudiante " + "\n"+
                "Nombre: " + name   + "\n"  +
                "Nota 1: " + grade1 + "\n"  +
                "Nota 2: " + grade2 + "\n"  +
                "Nota 3: " + grade3 + "\n"  +
                "Promedio: " + average;
    }
}

