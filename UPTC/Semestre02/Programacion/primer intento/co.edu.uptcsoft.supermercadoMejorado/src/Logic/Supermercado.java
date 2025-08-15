package Logic;

public class    Supermercado {
    //donde estaran los productos
    String [][] productos = new String[5][2];

    public String[][] getProductos() {
        return productos;
    }

    public void setProductos(String[][] productos) {
        this.productos = productos;
    }

    public Supermercado(){
        //nombre de los productos
        productos [0][0] = "pera";
        productos [1][0] = "manzana";
        productos [2][0] = "arroz";
        productos [3][0] = "frijol";
        productos [4][0] = "lentejas";

        //precio de los productos
        productos [0][1] = "2000";
        productos [1][1] = "3000";
        productos [2][1] = "4000";
        productos [3][1] = "5000";
        productos [4][1] = "6000";
    }

}
