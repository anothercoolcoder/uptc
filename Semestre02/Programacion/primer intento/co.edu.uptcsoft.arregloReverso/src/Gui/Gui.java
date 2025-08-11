package Gui;

import Control.Control;
import java.util.Scanner;

public class Gui {
    public void vista() {
        Control control = new Control();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escriba el tamaño del arreglo:");
        String size = scanner.nextLine(); // unica interaccion

        System.out.println("Arreglo original:");
        System.out.println(control.interfazArreglo(size));

        System.out.println("Arreglo al reverso:");
        System.out.println(control.interfazReverso());
    }
}
