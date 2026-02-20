package logic;

import model.Voter;

import java.util.HashSet;

public class Logic {
    HashSet<Voter> votantes = new HashSet<>();
    public String createPerson(String id, String name) {
        Voter temp = new Voter(name, id);
        if (votantes.contains(temp)){
            return "Identificacion ya existente";
        }
        votantes.add(temp);
        return "Votante registrado exitosamente";
    }

}
