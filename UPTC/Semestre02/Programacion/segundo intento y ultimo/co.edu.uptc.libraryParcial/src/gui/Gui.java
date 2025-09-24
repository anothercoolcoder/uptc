package gui;

import control.Control;

import java.util.Scanner;

public class Gui {
    static Control control = new Control();
    static Scanner sc = new Scanner (System.in);
    public static void main(String[] args) {
        control.defaulter();
        menu();
    }
    public static void menu(){
        String value;
        do {
            System.out.println("Bienvenido");
            System.out.println("1. Mostrar libreria");
            System.out.println("2. Añadir persona");
            System.out.println("3. Añadir item");
            System.out.println("4. Sacar libro / devolver");
            System.out.println("5. Salir");
            value = sc.nextLine();
            switch (value){
                case "1" -> showLibrary();
                case "2" -> createPerson();
                case "3" -> createItem();
                case "4" -> borrowItem();
                case "5" -> System.out.println("Saliendo...");
                default -> System.out.println("Valor invalido");
            }

        }while (!value.equals("5"));

    }
    public static void showLibrary(){
        System.out.println(control.showLibrary());
    }
    public static void createPerson(){
        System.out.println("Escriba su nombre");
        String name = sc.nextLine();
        System.out.println(control.createPerson(name));
    }
    public static void createItem(){
        String value;
        do {
            System.out.println("1. Libro");
            System.out.println("2. Revista");
            System.out.println("3. Salir");
            value = sc.nextLine();
            switch (value){
                case "1" -> createBook();
                case "2" -> createMagazine();
                case "3" -> System.out.println("Saliendo...");
                default -> System.out.println("Valor invalido");
            }

        }while (!value.equals("3"));
    }
    public static void createBook(){
        System.out.println("Escriba el nombre del libro");
        String name = sc.nextLine();
        System.out.println("Escriba el id del libro");
        String id = sc.nextLine();
        System.out.println("Escriba el año de publicacion");
        String year = sc.nextLine();
        System.out.println(control.createBook(name, id, year));
    }
    public static void createMagazine(){
        System.out.println("Escriba el nombre del libro");
        String name = sc.nextLine();
        System.out.println("Escriba el id del libro");
        String id = sc.nextLine();
        System.out.println("Escriba el año de publicacion");
        String year = sc.nextLine();
        System.out.println(control.createMagazine(name, id, year));
    }
    public static void borrowItem(){
        showBooks();
        System.out.println("Escriba su nombre");
        String name = sc.nextLine();
        System.out.println("Escriba el nombre del articulo deseado");
        String title = sc.nextLine();
        System.out.println(control.borrow(name, title));
    }
    public static void showBooks(){
        System.out.println(control.showBooks());
    }
}
