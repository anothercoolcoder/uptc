package Model;

import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private Usuario usuario;
    private String fecha;
    private ArrayList<Producto> productosPedidos;


    public Pedido(int idPedido, Usuario usuario, String fecha){
        this.idPedido =  idPedido;
        this.usuario = usuario;
        this.fecha = fecha;
        this.productosPedidos = new ArrayList<>();
    }



}
