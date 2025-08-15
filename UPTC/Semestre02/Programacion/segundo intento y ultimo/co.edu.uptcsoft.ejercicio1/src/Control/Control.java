package Control;

import Logic.Student;

public class Control {
    public String interfaceStudent(String name, String[] grades){
        double[] doubleArray = new double[grades.length];
        for (int i = 0; i < grades.length; i++) {
            doubleArray[i] = Double.parseDouble(grades[i]);
        }
        Student student = new Student(name, doubleArray);
        return String.valueOf(student);
    }
}
