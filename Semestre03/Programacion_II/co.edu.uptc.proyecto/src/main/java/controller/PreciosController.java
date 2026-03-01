package controller;

import model.PrecioModel;

import java.util.List;

import dao.PreciosDao;

public class PreciosController {
    private PreciosDao dao = new PreciosDao();

    public void createPrecio(int id, String nombre, double precio){
        dao.create(new PrecioModel(id,nombre, precio));
    }
    public List<PrecioModel> listPrecioModels(){
        return dao.listPrecioModels();
    }
    public void updatePrecioModel(int id, String nombre, double precio){
        dao.updatePrecioModel(new PrecioModel(id,nombre, precio));
    }
    public void delete(int id){
        dao.delete(id);
    }
}
