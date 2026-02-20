package Logic;

import Model.User;

public class Logic {
    User user;
    public String interfaceStudent(String name, int age, String work, boolean risk, boolean sick){
        this.user = new User(age,work,name,risk,sick);
        user.setState(getFirstValidStage());
        return user.toString();
    }

    public String firstStage(){
        if (user.getAge()>=80 || user.getWork().equals("Primera linea")){
            return "Fase 1, primera etapa";
        }else {
            return "No aplica para fase 1, primera etapa";
        }
    }
    public String secondStage(){
        if (user.getAge()<=79||user.getAge()>=60){
            return "Fase 1, segunda etapa";
        } else if (user.getWork().equals("Segunda linea") || user.getWork().equals("Tercera linea")) {
            return "Fase 1, segunda etapa";
        } else{
            return "No aplica para fase 1, segunda etapa";
        }
    }
    public String thirdStage(){
        if (user.getWork().equals("Secundaria") || (user.getAge()<= 45 && user.getAge() >=16 && user.isComorbilidades())){
            return "Fase 1, tercera etapa";
        } else {
            return "No aplica para fase 1, tercera etapa";
        }

    }
    public String fourStage(){
        if (user.getWork().equals("Cuidador")||user.isRisk()){
            return "Fase 2, cuarta etapa";
        } else {
            return "No aplica para fase 2, cuarta etapa";
        }
    }
    public String fiveStage(){
        if (!user.isComorbilidades()){
            return "Fase 2, quinta etapa";
        }
        return "No aplica para fase 2, quinta etapa";
    }
    public String getFirstValidStage() {
        if (fiveStage().startsWith("Fase")) {
            return fiveStage();
        } else if (fourStage().startsWith("Fase")) {
            return fourStage();
        } else if (thirdStage().startsWith("Fase")) {
            return thirdStage();
        } else if (secondStage().startsWith("Fase")) {
            return secondStage();
        } else if (firstStage().startsWith("Fase")) {
            return firstStage();
        } else {
            return "No aplica a ninguna fase";
        }
    }
}
