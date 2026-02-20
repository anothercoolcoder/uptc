import java.util.Random;

public class MatrizPlantas {
    public static void main(String[] args) {
        int[][] matriz = new int[5][5];
        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100) + 1;
            }
        }

        System.out.println("Matriz generada:");
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }

        int sumaTotal = 0;
        int elementos = matriz.length * matriz[0].length;

        for (int[] fila : matriz) {
            for (int valor : fila) {
                sumaTotal += valor;
            }
        }

        double promedio = (double) sumaTotal / elementos;
        System.out.println("\nPromedio general: " + promedio);

        int filaMayor = 0;
        int mejorSuma = 0;

        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
            for (int valor : matriz[i]) {
                sumaFila += valor;
            }
            if (sumaFila > mejorSuma) {
                mejorSuma = sumaFila;
                filaMayor = i;
            }
        }

        System.out.println("La fila con mayor salud total es la fila: " + filaMayor);
    }
}
