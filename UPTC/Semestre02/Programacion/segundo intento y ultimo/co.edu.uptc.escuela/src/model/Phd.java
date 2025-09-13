package model;

public class Phd extends Student{
    private String tittle_phd;

    public Phd(String name, String id, String code, String tittle_phd) {
        super(name, id, code);
        this.tittle_phd = tittle_phd;
    }
}
