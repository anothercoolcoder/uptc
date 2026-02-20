package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    protected Date date;
    private Customer customer;
    protected String status;
    protected ArrayList<OrderDetail> orderDetails;

    public void CalcSubTotal(){}
    public void CalcTax(){}
    public void CalcTotal(){}
    public void CalcTotalWeight(){}

}
