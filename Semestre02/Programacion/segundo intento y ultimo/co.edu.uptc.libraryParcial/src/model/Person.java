package model;

public class Person {
    private String name;
    private LibraryCard card;

    public Person(String name) {
        this.name = name;
        this.card = new LibraryCard();
    }
    public String getName() {
        return name;
    }
    public LibraryCard getCard() {
        return card;
    }
}
