package Model;

public class Book {
    public String title, author, year;

    public Book(String title, String author, String year) {

        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return  "Titulo: " + title + ", " +
                "Autor: " + author + ", " +
                "Publicacion: " + year;
    }
}
