package Gui;

import Control.Control;

import java.util.Scanner;

public class Gui {
    
    public Control control = new Control();
    public Scanner scanner = new Scanner(System.in);
    
    public Gui(){
        control.defaulter();
        menu();
    }

    public void menu(){
        String value;
        do {
            System.out.println("Escriba la opcion deseada");
            System.out.println("1. Sacar dinero");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Salir...");
            value = scanner.nextLine();
            switch (value){
                case "1" -> outMoney();
                case "2" -> enterMoney();
                case "3" -> System.out.println("Saliendo...");
                default -> System.out.println("Valor invalido...");
            }
        }while (!value.equalsIgnoreCase("3"));
    }
    public void enterMoney(){
        String value = null;
        try {
            System.out.println("¿Cuanto dinero va a ingresar?");
            value = scanner.nextLine();
            isNegativeNumber(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Excepcion manejada, el sistema continua");
            enterMoney();
        }
        System.out.println(control.addMoney(value));
    }

    public void outMoney(){
        String value = null;
        try {
            System.out.println("¿Cuanto dinero va a retirar?");
            value = scanner.nextLine();
            while (isEnough(value)){
                System.out.println("El valor debe ser igual o menor al total de la cuenta");
                value = scanner.nextLine();

            }
            isNegativeNumber(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Excepcion manejada, el sistema continua");
            enterMoney();
        }
        System.out.println(control.lessMoney(value));

    }
    public  boolean isEnough(String amount){
        return control.isEnough(amount);
    }
    public void isNegativeNumber(String number){
        if (Double.parseDouble(number)<=0){
            throw new IllegalArgumentException("El monto ha de ser positivo");
        }
    }

}
