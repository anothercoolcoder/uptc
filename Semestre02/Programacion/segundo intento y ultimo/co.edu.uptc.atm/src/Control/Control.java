package Control;

import Logic.Logic;

public class Control {
    Logic logic = new Logic();
    public void defaulter(){
        logic.defaulter();
    }
    public String addMoney(String amount){
        return logic.addMoney(Double.parseDouble(amount));
    }
    public String lessMoney(String amount){
        return logic.lessMoney(Double.parseDouble(amount));
    }
    public boolean isEnough(String amount){
        return logic.isEnough(Double.parseDouble(amount));
    }
}
