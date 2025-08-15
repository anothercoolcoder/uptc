import java.util.Scanner;
public class ejercicio30 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese un valor menor de 50");
            long num = scanner.nextLong();
            long factorial = 1;
            for (int i = 1; i <= num; i++) {
                factorial = factorial * i;
                
            }
            System.out.println("El resultado de la factorial de " + num + " es " + factorial);
        }
    }
}
