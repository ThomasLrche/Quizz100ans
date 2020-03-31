package com.example.quizz100ans;

public class ParamReponse {

    protected String id_question;
    protected String reponse1;
    protected String reponse2;
    protected String reponse3;
    protected String questionreponse;
    protected String idquestion;


    //contructeur paramétré
    public ParamReponse (String unidrep, String idrep1, String idrep2, String idrep3,String questrep,String idquest){
        super();
        this.id_question=unidrep;
        this.reponse1=idrep1;
        this.reponse2=idrep2;
        this.reponse3=idrep3;
        this.questionreponse=questrep;
        this.idquestion=idquest;
    }

    public String getId_question() {
        return id_question;
    }

    public void setId_question(String id_question) {
        this.id_question = id_question;
    }

    public String getReponse1() {
        return reponse1;
    }

    public void setReponse1(String reponse1) {
        this.reponse1 = reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public void setReponse2(String reponse2) {
        this.reponse2 = reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public void setReponse3(String reponse3) {
        this.reponse3 = reponse3;
    }

    public String getQuestionreponse() {
        return questionreponse;
    }

    public void setQuestionreponse(String questionreponse) {
        this.questionreponse = questionreponse;
    }

    public String getIdquestion() {
        return idquestion;
    }

    public void setIdquestion(String idquestion) {
        this.idquestion = idquestion;
    }
}
