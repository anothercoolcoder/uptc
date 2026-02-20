public class ejercicio32 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            esPrimo(i);
        }
    }
    public static void esPrimo(int n){
        boolean primo = true;

        if (n <= 1) {
            primo = false;

        } else {
            for(int i = 2; i <= n -1; i++){
                if (n%i ==0) {
                    primo = false;
                    break;
                }
            }
        }
        if (primo){
            System.out.println(n);
        }
    }
}
