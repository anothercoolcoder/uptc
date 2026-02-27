package uptc.model;

public class VideoJuegoModel {
    private int id, stock;
    private String titulo, categoria;
    private double precio;
    public VideoJuegoModel() {
    }
    public VideoJuegoModel(int id, int stock, String titulo, String categoria, double precio) {
        this.id = id;
        this.stock = stock;
        this.titulo = titulo;
        this.categoria = categoria;
        this.precio = precio;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getcategoria() {
        return categoria;
    }
    public void setcategoria(String categoria) {
        this.categoria = categoria;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "VideoJuegoModel [id=" + id + ", stock=" + stock + ", titulo=" + titulo + ", categoria=" + categoria
                + ", precio=" + precio + "]";
    }
    
}
