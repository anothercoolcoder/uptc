package model;

import java.util.ArrayList;

public class Nomine {
    public ArrayList<Employee> employees = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        int count = 1;
        st.append("Empresa fantastica" + "\n");
        double finalPayment = 0;
        for (Employee e: employees){
            st.append(count +". " + e.toString() + "\n");
            finalPayment += (e.calculateSalaryFinal());
            count++;
        }
        st.append("El pago total de la empresa, ha de ser $" + String.format("%.2f", finalPayment));
        return st.toString();
    }
}
