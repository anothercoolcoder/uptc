package Test;

import java.util.Scanner;

public class Main {
    static int value = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        System.out.println("Digite el valor");
        value = sc.nextInt();
        System.out.println(obj.oddPair());
        obj.multiplicationTable();
    }
    public void multiplicationTable (){
        for (int i = 1; i <= 10  ; i++) {
            System.out.println(value + " * " + i + " = " + (value*i));
        }
    }
    public String oddPair(){
        if ((value % 2) == 0){
            return "El numero " + value + ", es par.";
        } else {
            return "El numero " + value + ", es impar.";
        }
    }
}