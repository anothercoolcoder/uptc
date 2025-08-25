package Gui;

import Model.Book;
import Model.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(3);

        Book book1 = new Book();
        book1.author = "Gabriel Garcia Marquez";
        book1.year = 1967;
        book1.title = "Cien años de soledad";

        Book book2 = new Book();
        book2.title = "Kafka on Shore";
        book2.year = 2005;
        book2.author = "Haruki Murakami";

        Book book3 = new Book();
        book3.title = "Los hermanos Karamazov";
        book3.year = 1880;
        book3.author = "Fiodor Dostoevsky";

        // ¿tendria que implementar un control que realice un intermediario?
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.showBooks();
    }
}
