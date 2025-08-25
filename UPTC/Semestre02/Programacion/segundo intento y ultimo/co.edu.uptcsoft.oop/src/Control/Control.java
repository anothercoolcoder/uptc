package Control;

import Model.Student;

public class Control {
    public Student getStudent(String name, String school){
        return new Student(name, school);
    }
}
