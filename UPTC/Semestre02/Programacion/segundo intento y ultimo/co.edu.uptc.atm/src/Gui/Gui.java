package Gui;

import Control.Control;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Scanner;

public class Gui {

    public Control control = new Control();
    public Scanner scanner = new Scanner(System.in);
    
    public Gui(){
        control.defaulter();
        menu();
    }

    public void menu(){
        int selection;
        Object[] options = {"Sacar Dinero", "Ingresar Dinero","Salir..."};
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
                case 1 -> outMoney();
                case 2 -> enterMoney();
                case 3 -> System.out.println("Saliendo...");
            }
        }while (selection != 2 && selection != JOptionPane.CLOSED_OPTION);
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
