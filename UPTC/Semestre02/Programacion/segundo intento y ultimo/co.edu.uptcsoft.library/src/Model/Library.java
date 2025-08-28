package Model;

public class Library {
    public int count;
    public String[] books;

    public Library(int size) {
        books = new String[size];
        count = 0;
    }
    public void addBook(String libro){
        if (count < books.length){
            books[count] = libro;
            count++;
        }
    }
    public int getSize(){
        return books.length;
    }

    public String[] getBooks() {
        return books;
    }
}
