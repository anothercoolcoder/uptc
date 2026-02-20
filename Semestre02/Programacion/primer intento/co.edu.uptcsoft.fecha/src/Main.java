import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.concurrent.CancellationException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("ingrese una fecha");
            String fechaTexto = sc.nextLine();
            //convertir a date
            Date fecha = formatoEntrada.parse(fechaTexto);
            System.out.println("Fecha ingresada:  " + formatoSalida.format(fecha));

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);

//            String[] dias = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
//            System.out.println("Dia de la semana"+ );

            calendar.add(Calendar.DAY_OF_MONTH,7);

            Date fechaActual = new Date();


        } catch (Exception e) {
            System.out.println("Formato incorrecto");
        }


    }
}