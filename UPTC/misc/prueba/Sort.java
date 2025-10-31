import java.util.*;

public class Sort {
    public static void main(String[] args) {
        String[] names = {"Juan","Alberto", "Cris"};
        int[] ages = {3,2,1};
        Arrays.sort(names);
        Arrays.sort(ages);
        for(String name : names){
            System.out.println(name);
        }
        for(int age : ages){
            System.out.println(age);
        }
    }
}
