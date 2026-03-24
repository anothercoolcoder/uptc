import dao.UsuariosDao;
import data.RedisDataUsers;
import view.HotelView;

public class Main {
    public static void main(String[] args) {
        HotelView hotelView = new HotelView();
        hotelView.setVisible(true);
        RedisDataUsers red = new RedisDataUsers();
        red.cargar();
        
    }
}