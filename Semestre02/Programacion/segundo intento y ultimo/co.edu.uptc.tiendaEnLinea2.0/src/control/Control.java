package control;

import logic.Logic;

public class Control {
    Logic logic = new Logic();

    public String interfaceCustomer(String name, String address, String id) {
        try {
            return logic.customer(name, address, Integer.parseInt(id));
        } catch (NumberFormatException e) {
            return "Error: ID debe ser un número";
        }
    }

    public String interfaceProduct(String name, String price, String amount, String id) {
        try {
            return logic.product(name, Double.parseDouble(price),
                    Integer.parseInt(amount), Integer.parseInt(id));
        } catch (NumberFormatException e) {
            return "Error: Precio, cantidad e ID deben ser números";
        }
    }

    public String processSinglePurchase(String customerName, String productName, String quantityStr) {
        try {
            int quantity = Integer.parseInt(quantityStr);
            return logic.bill(customerName, productName, quantity);
        } catch (NumberFormatException e) {
            return "Error: La cantidad debe ser un número";
        }
    }

    public String showProducts() {
        return logic.showProducts();
    }
}