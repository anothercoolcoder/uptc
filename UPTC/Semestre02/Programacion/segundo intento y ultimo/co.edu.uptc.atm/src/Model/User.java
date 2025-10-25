package Model;

import java.text.DecimalFormat;

public class User {
    public String name;
    public double amount;

    public User(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
    public void addAmount(double amount){
        this.amount += amount;
    }
    public void lessAmount(double amount){
        this.amount -= amount;
    }
    public double getAmount() {
        return amount;
    }

    DecimalFormat df = new DecimalFormat("$#,###.00");

    @Override
    public String toString() {
        return  "Nombre: " + name + "\n" +
                "Monto total: " + df.format(amount);
    }
}
