package logic;

public abstract class Mammal extends Animal {
    protected byte  gestation;

    public Mammal(String name, String food, byte age) {
        super(name, food, age);
    }

    @Override
    public abstract String sonido();

    public byte getGestation() {
        return gestation;
    }

    public void setGestation(byte gestation) {
        this.gestation = gestation;
    }

    @Override
    public String   toString() {
        return "Mammal{" +
                "age=" + age +
                ", food='" + food + '\'' +
                ", name='" + name + '\'' +
                ", gestation=" + gestation +
                '}';
    }
}
