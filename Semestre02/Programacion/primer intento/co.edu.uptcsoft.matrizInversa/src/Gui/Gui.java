package Gui;

import Control.Control;
import java.util.Scanner;

public class Gui {
    public void vista() {
        Control control = new Control();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de filas de la matriz:");
        String filas = scanner.nextLine();

        System.out.println("Ingrese la cantidad de columnas de la matriz:");
        String columnas = scanner.nextLine();

        System.out.println("Matriz original:");
        System.out.println(control.interfazMatriz(filas, columnas));

        System.out.println("Matriz al reverso:");
        System.out.println(control.interfazReverso());
    }
}
