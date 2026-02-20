import java.util.Scanner;
public class factorial{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			System.out.println("ingrese la base: ");
			int base = sc.nextInt();
			System.out.println("ingrese la exponente: ");
			int exponente = sc.nextInt();
			System.out.println("El resultado es " +Math.pow(base, exponente));
		} 
    }
}
