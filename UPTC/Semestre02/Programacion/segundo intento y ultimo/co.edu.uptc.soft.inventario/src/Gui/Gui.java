package Gui;

import Control.Control;

import java.util.Scanner;

public class Gui {
    public static Scanner sc = new Scanner(System.in);
    public static Control control = new Control();
    public static void main(String[] args) {
        control.defaulter();
        menu();

    }
    public static void menu(){
        String value;
        do {
            System.out.println("Bienvenido a nuestro sistema de inventario");
            System.out.println("1. Modo admin");
            System.out.println("2. Modo usuario");
            System.out.println("3. Salir");
            value = sc.nextLine();
            switch (value){
                case "1" -> adminMode();
                case "2" -> userMode();
                case "3" -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida");
            }
        }while (Integer.parseInt(value)!= 3);

    }
    public static void adminMode(){
        String value;
        do {
            System.out.println("Modo admin");
            System.out.println("1. Agregar productos");
            System.out.println("2. Quitar productos");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Salir");
            value = sc.nextLine();
            switch (value){
                case "1" -> addProduct();
                case "2" -> removeProduct();
                case "3" -> showProducts();
                default -> System.out.println("Opcion no valida");
            }
        }while (Integer.parseInt(value)!=3);

    }
    public static void userMode(){
        String value;
        do {
            System.out.println("Modo usuario");
            System.out.println("1. Pedir productos");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Salir");
            value = sc.nextLine();
            switch (value){
                case "1" -> askProduct();
                case "2" -> showProducts();
                case "3" -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida");
            }
        }while (Integer.parseInt(value)!=3);

    }
    public static void addProduct(){
        System.out.println("Id del producto");
        String id = sc.nextLine();
        System.out.println("Cantidad del producto");
        String amount = sc.nextLine();
        System.out.println("Nombre del producto");
        String name = sc.nextLine();
        System.out.println("Categoria del producto");
        String category = sc.nextLine();
        System.out.println("Toxicidad del producto");
        String toxicity = sc.nextLine();
        System.out.println(control.createProduct(id, amount,name, category, toxicity));
    }
    public static void removeProduct(){

    }
    public static void showProducts(){
        System.out.println(control.showProducts());
    }

    public static void askProduct(){

    }
}
