package Controller;

import java.util.ArrayList;

import Logic.Carrito;
import Logic.Supermercado;

public class Control {
    private Supermercado supermercado = new Supermercado();
    private Carrito carrito = new Carrito();
    ArrayList<Integer> producto = new ArrayList<>();
    ArrayList<Integer> cantidad = new ArrayList<>();
    int pSeleccion;

    public String[][] produtos() {
        return supermercado.getProductos();
    }

    public String mCarrito(String p, String c, int pSeleccion) {
        int p1 = Integer.parseInt(p);
        producto.add(p1-1);
        int c1 = Integer.parseInt(c);
        cantidad.add(c1);
        this.pSeleccion = pSeleccion;
        return carrito.mostrarCarrito(producto, cantidad, this.pSeleccion);
    }

    public String mostrarFactura() {
        return carrito.factura(producto, cantidad, pSeleccion);
    }

}
