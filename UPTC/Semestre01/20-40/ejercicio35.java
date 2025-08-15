import java.util.Scanner;

public class ejercicio35 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese un número menor a 100: ");
            int numero = sc.nextInt();
            
            if (numero >= 100) {
                System.out.println("El número debe ser menor a 100.");
                return;
            }
            
            System.out.print("Número ingresado por el usuario: " + numero + "\nSu descomposición es: 1");
            
            for (int i = 2; i <= numero; i++) {
                while (numero % i == 0) {
                    System.out.print("x" + i);
                    numero /= i;
                }
            }
        }
    }
}
