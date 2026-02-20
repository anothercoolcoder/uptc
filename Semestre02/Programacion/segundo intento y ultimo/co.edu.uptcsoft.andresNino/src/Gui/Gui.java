package Gui;

import Control.Control;

import java.util.Scanner;

public class Gui {
    static Scanner scanner = new Scanner(System.in);
    static Control control = new Control();
    static String cantidadPuertas;
    public static void main(String[] args) {
        createPeaje();
        createVehiculo();
        elegirCarro();
    }
    public static void createPeaje(){
        System.out.println("Escriba el precio para vehiculos grandes");
        String tarifaG = scanner.nextLine();
        System.out.println("Escriba el precio para vehiculos pequeños");
        String tarifaP = scanner.nextLine();
        System.out.println("Escriba cantidad de puertas");
        cantidadPuertas = scanner.nextLine();
        System.out.println(control.createPeaje(tarifaG,tarifaP,cantidadPuertas));

        for (int i = 0; i < Integer.parseInt(cantidadPuertas) ; i++) {
            System.out.println("Defina el estado de la puerta (True para abierto) o (False para cerrado) ");
            String estado = scanner.nextLine();
            System.out.println("Defina el tipo de pago (False para efectivo) o  (True para tarjeta)");
            String tipoDePago = scanner.nextLine();
            System.out.println(control.createDoor(estado, tipoDePago));
        }
        System.out.println(control.showDoors());
    }
    public static void createVehiculo(){
        System.out.println("Escriba cuantos vehiculos quiere");
        String value = scanner.nextLine();
        for (int i = 0; i < Integer.parseInt(value); i++) {
            System.out.println("Digite la informacion para el vehiculo #" + (i+1));
            System.out.println("Escriba el saldo del vehiculo");
            String saldo = scanner.nextLine();
            System.out.println("Escriba el tipo de pago 'False para efectivo' o ' True para tarjeta' ");
            String tipoDePago = scanner.nextLine();
            System.out.println("Escriba el tipo de vehiculo 'Grande' o 'Pequeño' ");
            String tipoDeVehiculo = scanner.nextLine();
            System.out.println(control.createVehiculo(saldo, tipoDePago, tipoDeVehiculo));
        }

    }
    public static void mostrarCarros(){
        System.out.println(control.showCars());
    }
    public static void elegirCarro(){
        mostrarCarros();
        String value;
        do {
            System.out.println("Escriba que carro quiere mandar o escribe 0, para cancelar");
            value = scanner.nextLine();
            System.out.println(control.mandarCarro(value));

        }while (Integer.parseInt(value) != 0);

    }
}
