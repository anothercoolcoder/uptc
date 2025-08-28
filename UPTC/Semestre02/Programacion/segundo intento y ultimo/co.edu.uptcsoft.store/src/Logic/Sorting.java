package Logic;

import Control.Control;

public class Sorting {
    Control control = new Control();
    public String[] sorting(String[] produtcs){
        for (int i = 0; i < produtcs.length; i++) {
            for (int j = 0; j < produtcs.length; j++) {
                if (produtcs[i].compareTo(produtcs[j]) < 0){
                    String temp = produtcs[i];
                    produtcs[i] = produtcs[j];
                    produtcs[j] = temp;
                }
            }
        }
        return produtcs;
    }
}
