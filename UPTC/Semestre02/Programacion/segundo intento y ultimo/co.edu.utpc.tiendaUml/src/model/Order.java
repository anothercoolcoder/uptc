package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private Date date;
    private Customer customer;
    private ArrayList<OrderDetail> orderDetails;
    private String status;

    public String getStatus() {
        return status;
    }
    public void ingOrden(OrderDetail ord){
        orderDetails.add(ord);

    }
    public double calSubTotal(){
        for (int i = 0; i <orderDetails.size() ; i++) {
            double subtotal += orderDetails.indexOf(orderDetails);
        }
        return 0.0;
    }
}
