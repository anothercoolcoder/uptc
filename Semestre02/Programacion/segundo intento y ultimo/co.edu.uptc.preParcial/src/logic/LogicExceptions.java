package logic;

public class LogicExceptions {

    // Excepción: Dispositivo no encontrado
    public static class DispositivoNoEncontradoException extends Exception {
        public DispositivoNoEncontradoException(String code) {
            super("No se encontró un dispositivo con el código: " + code);
        }
    }

    // Excepción: Código duplicado
    public static class CodigoDuplicadoException extends Exception {
        public CodigoDuplicadoException(String code) {
            super("El código " + code + " ya está registrado en el sistema.");
        }
    }

    // Excepción: Precio inválido
    public static class PrecioInvalidoException extends RuntimeException {
        public PrecioInvalidoException(double precio) {
            super("Precio inválido: " + precio + ". Debe ser mayor que cero.");
        }
    }

    // Excepción: Lista vacía (ejemplo genérico)
    public static class ListaVaciaException extends Exception {
        public ListaVaciaException() {
            super("No hay dispositivos registrados en el inventario.");
        }
    }
}
