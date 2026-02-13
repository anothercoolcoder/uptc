package controller;

import java.util.List;

import dao.HotelDao;
import model.RoomModel;

public class HotelController {
    private HotelDao dao = new HotelDao();

    public void createRoom(boolean status, int id) {
        dao.create(new RoomModel(status, id));
    }

    public List<RoomModel> listarHabitaciones() {
        return dao.list();
    }

    public void updateRoom(boolean status, int id) {
        dao.update(new RoomModel(status, id));
    }

    public void eliminarEstudiante(int id) {
        dao.remove(id);
    }
}