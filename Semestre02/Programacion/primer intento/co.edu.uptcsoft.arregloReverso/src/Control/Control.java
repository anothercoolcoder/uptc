package Control;

import java.lang.Math;
import java.util.Arrays;

public class Control {
    private int[] arreglo;

    public String interfazArreglo(String n) { // se recibe un string
        arreglo = new int[Integer.parseInt(n)];  //se crea sobre el tamaño que ingresa el usuario
        rellenarArreglo(arreglo); // se rellena con valores aleatorios
        return Arrays.toString(arreglo); // se muestra el arreglo
    }

    public String interfazReverso() {
        reversoArreglo(arreglo);
        return Arrays.toString(arreglo);
    }

    public int valorRandom() {
        int max = 10; // maximo de valores aleatorios
        int min = 1; // minimo de valores aleatorios
        int range = max - min + 1; // rango de los valores
        int rand = (int) (Math.random() * range) + min; // numero random
        return rand;
    }

    public void rellenarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) { // a partir del tamaño del arreglo, se itera sobre cada posicion
            arreglo[i] = valorRandom(); // cada iteracion es rellenada con el valor aleatorio
        }
    }

    public void reversoArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length / 2; i++) {
            // se utiliza la mitad, para que el primero con el ultimo. El segundo con el segundo ultimo
            int t = arreglo[i];
            arreglo[i] = arreglo[arreglo.length - 1 - i];
            arreglo[arreglo.length - 1 - i] = t;
        }
        // [1,2,3,4,5,6]
        // 1 esta guardado(posicion 0)
        //
    }

}