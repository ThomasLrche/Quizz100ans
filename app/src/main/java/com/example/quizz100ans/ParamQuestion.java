package com.example.quizz100ans;

public class ParamQuestion {

    protected String id_question;
    protected String question;
    protected String nom_lieu;

    //contructeur paramétré
    public ParamQuestion (String unidquestion, String idQuestion,String nomLieu){
        super();
        this.id_question=unidquestion;
        this.question=idQuestion;
        this.nom_lieu=nomLieu;
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

    public String getNom_lieu() { return nom_lieu; }

    public void setNom_lieu(String nom_lieu) { this.nom_lieu = nom_lieu; }
}
