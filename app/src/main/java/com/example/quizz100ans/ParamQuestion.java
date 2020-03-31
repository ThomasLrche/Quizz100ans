package com.example.quizz100ans;

public class ParamQuestion {

    protected String id_question;
    protected String question;
    protected String id_lieu;

    //contructeur paramétré
    public ParamQuestion (String unidquestion, String idQuestion,String unidlieu){
        super();
        this.id_question=unidquestion;
        this.question=idQuestion;
        this.id_lieu=unidlieu;
    }

    public String getId_question() {
        return id_question;
    }

    public void setId_question(String id_question) {
        this.id_question = id_question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getId_lieu() {
        return id_lieu;
    }

    public void setId_lieu(String id_lieu) {
        this.id_lieu = id_lieu;
    }
}
