public class FibonacciIterative {

    public static void main(String[] args) {
        int n = 5; // Number of terms to generate
        System.out.println("odio la ingenieria");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciIterative(i) + " ");
        }
    }

    public static int fibonacciIterative(int n) {
        int fib = 1;
        int prevFib = 0;
        for (int i = 2; i <= n; i++) {
            int temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
        }
        return fib;
    }
}