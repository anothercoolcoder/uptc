package dto;

public class EstadisticasEstudiantesDto {
    private int edadMax;
    private int edadMin;
    private double edadPromedio;
    public EstadisticasEstudiantesDto(int edadMax, int edadMin, double edadPromedio) {
        this.edadMax = edadMax;
        this.edadMin = edadMin;
        this.edadPromedio = edadPromedio;
    }
    public int getEdadMax() {
        return edadMax;
    }
    public void setEdadMax(int edadMax) {
        this.edadMax = edadMax;
    }
    public int getEdadMin() {
        return edadMin;
    }   
    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }
    public double getEdadPromedio() {
        return edadPromedio;
    }
    public void setEdadPromedio(double edadPromedio) {
        this.edadPromedio = edadPromedio;
    }
}
