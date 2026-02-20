package Logic;

public class Cadena {
    public int numero;

    public Cadena(int numero) {
        this.numero = numero;
    }
    public int descomponer(int numero){
        int sum = 0;
        for (int i =1 ; i < numero ; i++) {
            sum+=i;
        }

        if (sum == numero){
            return sum;
        } else {
            return 0;
        }
    }
}