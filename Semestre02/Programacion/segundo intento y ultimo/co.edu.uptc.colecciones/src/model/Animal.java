package model;

public class Animal {
    public String name, specie;
    public int age;

    public Animal(String name, String specie, int age) {
        this.name = name;
        this.specie = specie;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        // si apuntan a la misma direccion
        if (obj == null || getClass() != obj.getClass()) return false;
        // si no son la misma clase
        Animal other = (Animal) obj;
        // comparar el nombre
        return name.equals(other.name);
    }

    @Override
    public String toString() {
        return  "Nombre: " + name + '\t' + " | " +
                "Especie: " + specie + '\t' + " | " +
                "Edad: " + age;
    }
}
