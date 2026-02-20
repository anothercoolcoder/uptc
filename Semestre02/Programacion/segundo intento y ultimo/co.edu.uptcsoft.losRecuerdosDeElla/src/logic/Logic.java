package logic;

import model.Contenedor;
import model.Product;

import java.util.ArrayList;

public class Logic {
    public ArrayList<Contenedor<Product>> inventario = new ArrayList<>();

    public String interfaceProduct(String name, Double id, Double price, int amount){
        Product product = new Product(name, id, price);
        Contenedor contenedor = new Contenedor<>(product, amount);
        inventario.add(contenedor);
        return "Producto creado";
    }
    public String updateProduct(int index, String name, Double id, Double precio, int cantidad){
        inventario.get(index).getProduct().setName(name);
        inventario.get(index).getProduct().setId(id);
        inventario.get(index).getProduct().setPrice(precio);
        inventario.get(index).setCantidad(cantidad);
        return "Los nuevos valores son "+"\n" + inventario.get(index).toString();

    }

    public String showProduct(){
        StringBuilder st = new StringBuilder();
        int count = 1;
        for (Contenedor e: inventario){
            st.append("#"+count+" "+ e);
            count++;
        }
        return st.toString();
    }
}
