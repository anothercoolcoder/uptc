package logic;

public class Capibara extends Mammal implements Accion, Accion3{
    public Capibara(String name, String food, byte age) {
        super(name, food, age);
    }

    @Override
    public void nadar() {
    }

    @Override
    public void roer() {

    }

    @Override
    public String sonido() {
        return "chillido";
    }
}
