package control;

import logic.Logic;

public class Control {
    Logic logic = new Logic();
    public String interfaceCustomer(String name, String address, String id){
        return logic.customer(name, address, Integer.parseInt(id));
    }
    public String interfaceProduct(String name, String price, String amount, String id){
        return logic.product(name, Double.parseDouble(price), Integer.parseInt(amount), Integer.parseInt(id));
    }

}
