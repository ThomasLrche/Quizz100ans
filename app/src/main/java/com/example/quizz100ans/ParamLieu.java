package com.example.quizz100ans;

public class ParamLieu {
    protected String id_lieu;
    protected String lieu;

    //contructeur paramétré
    public ParamLieu (String unidlieu, String idlieu){
        super();
        this.id_lieu=unidlieu;
        this.lieu=idlieu;
    }

    //Les accesseurs
    public String getId_lieu() {
        return id_lieu;
    }

    public void setId_lieu(String id_lieu) {
        this.id_lieu = id_lieu;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}
