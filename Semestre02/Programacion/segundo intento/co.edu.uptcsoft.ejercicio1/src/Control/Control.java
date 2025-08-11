package Control;

import Logic.Student;

public class Control {
    public String interfaceStudent(String name, String grade1, String grade2, String grade3){
        double grade1_d = Double.parseDouble(grade1);
        double grade2_d = Double.parseDouble(grade2);
        double grade3_d = Double.parseDouble(grade3);
        Student student = new Student(name, grade1_d, grade2_d, grade3_d);
        return String.valueOf(student);
    }
}
