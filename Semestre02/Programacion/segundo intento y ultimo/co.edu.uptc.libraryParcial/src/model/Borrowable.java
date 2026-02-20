package model;

public interface Borrowable {
    String borrowItem(Person p);
    String returnItem();
}
