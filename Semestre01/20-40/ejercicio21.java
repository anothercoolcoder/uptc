import java.util.Scanner;
public class ejercicio21 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numero;
            
            do {
                System.out.println("Ingresa un numero: ");
                numero = scanner.nextInt();
                if (numero != 7) {
                    System.out.println("Numero ingresado: "+ numero);
                }
                
            } while (numero != 7);
            System.out.println("Has ingresado el numero 7. Fin del proceso");
        }
    }
}
