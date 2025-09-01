package Model;

public class User {
    int age;
    String work, name ,state;
    boolean risk, comorbilidades;

    public User(int age, String work, String name, boolean risk, boolean comorbilidades) {
        this.age = age;
        this.work = work;
        this.name = name;
        this.risk = risk;
        this.comorbilidades = comorbilidades;
    }

    public int getAge() {
        return age;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isRisk() {
        return risk;
    }

    public boolean isComorbilidades() {
        return comorbilidades;
    }

    public String getWork() {
        return work;
    }

    /*
    public class Factorial {

    public static long factorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        long result = 1;  // start with 1 (neutral element of multiplication)

        for (int i = 1; i <= n; i++) {
            result *= i;  // multiply result by each number from 1 up to n
        }

        return result;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(num + "! = " + factorialIterative(num));
        // Output: 5! = 120
    }
    }

     */

    @Override
    public String toString() {
        return "Señor/Señora: " + name + ", su estado de vacunacion es el siguiente: " + state;
    }
}
