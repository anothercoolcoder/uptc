import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("filas");
        int filas = sc.nextInt();
        System.out.println("columnas");
        int columnas = sc.nextInt();

        int[][] ints = new int[filas][columnas];

        for(int i = 0 ; i < ints.length; i ++){
            for (int j = 0; j< ints.length; j++){
                System.out.println("Dime un valor para la pos: " + i + j);
                ints[i][j]= sc.nextInt();
            }
        }
        for(int i = 0 ; i < ints.length; i ++){
            for (int j = 0; j< ints.length; j++){
                System.out.print(ints[i][j]);
            }
        }System.out.print("");


    }
}