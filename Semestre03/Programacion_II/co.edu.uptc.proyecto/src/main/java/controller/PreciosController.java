package controller;

import model.PrecioUnitarioModel;

import java.util.List;

import dao.PreciosDao;

public class PreciosController {
    private PreciosDao dao = new PreciosDao();

    public void createPrecio(int id, String nombre, double precio){
        dao.create(new PrecioUnitarioModel(id,nombre, precio));
    }
    public List<PrecioUnitarioModel> listPrecioModels(){
        return dao.listPrecioModels();
    }
    public void updatePrecioModel(int id, String nombre, double precio){
        dao.updatePrecioModel(new PrecioUnitarioModel(id,nombre, precio));
    }
    public void delete(int id){
        dao.delete(id);
    }
}
