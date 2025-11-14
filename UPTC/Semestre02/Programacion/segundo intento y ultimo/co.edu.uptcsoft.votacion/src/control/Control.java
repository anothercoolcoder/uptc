package control;

import logic.Logic;

public class Control {
    Logic logic = new Logic();

    public String createVoter(String id, String name){
        return logic.createPerson(id,name);
    }
}
