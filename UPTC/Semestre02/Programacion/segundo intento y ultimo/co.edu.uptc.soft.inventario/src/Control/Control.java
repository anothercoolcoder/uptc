package Control;

import Logic.Logic;

public class Control {
    Logic logic = new Logic();
    public void defaulter(){
        logic.defaulter();
    }
    public String showProducts(){
        return logic.showProducts();
    }
    public String createProduct(String id, String amount, String name, String category, String toxicity){
        return logic.createProduct(Integer.parseInt(id), Integer.parseInt(amount),name, category, Boolean.parseBoolean(toxicity));
    }
}
