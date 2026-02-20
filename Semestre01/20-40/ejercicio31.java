import java.util.Scanner;
public class ejercicio31 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese un numero primo");
            int primo = scanner.nextInt();
            esPrimo(primo);
        }
    }
    public static void esPrimo(int n){
        boolean primo = true;

        if (n <= 1) {
            primo = false;

        } else {
            for(int i = 2; i <= n -1; i++){
                if (n%i ==0) {
                    primo = false;
                    break;
                }
            }
        }
        if (primo){
            System.out.println("Es un numero primo");
        } else {
            System.out.println("No es un numero primo");
        }
    }
}
