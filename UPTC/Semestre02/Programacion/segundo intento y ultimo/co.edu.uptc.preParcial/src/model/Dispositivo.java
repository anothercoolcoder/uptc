package model;

public abstract class Dispositivo {
    protected String codigo, marca, precio;

    public Dispositivo(String codigo, String marca, String precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
