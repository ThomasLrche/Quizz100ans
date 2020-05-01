package com.example.quizz100ans;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BDAdapter {

    static final int VERSION_BDD =46;
    private static final String BDDQUIZZ = "quizz_bdd";
    static final String TABLE_Lieu = "TABLE_Lieu";
    static final String TABLE_Question = "TABLE_Question";
    static final String TABLE_Reponse = "TABLE_Reponse";

    //Lieu
    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;
    static final String COL_LIEU = "Lieu";
    static final int NUM_COL_LIEU = 1;

    //Question
    static final String QUEST_ID = "_id";
    static final int NUM_COL_QuestID = 2;
    static final String QUEST = "Question";
    static final int NUM_COL_Quest = 3;
    static final String NOM_LIEU = "Nom_Lieu";
    static final int NUM_COL_ID_LIEU = 4;

    //Reponse
    static final String REP_ID = "_id";
    static final int NUM_COL_ID_REP = 5;
    static final String REPONSE1 = "reponse1";
    static final int NUM_COL_REP1 = 6;
    static final String REPONSE2 = "reponse2";
    static final int NUM_COL_REP2 = 7;
    static final String REPONSE3 = "reponse3";
    static final int NUM_COL_REP3 = 8;
    static final String BONNEREPONSE = "bonnereponse";
    static final int NUM_COL_REP4 = 9;
    static final String NOMQuestion = "Question";
    static final int NUM_COL_QUEST= 10;


    private BddQUIZZ bdAdapter;
    private Context context;
    private SQLiteDatabase db;



    //le constructeur
    public BDAdapter(Context context){
        this.context = context;
        bdAdapter = new BddQUIZZ(context, BDDQUIZZ, null, VERSION_BDD);
    }
    //les méthodes d'instance
    public BDAdapter open(){
        db = bdAdapter.getWritableDatabase();

        return this;
    }
    public BDAdapter close (){
        db.close();
        return null;
    }
    public long inserer_Lieu(ParamLieu unLieu){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_ID, unLieu.get_id());
        values.put(COL_LIEU, unLieu.getLieu());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_Lieu, null, values);
    }

    public long inserer_Question(ParamQuestion uneQuestion){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(QUEST_ID, uneQuestion.getId_question());
        values.put(QUEST, uneQuestion.getQuestion());
        values.put(NOM_LIEU, uneQuestion.getNom_lieu());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_Question, null, values);
    }

    public long inserer_Reponse(ParamReponse unereponse){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(REP_ID, unereponse.getId_question());
        values.put(REPONSE1, unereponse.getReponse1());
        values.put(REPONSE2, unereponse.getReponse2());
        values.put(REPONSE3, unereponse.getReponse3());
        values.put(BONNEREPONSE, unereponse.getQuestionreponse());
        values.put(NOMQuestion, unereponse.getNomquestion());

        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_Reponse, null, values);
    }






    public Cursor getTableLieu() {
        return db.rawQuery("SELECT * FROM TABLE_Lieu;",null);
    }

    public Cursor getTableReponse() {
        return db.rawQuery("SELECT * FROM TABLE_Reponse;",null);
    }

    public Cursor getQuestion(String Lieu) {
        return db.rawQuery("SELECT * FROM TABLE_Question WHERE " + NOM_LIEU + " = '" + Lieu + "';",null);
    }

    public Cursor getNbQuestion(String Lieu) {
        return db.rawQuery("SELECT * FROM TABLE_Question WHERE " + NOM_LIEU + " = '" + Lieu + "';",null);
    }

    public Cursor getReponses(String laQuestion) {
        return db.rawQuery("SELECT * FROM TABLE_Reponse WHERE " + NOMQuestion + " = '" + laQuestion + "';",null);
    }



}