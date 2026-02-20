package Gui;

import java.util.List;

public class Gui {
    public int encontrarMaximo(List<Integer> numeros){
        if (numeros.isEmpty()){
            throw new IllegalArgumentException("La lista esta vacia");
        }
        int max = Integer.MIN_VALUE;
        for (int i : numeros){
            max = Math.max(max, i);
        }
        return max;
    }
}
