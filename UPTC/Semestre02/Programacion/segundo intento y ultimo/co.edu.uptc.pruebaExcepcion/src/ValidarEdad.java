import java.util.Scanner;

public class ValidarEdad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese su edad: ");
            int edad = sc.nextInt();

            if (edad < 0) {
                throw new IllegalArgumentException("La edad no puede ser negativa.");
            }

            if (edad < 18) {
                throw new Exception("Debe ser mayor de edad para continuar.");
            }

            System.out.println("Bienvenido al sistema.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}