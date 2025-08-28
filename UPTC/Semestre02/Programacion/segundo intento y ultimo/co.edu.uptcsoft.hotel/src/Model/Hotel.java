package Model;

public class Hotel {
    public String[] habs;
    public int count;

    public Hotel(int size) {
        habs = new String[size];
    }
    public void addCustomer(String customer){
        if (count < habs.length){
            habs[count] = customer;
            count++;
        }
    }
    public String[] getHabs() {
        return habs;
    }
}
