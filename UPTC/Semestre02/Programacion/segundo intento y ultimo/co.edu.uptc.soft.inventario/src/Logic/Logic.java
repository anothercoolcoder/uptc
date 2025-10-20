package Logic;

import Model.Producto;

import java.util.ArrayList;

public class Logic {
    ArrayList<Producto> productos = new ArrayList<>();
    public void defaulter(){
        Producto marcador = new Producto(1,1,"Marcador", "Oficina", false);
        Producto tinta = new Producto(2,5,"Tinta", "Oficina", false);
        Producto cloro = new Producto(3,6,"Cloro", "Aseo", true);
        Producto mouse = new Producto(4,7,"Mouse", "Oficina", false);
        productos.add(marcador);
        productos.add(tinta);
        productos.add(cloro);
        productos.add(mouse);
    }
    public String showProducts(){
        StringBuilder st = new StringBuilder();
        int i = 1;
        for (Producto p: productos){
            st.append(i + "# Id: " + p.getId() + "\t");
            st.append("Nombre: " + p.getNombre() +"\t");
            st.append("Cantidad: " + p.getCantidad() + "\t");
            st.append("Categoria: " + p.getCategoria() + "\t");
            st.append("Toxicidad: " + p.getToxicidad() + "\t");
            st.append("\n");
            i++;
        }
        return st.toString();
    }
    public String createProduct(int id, int amount, String name, String category, boolean toxicity){
        Producto producto = new Producto(id, amount, name, category, toxicity);
        productos.add(producto);
        return "Producto creado exitosamente";
    }
}
