
class arregloBinario {

    int binarySearch(int arr[], int x) // se solicita el arreglo y valor a buscar
    {
        int low = 0, high = arr.length - 1; // se define el rango sobre el que se trabaja, partiendo de 0
        // Debemos disminuir una posicion, ya que el arr.length nos da el tamaño del
        // arreglo, pero las posiciones validas son siempre una posicion menos.

        while (low <= high) // en tanto y low sea menor o igual a high, se ejecutara
        {
            int pos = low + (high - low) / 2;
            // fundamento de busqueda binaria, se suma el rango minimo a la resta del maximo
            // y el minimo, todo esto divido en 2

            if (arr[pos] == x)
                return pos;
            // el valor de la operacion anterior, sera usado de indice para realizar la
            // busqueda en el arreglo

            if (arr[pos] < x)
                low = pos + 1;
            // si el valor buscado es mayor, nos dirigimos a la derecha
            else
                high = pos - 1;
            // si el valor buscado es menor, nos dirigimos a la izquierda

        }
        return -1;
    }

    public static void main(String[] args) { // clase main, donde se ejecuta todo

        arregloBinario ob = new arregloBinario(); // creamos un nuevo objeto

        int arr[] = { 15, 2, 3, 4, 10, 40 }; // hacemos un arreglo con diferentes numeros

        int x = 15; // numero a buscar

        int result = ob.binarySearch(arr, x); // llamada a un metodo de arregloBinario

        // casos posibles
        if (result == -1) {
            System.out.println("Elemento no encontrado"); // puede fallar la busqueda por ausencia del elemento o porque
                                                          // el arreglo esta desorganizado
        } else
            System.out.println("La posicion del elemento es " + result); // al ser encontrado, muestra la posicion en
                                                                         // que fue encontrado.

    }
}