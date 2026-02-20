package Logic;

import Model.User;

public class Logic {
    Database database = new Database();
    public void defaulter(){
        User defaulter = new User("Andres", 9000);
        database.users.add(defaulter);
    }
    public String addUser(String name, double amount){
        User user = new User(name,amount);
        database.users.add(user);
        return user.name + " ha sido agregado exitosamente";
    }
    public String lessMoney(double amount){
        User user = database.users.get(0);
        user.lessAmount(amount);
        return "Se resto a tu cuenta $" + amount + ", su nuevo saldo es: $" + user.getAmount();
    }
    public String addMoney(double amount){
        User user = database.users.get(0);
        user.addAmount(amount);
        return "Se sumo a tu cuenta $" + amount + ", su nuevo saldo es: $" + user.getAmount();
    }
    void isMore(double amount, User user){
        if (user.getAmount()<amount){
            throw new IllegalArgumentException("El monto ha de ser positivo");
        }
    }
    public boolean isEnough(double amount){
        User user =  database.users.get(0);
        return user.getAmount() > amount;
    }

}
