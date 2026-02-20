import java.util.Scanner;

public class Main {
    static int cups = 0;
    static double valueLemonada = 4.5;
    static double total =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        System.out.println("Escriba cuantos vasos de limonada vendiste");
        cups = sc.nextInt();
        obj.calculateBrute();
    }
    public void calculateBrute(){
        total = cups * valueLemonada;
        System.out.println("Si vendiste " + cups + " vasos de limonada, deberias tener: $"+ total + " en ingreso neto.");
    }
    public void calculateNet(){

    }

}