package Control;

import Model.Customer;
import Model.Hotel;

public class Control {
    Hotel hotel;
    public void interfaceHotel(String habs){
        int habsInteger = Integer.parseInt(habs);
        this.hotel = new Hotel(habsInteger);
    }
    public void interfaceCustomer(String customer, String room){
        Customer customer1 = new Customer(customer, room);
        hotel.addCustomer(customer1.toString());
    }
    public String[] showCustomer(){
        return hotel.getHabs();
    }
}
