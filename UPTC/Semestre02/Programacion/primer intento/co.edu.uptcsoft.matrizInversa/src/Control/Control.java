package Control;

import java.util.Arrays;

public class Control {
    private int[][] matriz;

    public String interfazMatriz(String filasStr, String columnasStr) {
        int filas = Integer.parseInt(filasStr); // filas
        int columnas = Integer.parseInt(columnasStr); // columnas de la matriz
        matriz = new int[filas][columnas]; // nueva matriz
        rellenarMatriz(matriz); // se utiliza la funcion de aleatorio
        return matrizAString(matriz);
    }

    public String interfazReverso() {
        reversoMatriz(matriz);
        return matrizAString(matriz);
    }

    public int valorRandom() {
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        return (int) (Math.random() * (range)) + min;
    }

    public void rellenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) { // se utilizan dos ciclos porque son dos arreglos a recorrer
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = valorRandom();
            }
        }
    }

    public void reversoMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas / 2; i++) {
            int[] temp = matriz[i];
            matriz[i] = matriz[filas - 1 - i];
            matriz[filas - 1 - i] = temp;
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas / 2; j++) {
                int temp = matriz[i][j];
                matriz[i][j] = matriz[i][columnas - 1 - j];
                matriz[i][columnas - 1 - j] = temp;
            }
        }
    }

    public String matrizAString(int[][] matriz) {
        StringBuilder sb = new StringBuilder();
        for (int[] fila : matriz) {
            sb.append(Arrays.toString(fila)).append("\n");
        }
        return sb.toString();
    }
}
