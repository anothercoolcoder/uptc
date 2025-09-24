package model;

public class LibraryItem {
    String name;
    int id, year;

    public LibraryItem(String name, int id, int year) {
        this.name = name;
        this.id = id;
        this.year = year;
    }
    public String getName() {
        return name;
    }
}
