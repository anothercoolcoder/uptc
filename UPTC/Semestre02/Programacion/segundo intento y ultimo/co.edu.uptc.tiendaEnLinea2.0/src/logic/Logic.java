package logic;

import model.Customer;
import model.Item;
import model.Order;
import model.OrderDetail;

import java.util.ArrayList;
import java.util.Date;

public class Logic {
    Storage storage = new Storage();
    ArrayList<Order> Orders = new ArrayList<>();

    public String customer(String name, String address, int id){
        if(searchCustomer(name) != -1){
            return "El usuario ya esta registrado, intente con otro";
        }else{
            Customer customer = new Customer(name, address, id);
            storage.Customers.add(customer);
            return "El usuario ha sido agregado exitosamente";
        }
    }
    public String product(String name, double price, int amount, int id){
        if (searchItem(name) != -1){
            return "El producto ya existe previamente";
        }else{
            Item item1 = new Item(name, price,amount, id);
            storage.Items.add(item1);
            return "El producto ha sido agregado exitosamente";
        }
    }
    public String bill(String customerName, String productName, int quantity) {
        int customerIndex = searchCustomer(customerName);
        int productIndex = searchItem(productName);

        if (customerIndex == -1) return "Cliente no encontrado";
        if (productIndex == -1) return "Producto no encontrado";

        Item product = storage.Items.get(productIndex);
        if (product.getStock() < quantity) {
            return "Stock insuficiente. Disponible: " + product.getStock();
        }

        // Actualizar stock
        product.setStock(product.getStock() - quantity);

        // Crear orden con un solo producto
        Order order = new Order(storage.Customers.get(customerIndex));
        OrderDetail orderDetail = new OrderDetail(product, quantity);
        order.addOrderDetail(orderDetail);
        Orders.add(order);

        return generarFactura(order); // Genera factura de un solo producto
    }
    public String addProductOrder(int orderId, String productName, int amount){
        if (orderId <= 0 || orderId>=Orders.size()){
            return "Id invalido";
        }

        int productIndex = searchItem(productName);
        if (productIndex == -1) {
            return "Producto no encontrado";
        }

        Item product = storage.Items.get(productIndex);
        if (product.getStock() < amount) {
            return "Stock insuficiente. Disponible: " + product.getStock();
        }
        product.setStock(product.getStock()-amount);
        Order order = Orders.get(orderId);
        OrderDetail orderDetail = new OrderDetail(product, amount);
        order.addOrderDetail(orderDetail);
        return "Producto agregado: " + productName + " x" + amount;

    }
    public String finishOrder(int orderId){
        if (orderId <= 0 || orderId>=Orders.size()){
            return "Id invalido";
        }
        return generarFactura(Orders.get(orderId));
    }
    public String showProducts(){
        StringBuilder st = new StringBuilder();
        int count = 1;
        for (Item i: storage.Items ){
            st.append("#"+ count+ " producto"+"\n" + i.toString() + "\n");
            count++;
        }
        return st.toString();
    }
    public String generarFactura(Order order){
        StringBuilder sb = new StringBuilder();
        sb.append("Factura");
        sb.append("Cliente: ").append(order.getCustomer().getName()).append("\n");
        sb.append("Direccion: ").append(order.getCustomer().getAddress()).append("\n");
        sb.append("Fecha: ").append(new Date()).append("\n\n");
        sb.append("Items:\n");

        for (OrderDetail od: order.getOrderDetails()){
            sb .append("- ").append(od.getItem().getName())
                    .append(" x").append(od.getQuantity()).append(": $").append(od.getSubtotal()).append("\n");
        }
        sb.append("\nTotal: $").append(order.getTotal());
        return sb.toString();
    }
    public int searchCustomer(String name){
        for (int i = 0; i < storage.Customers.size(); i++){
            if (storage.Customers.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
    public int searchItem(String nombre){
        for (int i = 0; i < storage.Items.size(); i++) {
            if (storage.Items.get(i).getName().equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return -1;
    }
}