package model;

import java.util.ArrayList;

public class CuentaModel {
    double valorTotal;

    public CuentaModel(ArrayList<DetalleCompraModel> detalleCompraModels) {
        this.valorTotal = detalleCompraModels.stream().mapToDouble(e -> e.getValorFinal()).sum();
    }
     
}
