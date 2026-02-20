package gui;

import control.Control;

import javax.swing.*;
import java.util.Scanner;

public class Gui {
    static Scanner sc = new Scanner(System.in);
    static Control control = new Control();
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int selection;
        Object[] options = {"Añadir un producto", "Ingresar Dinero","Salir..."};
        do {
            selection = JOptionPane.showOptionDialog(
                    null,
                    "Por favor, selecciona una opcion",
                    "Selecciona una opcion",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            switch (selection){
                case 0 -> addProduct();
                case 1 -> enterMoney();
                case 2 -> System.out.println("Saliendo...");
            }
        }while (selection != 2 && selection != JOptionPane.CLOSED_OPTION);
        String value;
        do {
            System.out.println("¿Que desea hacer hoy?");
            System.out.println("1. Agregar un producto");
            System.out.println("2. Actualizar existencia");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Realizar una venta");
            System.out.println("5. Salir");
            value = sc.nextLine();
            switch (Integer.parseInt(value)){
                case 1: addProduct(); break;
                case 2: updateProduct(); break;
                case 3: showInventory(); break;
                case 4: purchase(); break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Valor invalido");
            }
        }while (Integer.parseInt(value)!=5);
    }
    public static void addProduct(){
        System.out.println("Ingrese el nombre del producto");
        String name = sc.nextLine();
        System.out.println("Ingrese el identificador unico del producto");
        String id = sc.nextLine();
        String price;
        String amount;
        do {
            System.out.println("Ingrese el precio del producto");
            price = sc.nextLine();
            System.out.println("Ingrese la cantidad del producto");
            amount = sc.nextLine();
        }while (Integer.parseInt(price) <= 0 && Integer.parseInt(amount)<=0);
        System.out.println(control.interfaceProduct(name, id, price, amount));
    }
    public static void updateProduct(){
        showInventory();
        System.out.println("Escriba el producto que quiere modificar");
        String index = sc.nextLine();
        System.out.println("Ingrese el nombre del producto");
        String name = sc.nextLine();
        System.out.println("Ingrese el identificador unico del producto");
        String id = sc.nextLine();
        String price;
        String amount;
        do {
            System.out.println("Ingrese el precio del producto");
            price = sc.nextLine();
            System.out.println("Ingrese la cantidad del producto");
            amount = sc.nextLine();
        }while (Integer.parseInt(price) <= 0 && Integer.parseInt(amount)<=0);
        System.out.println(control.updateProduct(index, name, id, price, amount));

    }
    public static void showInventory(){
        System.out.println(control.showProduct());
    }
    public static void purchase(){}
}
