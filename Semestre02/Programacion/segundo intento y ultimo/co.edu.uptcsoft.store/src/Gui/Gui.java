package Gui;

import Control.Control;

import java.util.Scanner;

public class Gui {
    static Scanner sc = new Scanner(System.in);
    static Control control = new Control();
    public static void main(String[] args) {
        principal();
    }
    public static void principal(){
        System.out.println("Bievenido");
        System.out.println("¿Eres cliente o administrador?");
        System.out.println("1. Cliente");
        System.out.println("2. Administrador");
        System.out.println("3. Salir");
        switch (Integer.parseInt(sc.nextLine())){
            case 1:
                customerMode();
                break;
            case 2:
                adminMode();
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("El valor es invalido");
                break;
        }
    }
    //customer methods
    public static void customerMode(){
        String value;
        do {
            System.out.println("Seleccione la opcion deseada");
            System.out.println("1. Mirar los productos");
            System.out.println("2. Comprar producto");
            System.out.println("3. Acomodar alfabeticamente");
            System.out.println("4. Regresar");
            System.out.println("5. Salir");
            System.out.println();
            value = sc.nextLine();
            switch (Integer.parseInt(value)){
                case 1:
                    showProducts();
                    break;
                case 2:
                    buyProduct();
                    break;
                case 3:
                    sortAlphabetic();
                    break;
                case 4:
                    System.out.println("Regresando");
                    principal();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("El valor no es valido");
                    break;
            }
        }while (Integer.parseInt(value) != 5);

    }
    public static void buyProduct(){
        System.out.println("Digite el numero deseado");
        showProducts();
        control.buyProduct(sc.nextLine());
    }
    public static void sortAlphabetic(){
        String[] products = control.sorting();
        int i = 0;

        for (String product : products){
            System.out.println("#" + (i + 1) + " " + product);
        }
    }
    //admin methods
    public static void adminMode(){
        securitySystem();
        String value;
        do {
            System.out.println("Seleccione la opcion deseada");
            System.out.println("1. Crear nuevo producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Borrar producto");
            System.out.println("4. Regresar");
            System.out.println("5. Salir");
            value = sc.nextLine();
            switch (Integer.parseInt(value)){
                case 1:
                    createProduct();
                    break;
                case 2:
                    showProducts();
                    break;
                case 3:
                    deleteProducts();
                    break;
                case 4:
                    principal();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Valor invalido");
                    break;
            }
        } while (Integer.parseInt(value) != 5);

    }
    public static void createProduct() {

        System.out.println("Escriba el nombre de un producto");
        String name = sc.nextLine();
        System.out.println("Escriba el precio de un producto");
        String price = sc.nextLine();

        System.out.println(control.interfaceProduct(name, price));
    }
    public static void showProducts(){
        String[] store = control.showStore();
        int i = 0;
        for (String product : store){
            System.out.println("#" + (i+1) +" "+ product);
            i++;
        }
    }
    public static void deleteProducts(){
        System.out.println("Selecciona el numero de producto a borrar");
        showProducts();

        String value = sc.nextLine();
        if (Integer.parseInt(value)>Integer.parseInt(control.getSize()) || Integer.parseInt(value)<Integer.parseInt(control.getSize())){
            System.out.println("El valor esta fuera del rango");
        } else {
            System.out.println(control.deleteProduct(value));

        }
    }
    public static void securitySystem(){
        String password;
        do {
            System.out.println("Escribe la contraseña");
            password = sc.nextLine();
        } while (!password.equals("abc"));
    }
}
