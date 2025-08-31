package Model;

public class User {
    int age;
    String work, name ,state;
    boolean risk, comorbilidades;

    public User(int age, String work, String name, boolean risk, boolean comorbilidades) {
        this.age = age;
        this.work = work;
        this.name = name;
        this.risk = risk;
        this.comorbilidades = comorbilidades;
    }

    public int getAge() {
        return age;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isRisk() {
        return risk;
    }

    public boolean isComorbilidades() {
        return comorbilidades;
    }

    public String getWork() {
        return work;
    }

    @Override
    public String toString() {
        return "Señor/Señora: " + name + ", su estado de vacunacion es el siguiente: " + state;
    }
}
