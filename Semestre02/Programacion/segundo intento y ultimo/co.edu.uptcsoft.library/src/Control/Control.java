package Control;

import Model.Book;
import Model.Library;

public class Control {
    Library library;
    public int interfaceLibrary(String value){
        this.library = new Library(Integer.parseInt(value));
        return library.getSize();
    }
    public String interfaceBook(String title, String name, String year){
        Book book = new Book(title, name, year);
        library.addBook(book.toString());
        return "El libro " + book.getTitle() + " ha sido añadido exitosamente.";
    }

    public String[] showBook(){
        return library.getBooks();
    }
}
