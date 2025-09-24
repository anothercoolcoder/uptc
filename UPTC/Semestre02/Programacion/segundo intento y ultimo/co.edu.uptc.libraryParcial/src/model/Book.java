package model;

public class Book extends LibraryItem implements Borrowable{
    private Person borrowedBy;

    public Book(String name, int id, int year) {
        super(name, id, year);
    }
    @Override
    public String borrowItem(Person p) {
        if (borrowedBy == null){
            borrowedBy = p;
            p.getCard().libraryItems.add(this);
            return getName() + " fue tomado por " + p.getName();
        }else{
            return getName() + " ya fue tomado.";
        }
    }
    @Override
    public String returnItem() {
        if (borrowedBy != null){
            borrowedBy.getCard().libraryItems.remove(this);
            String msg =  getName() + " retornado por " + borrowedBy.getName();
            borrowedBy = null;
            return msg;
        }else {
            return getName() + " no ha sido tomado.";
        }
    }
    @Override
    public String getName() {
        return super.getName();
    }
}
