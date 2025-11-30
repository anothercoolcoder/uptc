package logic;

import model.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Logic {
    public HashMap<String, Animal> animals = new HashMap<>();
    public HashSet<String> species = new HashSet<>();
    public void defaulter(){
        addSpecies("Gato");
        addSpecies("Perro");
        Animal animal = new Animal ("Miauricio","Gato",2); animals.put(animal.name, animal);
        Animal animal1 = new Animal("Zeus","Perro",3); animals.put(animal1.name,animal1);
    }
    public String createAnimal(String name, String specie, int age){
        if (uniqueName(name)){
            return "Ya existe un animal con ese nombre";
        }
        Animal animal = new Animal(name, specie, age);
        animals.put(name,animal);

        return "Animal registrado"+ "\n" + animal;
    }
    public boolean uniqueName(String name){
        return animals.containsKey(name);
    }
    public String updateName(String OldName,String newName,int age){
        if (uniqueName(newName)){
            return "Ese nombre, ya existe";
        }
        Animal animal = animals.get(OldName);
        animal.setName(newName);
        animal.setAge(age);
        return "La informacion actualizada es " + animal;
    }
    public String showAnimals(){
        StringBuilder st = new StringBuilder();
        int i = 1;
        for (Animal a: animals.values()){
            st.append(i++).append(". ").append(a).append("\n");
        }
        return st.toString();
    }
    public String addSpecies(String specie){
        if (species.contains(specie)){
            return "Esa especie ya esta registrada";
        }
        species.add(specie);
        return "La especie " + specie + ", ha sido agregada exisotamente";
    }
    public String[] speciesArray(){
        return species.toArray(new String[0]);
    }
    public String findAnimal(String name){
        if (animals.containsKey(name)){
            return "Ese animal este registrado en nuestras bases de datos";
        }
        return "Ese animal no esta en nuestra base de datos";
    }
    public String[] keysToArray(){
        return animals.keySet().toArray(new String[0]);
    }
    public String speciesOnly(String specie){
        StringBuilder sb = new StringBuilder();

        for (Animal a: animals.values()){
            if (a.getSpecie().equalsIgnoreCase(specie)){
                sb.append(a).append("\n");
            }
        }
        return sb.length() == 0 ? "No hay animales de la especie" + specie : sb.toString();
    }
}
