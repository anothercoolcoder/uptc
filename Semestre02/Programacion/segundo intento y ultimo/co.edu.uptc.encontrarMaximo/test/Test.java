import Gui.Gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Test {

    @org.junit.jupiter.api.Test
    void encontrarMaximo(){
        Gui gui = new Gui();
        List<Integer> lista = new ArrayList<>(List.of(1,2,3,4));
        int resultado = gui.encontrarMaximo(lista);
        assertEquals(4,resultado);
    }
    @org.junit.jupiter.api.Test
    void testEncontrarMaximo_ListaVacia_LanzaExcepcion() {
        Gui gui = new Gui();
        List<Integer> numeros = Collections.emptyList();
        assertThrows(IllegalArgumentException.class, () -> gui.encontrarMaximo(numeros));
    }
}