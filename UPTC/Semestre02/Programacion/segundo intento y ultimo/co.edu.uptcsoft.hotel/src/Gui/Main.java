package Gui;

import Control.Control;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Control control = new Control();
        // se pregunta por valores
        System.out.println("Bienvenido, ingrese cuantas habitaciones tiene el hotel");
        String value = scanner.nextLine();
        control.interfaceHotel(value);
        // acomodamos a los clientes
        for (int i = 0; i < Integer.parseInt(value) ; i++) {
            System.out.println("Escriba el nombre del cliente para la habitacion #" + (i +1));
            control.interfaceCustomer(scanner.nextLine(), String.valueOf(i+1));
        }
        String[] Customers = control.showCustomer();

        for (String Customer: Customers){
            System.out.println(Customer);
        }
    }
}
