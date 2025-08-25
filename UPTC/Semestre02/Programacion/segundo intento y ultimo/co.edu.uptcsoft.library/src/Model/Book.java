package Model;

public class Book {
    public String title, author;
    public int year;

    @Override
    public String toString() {
        return
                "Titulo: " + title + '\'' +
                "Autor: ='" + author + '\'' +
                "Fecha de publicacion: " + year;
    }
}
