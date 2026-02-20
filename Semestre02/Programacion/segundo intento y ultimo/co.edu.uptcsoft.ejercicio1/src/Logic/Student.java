package Logic;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Student {
    private String name;
    private double[] grades, allGrades;
    private double average;

    public Student(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
        this.average = getAverage();
    }
    public double getAverage() {
        for (double grades: grades){
            average +=grades;
        }
        average /= grades.length;
        return average;
    }

    DecimalFormat df = new DecimalFormat("#.##");
    @Override
    public String toString() {
        return  "Estudiante: "   + "\n"                     +
                "Nombre: "       + name                     + "\n"  +
                "Notas: "        + Arrays.toString(grades)  + "\n"  +
                "Promedio: "     + df.format(average);
    }
}

