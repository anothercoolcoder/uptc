package Model;

public class Store {
    String[] products;
    int count;

    public Store(int size) {
        products = new String[size];
    }

    public void addProduct(String product){
        if (count <= product.length()){
            products[count] = product;
            count++;
        }
    }
    public void deleteProduct(int index){
        products[index] = null;
    }
    public void buyProduct(int index){
        products[index] = "Comprado";
    }
    public String[] getProduct() {
        return products;
    }
    public int getSize(){
        return products.length;
    }
}
