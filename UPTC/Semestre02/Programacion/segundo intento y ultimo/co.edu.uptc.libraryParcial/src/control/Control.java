package control;

import logic.Logic;

public class Control {
    Logic logic = new Logic();
    public void defaulter(){
        logic.defaulter();
    }
    public String createPerson(String name){
        return logic.createPerson(name);
    }
    public String createBook(String name, String id, String year){
        return logic.createBook(name, Integer.parseInt(id),Integer.parseInt(year));
    }
    public String createMagazine(String name, String id, String year){
        return logic.createMagazine(name, Integer.parseInt(id),Integer.parseInt(year));
    }
    public String showLibrary(){
        return logic.showLibrary();
    }
    public String showBooks(){
        return logic.showBooks();
    }
    public String borrow(String name, String tittle){
        return logic.borrow(name, tittle);
    }
}
