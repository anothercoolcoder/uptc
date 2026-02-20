package control;

import logic.Logic;

public class Control {
    Logic logic = new Logic();
    public String createUser(String name, String age, String email){
        return logic.createUser(name, Integer.parseInt(age), email);
    }
}
