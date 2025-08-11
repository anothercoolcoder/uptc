package logic;

public class Delfin extends Mammal implements Accion{

    public Delfin(String name, String food, byte age) {
        super(name, food, age);
    }

    @Override
    public String sonido() {
        return "chillido";
    }

    @Override
    public void nadar() {

    }
}
