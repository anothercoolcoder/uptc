package logic;

public abstract class Animal {
    protected String name, food;

    public Animal(String name, String food, byte age) {
        this.name = name;
        this.food = food;
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public abstract String sonido();

    protected byte age;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", food='" + food + '\'' +
                ", age=" + age +
                '}';
    }
}

