package logic;

import model.Product;

import java.util.ArrayList;

public class Logic {
    ArrayList<Product> products = new ArrayList<>();
    public void defaulter(){
        Product paperSheets = new Product(idCreator(),100,"Hojas de papel","A4");
        Product pens = new Product(idCreator(),10,"Lapiceros","Kilometrico");
        products.add(paperSheets);
        products.add(pens);
    }
    public String createProduct(int amount, String name, String category){
        Product product = new Product(idCreator(), amount, name, category);
        products.add(product);
        return "El producto ha sido creado exitosamente";
    }
    public String idCreator(){
        int value;
        do {
            value = (int)(Math.random()*(50-10+1))+10;
            return String.valueOf(value);
        }while (DuplicateId(String.valueOf(value)));
    }
    public String showProducts(){
        if (products.isEmpty()){
            return "No hay productos registrados actualmente";
        }
        StringBuilder st = new StringBuilder(" Lista de productos: \n");
        int index = 1;
        for (Product p: products){
            st.append(index++).append(". ").append(p.toString()).append("\n");
        }
        return st.toString();
    }
    public boolean DuplicateId(String id){
        try{
            for (Product p: products){
                if (p.getId().equalsIgnoreCase(id)){
                    throw new LogicExceptions.DuplicateId(id);
                }
            }
        }catch (LogicExceptions.DuplicateId e){
            return true;
        }
        return false;
    }
    public String deleteProduct(String id){
        Product product = searchProduct(id);
        products.remove(product);
        return "Ha sido removido exitosamente";
    }
    public Product searchProduct(String id){
        for (Product p: products){
            if (p.getId().equalsIgnoreCase(id)){
                return p;
            }
        }
        return null;
    }
    public String[] productsId(){
        String[] Ids = new String[products.size()];
        for (int i= 0; i<products.size();i++){
            Ids[i] = products.get(i).getId();
        }
        return Ids;
    }

}
