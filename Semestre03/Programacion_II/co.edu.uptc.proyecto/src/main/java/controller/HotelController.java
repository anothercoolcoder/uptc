package controller;

import model.RoomModel;

import java.util.List;

import dao.HotelDao;

public class HotelController {
    private HotelDao dao = new HotelDao();

    public void createRoom(int id, String nombreHuesped){
        dao.create(new RoomModel(id, nombreHuesped));
    }
    public List<RoomModel> listRoomModels(){
        return dao.listRoomModels();
    }
    public void updateRoomModel(int id, String nombreHuesped){
        dao.updateRoomModel(new RoomModel(id,nombreHuesped));
    }
    public void delete(int id){
        dao.delete(id);
    }
}
