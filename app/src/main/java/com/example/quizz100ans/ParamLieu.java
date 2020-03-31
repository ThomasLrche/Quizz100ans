package com.example.quizz100ans;

public class ParamLieu {

    protected String lieu;
    protected String _id;

    //contructeur paramétré
    public ParamLieu (String id,String lieu){
        super();
        this.lieu=lieu;
        this._id=id;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
