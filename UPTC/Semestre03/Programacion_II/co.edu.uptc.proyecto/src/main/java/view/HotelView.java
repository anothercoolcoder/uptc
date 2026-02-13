package view;

import controller.HotelController;

public class HotelView {
    private HotelController controller = new HotelController();

    public void createRooms() {
        controller.createRoom(true, 1);
        controller.createRoom(false, 2);
        controller.createRoom(true, 3);
        controller.createRoom(false, 4);
    }

    public void listar() {
        controller.listarHabitaciones().forEach(System.out::println);
    }
}