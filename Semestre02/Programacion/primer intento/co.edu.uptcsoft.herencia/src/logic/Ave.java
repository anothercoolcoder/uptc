package logic;

public class Ave extends Oviparo implements Accion, Accion2{
    public Ave(String name, String food, byte age) {
        super(name, food, age);
    }

    @Override
    public void nadar() {

    }


    @Override
    public void volar() {

    }

    @Override
    public String sonido() {
        return "";
    }
}
