package model;

public class Passenger {
    private String fullName;
    private String document;
    private int age;
    private String email;

    public Passenger(String fullName, String document, int age, String email) {
        this.fullName = fullName;
        this.document = document;
        this.age = age;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDocument() {
        return document;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Passenger: " + fullName +
                " | Doc: " + document +
                " | Age: " + age +
                " | Email: " + email;
    }
}
