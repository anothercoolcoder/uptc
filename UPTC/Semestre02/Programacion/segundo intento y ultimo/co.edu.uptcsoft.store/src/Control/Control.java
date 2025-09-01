package Control;

import Logic.Logic;

public class Control {
    Logic logic = new Logic();

    public String interfaceProduct(String name, String price){
        return logic.interfaceProduct(name, Integer.parseInt(price));
    }
    public String[] showStore(){
        return logic.showStore();
    }
    public String deleteProduct(String index){
        return logic.deleteProduct(Integer.parseInt(index));
    }
    public String getSize(){
        return logic.getSize();
    }
    public String[] sorting(){
        return logic.sorting();
    }

}
