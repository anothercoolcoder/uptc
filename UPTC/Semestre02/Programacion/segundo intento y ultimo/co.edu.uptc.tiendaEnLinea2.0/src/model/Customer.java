package model;

import java.util.ArrayList;

public class Customer {
    protected String name,address;
    protected int id;
    ArrayList<Order> orders = new ArrayList<>();

    public String getName() {
        return name;
    }
    public String getAddress(){return address;}

    public Customer(String name, String address, int id) {
        this.name = name;
        this.address = address;
    }

}
