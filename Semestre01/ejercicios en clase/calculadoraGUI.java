
import java.util.Scanner;

public class calculadoraGUI {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {


			System.out.println("Hello welcome, to the most amazing calculator.");
            System.out.println(" ");
            System.out.println("Las operaciones disponibles son");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Potencia");
            System.out.println(" ");
            System.out.println("Seleciona alguna opcion");

            int valor = sc.nextInt();

            System.out.println("Escriba un numero (en caso de seleccionar potencia, esta sera su base)");
			Double num1 = sc.nextDouble();
			System.out.println("Escriba un numero");
			Double num2 = sc.nextDouble();
            
            switch (valor) {
                case 1 -> System.out.println("Su resultado es " + suma(num1, num2) );

                case 2 -> System.out.println("Su resultado es " + resta(num1, num2) );

                case 3 -> System.out.println("Su resultado es " + Multiplicacion(num1, num2) );

                case 4 -> System.out.println("Su resultado es " + Division(num1, num2) );

                case 5 -> System.out.println("Su resultado es " + potencia(num1, num2));

                default -> {
                    System.out.println("Resultado invalido");
                }
            }
		}
    }
    public static double suma(double n1, double n2) {
        double resultado = n1 + n2;
        return resultado;
    }
    public static double resta(double n1, double n2) {
        double resultado = n1 - n2;
        return resultado;
    }
    public static double Multiplicacion(double n1, double n2) {
        double resultado = n1 * n2;
        return resultado;
    }
    public static double Division(double n1, double n2) {
        double resultado = n1 / n2;
        return resultado;
    }
    public static double potencia (double n1, double n2) {
        double resultado = Math.pow(n1, n2);
        return resultado;
    }
    
}
