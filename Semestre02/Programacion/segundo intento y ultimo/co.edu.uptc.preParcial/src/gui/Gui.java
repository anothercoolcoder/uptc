package gui;

import control.Control;

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
        while (true){
            System.out.println("Bienvenido a la tienda");
            System.out.println("Ingrese la opcion deseada");
            System.out.println("1. Registrar nuevo dispositivo");
            System.out.println("2. Listar dispositivos");
            System.out.println("3. Buscar dispositivo por codigo");
            System.out.println("4. Eliminar dispositivo");
            System.out.println("5. Salir");
            value = sc.nextLine();
            switch (value){
                case "1" -> newDevice();
                case "2" -> showDevices();
                case "3" -> searchDevice();
                case "4" -> deleteDevice();
                case "5" -> System.out.println("Saliendo..."); // no esta saliendo
                default -> System.out.println("Opcion no valida");

            }
        }
    }
    public static void newDevice(){
        System.out.println("Bienvenido al registro de dispositivos");
        System.out.println("Ingrese la opcion deseada");
        System.out.println("1. Tablet");
        System.out.println("2. Computadora");
        System.out.println("3. Celular");
        System.out.println("4. Salir");
        String value = sc.nextLine();
        switch (value){
            case "1" -> newTablet();
            case "2" -> newComputer();
            case "3" -> newPhone();
            case "4" -> {
                System.out.println("Saliendo...");
                return;
            }
            default -> System.out.println("Opcion no valida");
        }
    }
    public static void newTablet(){
        System.out.println("Ingrese el codigo de la tablet");
        String id = sc.nextLine();
        System.out.println("Ingrese la marca de la tablet");
        String brand = sc.nextLine();
        System.out.println("Ingrese el precio de la tablet");
        String price = sc.nextLine();
        System.out.println("Ingrese el tamaño en pulgadas de la tablet");
        String screenSize = sc.nextLine();
        System.out.println("Ingrese la disponibilidad de tarjeta sim (True o False)");
        String sim = sc.nextLine();
        System.out.println("Ingrese la disponibilidad de lapiz optico ");
        String pencil = sc.nextLine();
        System.out.println(control.Tablet(id, brand, price,screenSize, sim, pencil));
    }
    public static void newComputer(){
        System.out.println("Ingrese el codigo de computadora");
        String id = sc.nextLine();
        System.out.println("Ingrese la marca de computadora");
        String brand = sc.nextLine();
        System.out.println("Ingrese el precio de la computadora");
        String price = sc.nextLine();
        System.out.println("Ingrese el sistema operativo de la computadora");
        String os = sc.nextLine();
        System.out.println("Ingrese la cantidad de ram");
        String ram = sc.nextLine();
        System.out.println("Ingrese la disponibilidad de gpu");
        String gpu = sc.nextLine();
        System.out.println(control.Computer(id, brand, price,os, ram, gpu));
    }
    public static void newPhone(){
        System.out.println("Ingrese el codigo del telefono");
        String id = sc.nextLine();
        System.out.println("Ingrese la marca del telefono");
        String brand = sc.nextLine();
        System.out.println("Ingrese el precio del telefono");
        String price = sc.nextLine();
        System.out.println("Ingrese el numero de telefono");
        String number = sc.nextLine();
        System.out.println("Ingrese el sistema operativo");
        String os = sc.nextLine();
        System.out.println("Ingrese numero de camaras");
        String cameras = sc.nextLine();
        System.out.println(control.Phone(id, brand, price,number, os, cameras));
    }
    public static void showDevices(){
        System.out.println(control.showDevices());
    }
    public static void searchDevice() {
        while (true){
            try{
                System.out.println("Escriba el numero del dispositivo que busca");
                String value = sc.nextLine();
                System.out.println(control.deviceCode(value));
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Intente otra vez");
            }
        }
    }
    public static void deleteDevice(){
        while (true){
            try{
                System.out.println("Escriba el numero del dispositivo que quiere borrar");
                String value = sc.nextLine();
                System.out.println(control.deletedevice(value));
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Intente otra vez");
            }
        }
    }
//try {
//        Dispositivo d = logic.buscarDispositivo("123");
//        System.out.println(d);
//    } catch (DispositivoNoEncontradoException e) {
//        System.out.println("Error: " + e.getMessage());
//    } catch (NumberFormatException e) {
//        System.out.println("Formato inválido en el número ingresado");
//    } catch (Exception e) {
//        System.out.println("Error inesperado: " + e.getMessage());
//    }

}
