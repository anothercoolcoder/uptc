package Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el valor");
        int value = sc.nextInt();
        System.out.println(oddPair(value));
        multiplicationTable(value);
    }
    public static void multiplicationTable (int value){
        for (int i = 1; i <= 10  ; i++) {
            System.out.println(value + " * " + i + " = " + (value*i));
        }
    }
    public static String oddPair(int value){
        if ((value % 2) == 0){
            return "El numero " + value + ", es par.";
        } else {
            return "El numero " + value + ", es impar.";
        }

    }
}