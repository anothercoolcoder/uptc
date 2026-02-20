package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Nomine {
    public ArrayList<Employee> employees = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("$#,###.00");

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        int count = 1;
        st.append("Empresa fantastica" + "\n");
        double finalPayment = 0;
        for (Employee e: employees){
            st.append(count).append(". ").append(e.toString()).append("\n");
            finalPayment += (e.calculateSalaryFinal());
            count++;
        }
        st.append("El pago total de la empresa, ha de ser $").append(df.format(finalPayment));
        return st.toString();
    }
}
