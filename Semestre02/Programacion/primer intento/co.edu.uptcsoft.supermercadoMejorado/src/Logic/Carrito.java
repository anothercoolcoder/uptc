package Logic;

import java.util.ArrayList;

public class Carrito {
    //productos a pagar
    private final Supermercado supermercado = new Supermercado();

    //muestra los productos seleccionados
    public String mostrarCarrito(ArrayList<Integer> p, ArrayList<Integer> c, int productosSeleccionados) {
        String[][] productos = supermercado.getProductos();

        StringBuilder carrito1 = new StringBuilder();
        for (int i = 0; i < productosSeleccionados; i++) {
            carrito1.append((i + 1)).append(". ").append("Producto: ").append(productos[p.get(i)][0])
                    .append(" El precio es: $ ").append(productos[p.get(i)][1])
                    .append(" La cantidad es: ").append(c.get(i)).append("\n");
        }
        return carrito1.toString();
    }

    //muestra la factura y su total
    public String factura(ArrayList<Integer> p, ArrayList<Integer> c, int productosSeleccionados) {
        String[][] productos = supermercado.getProductos();

        StringBuilder factura = new StringBuilder();
        double total = 0.0;

        for (int i = 0; i < productosSeleccionados; i++) {
            String nombreProducto = productos[p.get(i)][0];
            double precio = Double.parseDouble(productos[p.get(i)][1]);
            int cantidad = c.get(i);
            double subtotal = precio * cantidad;

            factura.append((i + 1)).append(". ").append("Producto ").append(nombreProducto)
                    .append(" - Precio unitario: $ ").append(precio)
                    .append(" - Cantidad: ").append(cantidad)
                    .append(" - Subtotal: $ ").append(subtotal).append("\n");

            total += subtotal;
        }

        factura.append("\nTotal a pagar: $ ").append(total);

        return factura.toString();
    }
}