package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    protected Date date;
    private Customer customer;
    protected String status;
    protected ArrayList<OrderDetail> orderDetails;

}
