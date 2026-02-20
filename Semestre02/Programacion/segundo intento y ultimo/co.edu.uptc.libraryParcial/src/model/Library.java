package model;

import java.util.ArrayList;

public class Library {
    public ArrayList<LibraryItem> catalog;
    public ArrayList<Person> persons;

    public Library() {
        this.catalog = new ArrayList<>();
        this.persons = new ArrayList<>();
    }
    public String showPersons(){
        StringBuilder st = new StringBuilder();
        int count = 1;
        for (Person p: persons){
            st.append(count + ". "+p.getName() + "\n");
            count++;
        }
        return st.toString();
    }
    public String showBook(){
        StringBuilder st = new StringBuilder();
        int count = 1;
        for (LibraryItem l: catalog){
            st.append(count + ". "+l.getName()+"\n");
            count++;
        }
        return st.toString();
    }
    @Override
    public String toString() {
        return "Libreria espectacular" + "\n" +
                "Personas inscritas: " + "\n"+
                showPersons() + "\n"+
                "Catalogo de libros: " + "\n"+
                showBook();
    }
}
