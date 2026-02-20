package Model;

public class Customer {
    public String name,room;

    public Customer(String name, String room) {
        this.name = name;
        this.room = room;
    }

    @Override
    public String toString() {
        return  "Nombre: " + name + ", " +
                "Habitacion: " + room;
    }
}
