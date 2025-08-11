import java.util.Scanner;

public class arreglo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10]; 

        for (int i = 0; i < 10; i++) {
            System.out.println("Write one number for: (" + (i + 1) + "/10): ");
            int table = sc.nextInt();
            numbers[i] = Math.abs(table);
        }

        System.out.println("\n Multiplication tables \n");

        for (int row = 0; row < 2; row++) {
            for (int multiplier = 1; multiplier <= 10; multiplier++) {
                for (int column = 0; column < 5; column++) {
                    int indice = row * 5 + column; 
                    int number = numbers[indice]; 
                    if (number == 0) {
                        System.out.print("Any number * 0 = 0\t\t"); 
                    } else {
                        System.out.print(number + " * " + multiplier + " = " + (number * multiplier) + "\t");
                    }
                }
                System.out.println(); 
            }
            System.out.println(); 
        }

        System.out.println("End of program.");
        sc.close();
    }
}
