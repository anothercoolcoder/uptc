package Control;

import Logic.Logic;

public class Control {
    Logic logic = new Logic();
    public String interfaceUser(String name, String work, String age, String risk, String sick){
        return logic.interfaceStudent(name, Integer.parseInt(age),work,Boolean.parseBoolean(risk),Boolean.parseBoolean(sick));
    }
}
