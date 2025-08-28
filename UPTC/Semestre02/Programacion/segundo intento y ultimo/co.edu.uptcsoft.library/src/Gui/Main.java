package Gui;

import java.util.Scanner;
import Control.Control;
public class Main {

    public static void main(String[] args) {
        System.out.println("¿Cuantos libros tendra la biblioteca?");
        Scanner scanner = new Scanner(System.in);
        Control control = new Control();

        String value = scanner.nextLine();
        System.out.println("El tamaño de libreria es de " + control.interfaceLibrary(value)+ " libros.");

        for (int i = 0; i < Integer.parseInt(value) ; i++) {
            System.out.println("Escribe el nombre del libro");
            String name = scanner.nextLine();
            System.out.println("Escribe el nombre del autor");
            String author = scanner.nextLine();
            System.out.println("Escribe el año de publicacion");
            String year = scanner.nextLine();
            control.interfaceBook(name, author, year);
        }
        String[] books = control.showBook();

        for (String book : books){
            System.out.println(book);
        }

    }
}
