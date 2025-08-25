package Model;

public class Library {
    public int count;
    public Book[] books;

    public Library(int size) {
        books = new Book[size];
        count = 0;
    }
    public void addBook(Book e){
        if (count < books.length){
            books[count] = e;
            count++;
        } else {
            System.out.println("La libreria esta llena");
        }
    }
    public void showBooks(){
        for (int i = 0; i < count; i++) {
            System.out.println(books[i].title +" "+ books[i].author + " ("+ books[i].year+").");
        }
    }
}
