package gui;

import control.Control;

import javax.swing.*;

public class Gui {
    Control control = new Control();
    public Gui(){
        control.defaulter();
        menu();
    }
    public void menu(){
        JOptionPane.showMessageDialog(null, "Bienvenido a nuestro refugio");
        String selection;
        do {
            String[] options = {"Registrar","Actualizar","Mostrar animales","Añadir especie", "Buscar Animal","Especie unica","Salir"};
            selection = (String) JOptionPane.showInputDialog(
                    null,
                    "Elija una opcion",
                    "Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            switch (selection){
                case "Registrar" -> register();
                case "Actualizar" -> update();
                case "Mostrar animales" -> showAnimals();
                case "Añadir especie" -> addSpecie();
                case "Especie unica" -> uniqueSpecie();
                case "Buscar Animal" -> searchAnimal();
                case "Salir" -> JOptionPane.showMessageDialog(null, "Saliendo...");
                default -> JOptionPane.showMessageDialog(null, "Valor invalido");
            }
        }while (selection != null && !selection.equals("Salir"));
    }
    public void register(){
        String name = JOptionPane.showInputDialog(null, "Ingrese el nombre");
        String specie = specieForm();
        String age = ageForm();
        JOptionPane.showMessageDialog(null,control.createAnimal(name, specie, age));
    }
    public void update(){
        String[] animals = control.animalsArray();
        String oldName = (String) JOptionPane.showInputDialog(null, "Elija el animal deseado","Menu",JOptionPane.QUESTION_MESSAGE,null,animals,animals[0]);
        String newName = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre");
        String age = ageForm();
        JOptionPane.showMessageDialog(null,control.updateAnimal(oldName,newName,age));
    }
    public void showAnimals(){
        JOptionPane.showMessageDialog(null, control.showAnimals());
    }
    public String specieForm(){
        String[] species = control.speciesArray();
        return (String) JOptionPane.showInputDialog(null, "Elija la especie", "Menu",JOptionPane.QUESTION_MESSAGE,null,species,species[0]);
    }
    public String ageForm(){
        String age;
        do {
            age = JOptionPane.showInputDialog(null, "Ingrese la edad del animal (mayor a 0 y menor de 20)");
            if (Integer.parseInt(age)>0){
                return age;
            } else if (Integer.parseInt(age)>120) {
                JOptionPane.showMessageDialog(null,"La edad debe ser menor a 120 años");
            }

        }while (Integer.parseInt(age)<0);
        return "";
    }
    public void addSpecie(){
        JOptionPane.showMessageDialog(
                null,
                control.addSpecie(JOptionPane.showInputDialog(null,"Ingresa el nombre de la especie")));
    }
    public void uniqueSpecie(){
        JOptionPane.showMessageDialog(null, control.uniqueSpecie(specieForm()));
    }
    public void searchAnimal(){
        JOptionPane.showMessageDialog(null, control.findAnimal(JOptionPane.showInputDialog(null,"Ingrese el nombre del animal a buscar")));
    }
}
