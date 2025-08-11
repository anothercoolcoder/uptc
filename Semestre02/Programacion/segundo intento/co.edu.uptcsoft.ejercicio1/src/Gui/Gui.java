package Gui;

import Control.Control;

import java.util.Scanner;

public class Gui {
    private Scanner sc = new Scanner(System.in);
    Control control = new Control();
    public void menu(){
        System.out.println("Bienvenido");

        System.out.println("Ingresa un nombre para el estudiante");
        String name = sc.nextLine();

        System.out.println("Ingresa el valor para la primera nota");
        String grade1 = sc.nextLine();

        System.out.println("Ingresa el valor para la segunda nota");
        String grade2 = sc.nextLine();

        System.out.println("Ingresa el valor para la tercera nota");
        String grade3 = sc.nextLine();

        System.out.println(control.interfaceStudent(name, grade1, grade2, grade3));
    }
}
