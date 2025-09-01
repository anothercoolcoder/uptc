package Logic;

import Model.Product;
import Model.Store;

public class Logic {
    Store store = new Store(3);
    public String interfaceProduct(String name, int price){
        Product product = new Product(name, price);
        store.addProduct(product.toString());
        return "El nombre del producto agregado es " + product.getName();
    }
    public String[] showStore(){
        return store.getProduct();
    }
    public String deleteProduct(int index){
        store.deleteProduct(index-1);
        return "El producto ha sido eliminado";
    }
    public String getSize(){
        return String.valueOf(store.getSize());
    }
    public String[] sorting(){
        for (int i = 0; i < store.getProduct().length; i++) {
            for (int j = 0; j < store.getProduct().length; j++) {
                if (store.getProduct()[i].compareTo(store.getProduct()[j]) < 0){
                    String temp = store.getProduct()[i];
                    store.getProduct()[i] = store.getProduct()[j];
                    store.getProduct()[j] = temp;
                }
            }
        }
        return store.getProduct();
    }
    public void buyProduct(String index){
        store.buyProduct(Integer.parseInt(index)-1);
    }
}
