package control;

import logic.*;

public class ControllerAnimal {

    public String interfazDog(String nom, String com, String eda, String raz) {
        byte edad = Byte.parseByte(eda);
        Dog dog = new Dog(nom, com, edad, raz);
        dog.mensaje();
        return String.valueOf(dog);
    }

    public String interfazCat(String nom, String com, String eda, String ped) {
        byte edad = Byte.parseByte(eda);
        Cat cat = new Cat(nom, com, edad, ped);
        return String.valueOf(cat);
    }

    public String interfazHorse(String nom, String com, String eda, String raz, String col) {
        byte edad = Byte.parseByte(eda);
        Horse horse = new Horse(nom, com, edad, raz, col);
        return String.valueOf(horse);
    }

}