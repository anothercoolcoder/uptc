package logic;

import model.*;

public class Logic {
    Library library = new Library();
    public String createPerson(String name){
        Person person = new Person(name);
        library.persons.add(person);
        return "Ha sido agregado un nuevo usuario";
    }
    public String createMagazine(String name, int id, int year){
        Magazine magazine = new Magazine(name, id, year);
        library.catalog.add(magazine);
        return "Ha sido agregada una nueva revista";
    }
    public String createBook(String name, int id, int year){
        Book book = new Book(name, id, year);
        library.catalog.add(book);
        return "Ha sido agregado un nuevo libro";
    }
    public String borrow(String name, String title){
        int indexUser = searchUser(name);
        int indexItem = searchItem(title);
        if (indexItem == -1) return "Objeto no encontrado";
        if (indexUser == -1) return "Usuario no encontrado";

        LibraryItem libraryItem = library.catalog.get(indexItem);
        Person person = library.persons.get(indexUser);
        if (libraryItem instanceof Borrowable borrowable){
            return borrowable.borrowItem(person);
        }else {
            return "Este item no se puede prestar";
        }
    }
    public void defaulter(){
        Person person = new Person("Andres");
        library.persons.add(person);

        Magazine magazine = new Magazine("revista1", 1, 2005);
        Magazine magazine1 = new Magazine("revista1", 2, 2000);
        Book book = new Book("libro1",3 , 2012);
        Book book1 = new Book("libro2", 4, 2021);

        library.catalog.add(book);
        library.catalog.add(book1);
        library.catalog.add(magazine);
        library.catalog.add(magazine1);
    }
    public String showBooks(){
        return library.showBook();
    }
    public String showLibrary(){
        return library.toString();
    }
    public int searchItem(String name){
        for (int i = 0; i < library.catalog.size(); i++) {
            if (library.catalog.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
    public int searchUser(String name){
        for (int i = 0; i < library.persons.size(); i++) {
            if (library.persons.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
}
