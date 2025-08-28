package Gui;

import Control.Control;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Control control = new Control();
        System.out.println("Escriba un valor");
        String value = scanner.next();
        System.out.println(control.receiveNumber(value));
    }
}
