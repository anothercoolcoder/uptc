package control;

import logic.Logic;

public class Control {
    Logic logic = new Logic();
    public void defaulter(){
        logic.defaulter();
    }
    public String createAnimal(String name, String specie, String age){
        return logic.createAnimal(name, specie, Integer.parseInt(age));
    }
    public String showAnimals(){
        return logic.showAnimals();
    }
    public String addSpecie(String specie){
        return logic.addSpecies(specie);
    }
    public String[] speciesArray(){
        return logic.speciesArray();
    }
    public String findAnimal(String name){
        return logic.findAnimal(name);
    }
    public String[] animalsArray(){
        return logic.keysToArray();
    }
    public String updateAnimal(String oldName, String newName, String age){
        return logic.updateName(oldName,newName,Integer.parseInt(age));
    }
    public String uniqueSpecie(String specie){
        return logic.speciesOnly(specie);
    }
}
