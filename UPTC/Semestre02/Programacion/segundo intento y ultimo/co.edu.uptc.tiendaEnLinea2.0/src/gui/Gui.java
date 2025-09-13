package gui;

import control.Control;

import java.util.Scanner;

public class Gui {
    static Scanner sc = new Scanner(System.in);
    static Control control = new Control();
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        user();
        String value;
        do {
            System.out.println("Escriba la opcion deseada");
            System.out.println("1. Nuevo cliente");
            System.out.println("2. Nuevo producto");
            System.out.println("3. Comprar producto");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Salir");
            value = sc.nextLine();
            switch (Integer.parseInt(value)){
                case 1: user(); break;
                case 2: product(); break;

//                case 3: purchaseProduct(); break;
//                case 4: showProducts(); break;
            }
        }while (Integer.parseInt(value) != 5);

        product();

    }
    public static void user(){

        System.out.println("Escriba su nombre: " );
        String name = sc.nextLine();
        System.out.println("Escriba su direccion: ");
        String address = sc.nextLine();
        System.out.println("Escriba su id");
        String id = sc.nextLine();
        System.out.println(control.interfaceCustomer(name, address, id));
    }
    public static void product(){
        System.out.println("Escriba el nombre del producto");
        String name = sc.nextLine();
        System.out.println("Escriba el precio del producto");
        String price = sc.nextLine();
        System.out.println("Escriba la cantidad de este producto");
        String amount = sc.nextLine();
        System.out.println("Escriba el id");
        String id = sc.nextLine();
        System.out.println(control.interfaceProduct(name, price, amount, id));
    }
}
