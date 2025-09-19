package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    protected Date orderDate;
    private Customer customer;
    protected ArrayList<OrderDetail> orderDetails;

    public Order(Customer customer) {
        this.customer = customer;
        this.orderDetails = new ArrayList<>();
        this.orderDate = new Date();
    }
    public double getTotal(){
        double total = 0;
        for (OrderDetail od : orderDetails){
            total += od.getSubtotal();
        }
        return total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    public void addOrderDetail(OrderDetail orderDetail){
        orderDetails.add(orderDetail);
    }

    public void addItem(Item item, int quantity){
        orderDetails.add(new OrderDetail(item, quantity));
    }

}
