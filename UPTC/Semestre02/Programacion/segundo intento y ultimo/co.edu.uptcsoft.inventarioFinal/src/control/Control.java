package control;

import logic.Logic;

public class Control {
    Logic logic = new Logic();
    public void defaulter(){
        logic.defaulter();
    }
    public String createProduct(String amount, String name, String category){
        return logic.createProduct(Integer.parseInt(amount), name, category);
    }
    public String deleteProduct(String id){
        return logic.deleteProduct(id);
    }
    public String showProducts(){
        return logic.showProducts();
    }
    public String[] Ids(){
        return logic.productsId();
    }
    public String updateProduct(String id, String amount, String name, String category){
        return logic.updateProduct(id, Integer.parseInt(amount),name, category);
    }
}
