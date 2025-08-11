//Return the sum of the first n natural numbers.
//For example, if n = 5, the expected output is 15(i.e, 1 + 2 + 3 + 4 + 5 = 15).

public class forPractica {
    public static void main(String[] args) {
        int n = 5;
        int sum = 0;
        //suma final
        for (int i = 0; i <= n; i++){

            sum += i;
        }
        for (int j = 0; j <= n; j++){
            System.out.print(j);
            for(int u = 0; u<1;u++){
                if(j<n-1){
                    System.out.print(" + ");
                }
            }
        }


        System.out.println(" = " + sum);

    }
}