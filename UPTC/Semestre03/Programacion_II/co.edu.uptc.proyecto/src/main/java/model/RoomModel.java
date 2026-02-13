package model;

public class RoomModel {
    boolean status;
    int id;

    public RoomModel(boolean status, int id) {
        this.status = status;
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "roomModel{" +
                "status=" + status +
                ", id='" + id + '\'' +
                '}';
    }
}
