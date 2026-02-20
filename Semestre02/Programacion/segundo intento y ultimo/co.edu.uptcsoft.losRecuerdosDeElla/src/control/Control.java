package control;
import logic.Logic;

public class Control {
    Logic logic = new Logic();
    public String interfaceProduct(String name, String id, String price, String amount){
        return logic.interfaceProduct(name, Double.parseDouble(id), Double.parseDouble(price),Integer.parseInt(amount));
    }
    public String updateProduct(String index, String name, String id, String price, String amount){
        return logic.updateProduct(Integer.parseInt(index)-1,name, Double.parseDouble(id),Double.parseDouble(price),Integer.parseInt(amount));
    }

    public String showProduct(){
        return logic.showProduct();
    }
}
