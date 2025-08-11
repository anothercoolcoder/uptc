import java.util.Scanner;
public class ejercicio33 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese un numero");
            int numero = scanner.nextInt();
            int cifra;
            int invertido = 0;

            while ( numero > 0) {
                cifra = numero % 10;
                invertido = invertido * 10 + cifra;
                numero = numero /10;
            }        
            System.out.print("Cifras: ");

            while(invertido > 0 ) {
                cifra = invertido %10;
                System.out.print(cifra);
                invertido = invertido /10;
                
                if(invertido > 0) {
                    System.out.print(", ");
                }
            }
            System.out.print("");

        }
    }
}
