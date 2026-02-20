package gui;

import control.Control;

import java.util.Scanner;

public class Gui {
    static Control control = new Control();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        createVehiculo();
    }

    public static void createVehiculo(){
        System.out.println("Escriba cuantos vehiculos quiere");
        String value = scanner.nextLine();
        for (int i = 0; i < Integer.parseInt(value); i++) {
            System.out.println("Escriba el saldo del vehiculo");
            String saldo = scanner.nextLine();
            System.out.println("Escriba el tipo de pago 'False para efectivo' o ' True para tarjeta' ");
            String tipoDePago = scanner.nextLine();
            System.out.println("Escriba el tipo de vehiculo 'Grande' o 'Pequeño' ");
            String tipoDeVehiculo = scanner.nextLine();
            System.out.println(control.createCar(saldo, tipoDePago, tipoDeVehiculo));
        }

    }
}
