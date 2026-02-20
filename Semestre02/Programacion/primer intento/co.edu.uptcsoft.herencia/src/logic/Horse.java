package logic;

public class Horse extends Mammal {
    private String breed;
    private String color;

    public Horse(String name, String food, byte age, String breed, String color) {
        super(name, food, age);
        this.breed = breed;
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", food='" + food + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}