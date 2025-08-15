import java.util.Scanner;

public class ejercicio17 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingresa el primer número:");
            int num1 = scanner.nextInt();
            
            if (num1 > 7){
                System.out.println("Excelente");
            }
            else
                if (num1 < 7 && num1 > 5) {
                    System.out.println("Bueno");
                }
                else
                    if (num1 < 5 && num1 > 3) {
                        System.out.println("Regular");
                    }
                    else
                        System.out.println("Malo");
        }
    }
}
