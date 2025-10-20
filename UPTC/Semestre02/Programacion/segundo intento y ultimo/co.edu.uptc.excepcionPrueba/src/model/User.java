package model;

public class User {
    public String name, email;
    public int age;

    public User(String name,int age, String email) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return  "Nombre: " + name + "\n"+
                "Email: '" + email + "\n" +
                "Edad: " + age;
    }
}
