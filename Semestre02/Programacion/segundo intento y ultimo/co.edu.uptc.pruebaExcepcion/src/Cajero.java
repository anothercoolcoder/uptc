import java.util.InputMismatchException;
import java.util.Scanner;

public class Cajero {
    public static void main(String[] args) {
        double saldo = 500000;
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Cajero Automático ===");
        System.out.println("Saldo disponible: $" + saldo);
        double retiro = 0;
        try{
            System.out.print("Ingrese el monto a retirar: ");
            retiro = sc.nextDouble();
            if (retiro>saldo){
                throw new IllegalArgumentException("El retiro es mayor al saldo");
            } else if (retiro <0) {
                throw new RetiroMayor("Es un valor negativo");
            } else{
                double nuevoSaldo = saldo - retiro;
                System.out.println("Retiro exitoso. Nuevo saldo: $" + nuevoSaldo);
            }
        } catch (IllegalArgumentException | RetiroMayor e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Debemos trabajar sobre valores numericos");
        }
    }
}