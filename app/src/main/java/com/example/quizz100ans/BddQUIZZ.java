package com.example.quizz100ans;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BddQUIZZ extends SQLiteOpenHelper {

    //LIEU
    private static final String TABLE_Lieu = "TABLE_Lieu";
    static final String COL_ID = "_id";
    private static final String COL_LIEU  = "Lieu";

    //Question
    private static final String TABLE_Question = "TABLE_Question";
    static final String QUEST_ID = "_id";
    private static final String QUEST = "Question";
    private static final String NOM_LIEU = "Nom_Lieu";


    //Reponse
    private static final String TABLE_Reponse = "TABLE_Reponse";
    static final String REP_ID = "_id";
    private static final String REPONSE1 = "reponse1";
    private static final String REPONSE2 = "reponse2";
    private static final String REPONSE3 = "reponse3";
    private static final String BONNEREPONSE = "bonnereponse";
    private static final String IDQuestion = "idquestion";




    //Création de la table Lieu
    private static final String CREATE_BDD_LIEU = "CREATE TABLE " + TABLE_Lieu + " ("+COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," + COL_LIEU +" TEXT NOT NULL);";
    //Création de la table Question
    private static final String CREATE_BDD_Question = "CREATE TABLE " + TABLE_Question + " ("+ QUEST_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ QUEST + " TEXT NOT NULL,"+ NOM_LIEU +" TEXT NOT NULL);";
    //Création de la table Reponse
    private static final String CREATE_BDD_Reponse = "CREATE TABLE " + TABLE_Reponse + " ("+REP_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ REPONSE1 + " TEXT NOT NULL,"+ REPONSE2 + " TEXT NOT NULL,"+ REPONSE3 + " TEXT NOT NULL,"+BONNEREPONSE+" TEXT NOT NULL,"+IDQuestion+" TEXT NOT NULL);";



    //constructeur paramétré
    public BddQUIZZ(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //méthodes d'instance permettant la gestion de l'objet
    public void onCreate(SQLiteDatabase db){
        // appelée lorsqu’aucune base n’existe et que la classe utilitaire doit en créer une
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD

        db.execSQL(CREATE_BDD_LIEU);
        db.execSQL(CREATE_BDD_Question);
        db.execSQL(CREATE_BDD_Reponse);
    }
    // appelée si la version de la base a changé
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut  supprimer la table et de la recréer
        db.execSQL("DROP TABLE " + TABLE_Lieu + ";");
        db.execSQL("DROP TABLE " + TABLE_Question + ";");
        db.execSQL("DROP TABLE " + TABLE_Reponse + ";");
      onCreate(db);
    }

}