package Control;

import Logic.Sorting;
import Model.Product;
import Model.Store;

public class Control {
    Store store = new Store(3);

    public String interfaceProduct(String name, String price){
        Product product = new Product(name, Integer.parseInt(price));
        store.addProduct(product.toString());
        return "El nombre del producto agregado es " + product.getName();
    }
    public String[] showStore(){
        return store.getProduct();
    }
    public String deleteProduct(String index){
        store.deleteProduct(Integer.parseInt(index)-1);
        return "El producto ha sido eliminado";
    }
    public String getSize(){
        return String.valueOf(store.getSize());
    }
    public String[] sorting(){
        Sorting sorting = new Sorting();
        return sorting.sorting(showStore());
    }
    public void buyProduct(String index){
        store.buyProduct(Integer.parseInt(index)-1);
    }
}
