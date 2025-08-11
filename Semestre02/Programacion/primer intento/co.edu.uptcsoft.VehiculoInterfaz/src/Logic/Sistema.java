package Logic;

public interface Sistema {
    default String IniciandoSistema(){
        return "Iniciando sistema";
    }

    default String apagandoSistema(){
        return "Apagando sistema";
    }
}
