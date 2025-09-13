package logic;

import model.Customer;
import model.Item;
import model.OrderDetail;

import java.util.ArrayList;

public class Logic {
    ArrayList<Customer> Customers = new ArrayList<>();
    ArrayList<Item> Items = new ArrayList<>();
    ArrayList<OrderDetail> OrderDetails = new ArrayList<>();

    public String customer(String name, String address, int id){
        if(searchCustomer(name)){
            return "El usuario ya esta registrado";
        }else{
            Customer customer = new Customer(name, address, id);
            Customers.add(customer);
            return "El valor ha sido agregado exitosamente";
        }
    }
    public String product(String name, double price, int amount, int id){
        if (searchItem(name)){
            return "El producto ya existe, cree otro";
        }else{
            Item item = new Item(name, price,amount, id);
            Items.add(item);
            return "El producto ha sido agregado exitosamente";
        }

    }
    public String bill(String name, String item, String amount){

    }
    public boolean searchCustomer(String name){
        for (Customer c: Customers) {
            if (c.getName() == name) {
                return true;
            }
        }
        return false;
    }
    public boolean searchItem(String nombre){
        for (Item i: Items) {
            if (i.getName() == nombre) {
                return true;
            }
        }
        return false;
    }
}
