package Gui;

import Control.Control;
import Model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Control control = new Control();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un nombre");
        String name = sc.nextLine();
        System.out.println("Escribe tu escuela");
        String school = sc.nextLine();
        System.out.println(control.getStudent(name, school));
    }
}
