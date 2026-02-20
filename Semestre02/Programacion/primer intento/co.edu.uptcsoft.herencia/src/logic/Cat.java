package logic;

import java.sql.SQLOutput;

public class Cat extends Mammal {
    private String pedigree;

    public Cat(String name, String food, byte age, String pedigree) {
        super(name, food, age);
        this.pedigree = pedigree;
    }

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "pedigree='" + pedigree + '\'' +
                ", gestation=" + gestation +
                ", name='" + name + '\'' +
                ", food='" + food + '\'' +
                ", age=" + age +
                '}';
    }
}
