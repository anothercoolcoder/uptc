package gui;

import control.Control;
import java.util.Scanner;

public class Gui {
    static Scanner sc = new Scanner(System.in);
    static Control control = new Control();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        String value;
        do {
            System.out.println("Escriba la opcion deseada");
            System.out.println("1. Nuevo cliente");
            System.out.println("2. Nuevo producto");
            System.out.println("3. Comprar producto"); // Cambiado a compra simple
            System.out.println("4. Mostrar productos");
            System.out.println("5. Salir");
            value = sc.nextLine();

            switch (value) {
                case "1" -> user();
                case "2" -> product();
                case "3" -> purchaseProduct();
                case "4" -> showProducts();
                case "5" -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida");
            }
        } while (!value.equals("5"));
    }

    public static void user() {
        System.out.println("Escriba su nombre: ");
        String name = sc.nextLine();
        System.out.println("Escriba su direccion: ");
        String address = sc.nextLine();
        System.out.println("Escriba su id: ");
        String id = sc.nextLine();

        System.out.println(control.interfaceCustomer(name, address, id));
    }

    public static void product() {
        System.out.println("Escriba el nombre del producto: ");
        String name = sc.nextLine();
        System.out.println("Escriba el precio del producto: ");
        String price = sc.nextLine();
        System.out.println("Escriba la cantidad de este producto: ");
        String amount = sc.nextLine();
        System.out.println("Escriba el id: ");
        String id = sc.nextLine();

        System.out.println(control.interfaceProduct(name, price, amount, id));
    }

    public static void purchaseProduct() {
        System.out.println("Escriba el nombre del cliente: ");
        String nameCustomer = sc.nextLine();
        System.out.println("Escriba el nombre del producto: ");
        String productName = sc.nextLine();
        System.out.println("Escriba la cantidad: ");
        String amount = sc.nextLine();

        // Llama al método que procesa un solo producto
        System.out.println(control.processSinglePurchase(nameCustomer, productName, amount));
    }

    public static void showProducts() {
        System.out.println(control.showProducts());
    }
}