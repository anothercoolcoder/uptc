import java.util.Scanner;

public class ejercicio16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingresa el primer número:");
        int num1 = scanner.nextInt();
        
        System.out.println("Ingresa el segundo número:");
        int num2 = scanner.nextInt();
        
        System.out.println("Ingresa el tercer número:");
        int num3 = scanner.nextInt();
        
        int temp;
        
        if (num1 < num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
        
        if (num1 < num3) {
            temp = num1;
            num1 = num3;
            num3 = temp;
        }
        
        if (num2 < num3) {
            temp = num2;
            num2 = num3;
            num3 = temp;
        }
        
        System.out.println("Números ordenados de mayor a menor:");
        System.out.println(num1 + " " + num2 + " " + num3);
        
        scanner.close();
    }
}
