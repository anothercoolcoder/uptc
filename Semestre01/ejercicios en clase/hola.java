public class hola {
    public static void main(String[] args) {
        
	System.out.println(factorial(5));

	}
	public static int factorial(int numero) {
        int numeroFactorial = 0;
	for (int i = 1; i <= numero; i ++){
		numeroFactorial = i * numeroFactorial;
	}
	return numeroFactorial;
    }
}