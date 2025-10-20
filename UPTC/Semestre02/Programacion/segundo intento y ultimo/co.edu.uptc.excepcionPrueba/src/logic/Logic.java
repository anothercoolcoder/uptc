package logic;

import model.User;

public class Logic {
    public String createUser(String name, int age, String email){
        User user = new User(name, age, email);
        return user.toString();
    }
}
