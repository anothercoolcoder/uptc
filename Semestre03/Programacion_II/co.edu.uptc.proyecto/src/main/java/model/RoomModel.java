package model;

public class RoomModel {
    public String nombreHuesped;
    public int id;
    public double CuentaModel;
    
    public RoomModel(int id, String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
        this.id = id;
    }

    public RoomModel() {
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCuentaModel() {
        return CuentaModel;
    }

    public void setCuentaModel(double cuentaModel) {
        CuentaModel = cuentaModel;
    }

    
    
}
