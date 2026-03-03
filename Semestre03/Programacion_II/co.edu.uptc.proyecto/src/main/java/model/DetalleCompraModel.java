package model;

public class DetalleCompraModel {
    int cantidad;
    PrecioUnitarioModel precioUnitarioModel;
    double valorFinal;
    public DetalleCompraModel(int cantidad, PrecioUnitarioModel precioUnitarioModel) {
        this.cantidad = cantidad;
        this.precioUnitarioModel = precioUnitarioModel;
        this.valorFinal = cantidad * precioUnitarioModel.getPrecio();
    }
    public DetalleCompraModel() {
    }
    public double getValorFinal() {
        return valorFinal;
    }
    
}
