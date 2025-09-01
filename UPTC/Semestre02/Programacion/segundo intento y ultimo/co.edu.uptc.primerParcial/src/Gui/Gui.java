package Gui;

import Control.Control;

import java.util.Scanner;

public class Gui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Control control = new Control();

        System.out.println("Escriba su nombre");
        String name = scanner.nextLine();

        System.out.println("Escriba su edad en numeros enteros");
        String edad = scanner.nextLine();

        System.out.println("¿Tienes varias enfermedades al mismo tiempo? (True para verdadero) (False para falso)");
        String comorbilidades = scanner.nextLine();

        System.out.println("Escriba su trabajo, las opciones son: ");
        System.out.println("-> Primera linea");
        System.out.println("-> Segunda linea");
        System.out.println("-> Tercera linea");
        System.out.println("-> Secundaria");
        System.out.println("-> Cuidador");
        String trabajo = scanner.nextLine();

        System.out.println("¿Es usted comunidad en riesgo? (True para verdadero) (False para falso)");
        String comunidadEnRiesgo = scanner.nextLine();

        System.out.println(control.interfaceUser(name,trabajo,edad,comunidadEnRiesgo,comorbilidades));

    }
}
