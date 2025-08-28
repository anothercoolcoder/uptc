package Model;

public class Videogame {
    public String name, genre;
    public double price;

    public Videogame() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return String.valueOf(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Nombre: " + name + "\n" +
                "Genero: " + genre + "\n" +
                "Precio: " + price;
    }
}
