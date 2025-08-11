package Gui;

import Control.Control;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Gui {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    Control control = new Control();
    int parkingLot = 0;

    public void view(){
        try{
            askSize();
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Valor invalido, se tomara un valor de 1");
            parkingLot = 1;

        }
        for (int i = 0; i< parkingLot; i++){
            String plate;
            String regex = "^[A-Z]{3}\\d{3}$";
            while (true){
                plate = JOptionPane.showInputDialog(null, "Ingrese la placa del carro #" + (i+1)).toUpperCase();
                if (plate.matches(regex)){
                    JOptionPane.showMessageDialog(null, "Placa valida");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Placa invalida. Debe tener un formato ABC123");
                }
            }
            LocalDateTime startTime = obtenerFecha("Ingrese la fecha de entrada en DD/MM/YYYY HH:mm");
            LocalDateTime finalTime = obtenerFecha("Ingrese la fecha de salida en DD/MM/YYYY HH:mm");
            while (finalTime.isBefore(startTime)){
                JOptionPane.showMessageDialog(null,"La fecha final, no puede ser anterior a la fecha inicial");
                finalTime = obtenerFecha("Ingrese la fecha de salida en DD/MM/YYYY HH:mm");
            }
            JOptionPane.showMessageDialog(null,control.controllerDate(plate,startTime,finalTime));
        }

    }
    public LocalDateTime     obtenerFecha(String message) {
        while (true) {
            String fechaStr = JOptionPane.showInputDialog(null, message);

            try {
                return LocalDateTime.parse(fechaStr, formatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use dd/MM/yyyy HH:mm");
            }

        }
    }

    public void askSize(){
        while(parkingLot <= 0 ) {
            String parkingLotString = JOptionPane.showInputDialog(null, "¿Cuantos vehiculos puede almacenar?");
            parkingLot = Integer.parseInt(parkingLotString);
            if (parkingLot <= 0){
                JOptionPane.showMessageDialog(null, "El valor no puede ser negativo o cero");
            }
        }
    }
}
