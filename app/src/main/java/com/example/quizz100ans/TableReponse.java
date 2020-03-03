package com.example.quizz100ans;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TableReponse extends SQLiteOpenHelper {
    private static final String TABLE_Reponse = "Reponse";
    static final String REP_ID = "id";
    private static final String REPONSE = "reponse";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_Reponse + " ("+REP_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ REPONSE + " String NOT NULL);";

    //constructeur paramétré
    public TableReponse(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //méthodes d'instance permettant la gestion de l'objet
    public void onCreate(SQLiteDatabase db){
        // appelée lorsqu’aucune base n’existe et que la classe utilitaire doit en créer une
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }
    // appelée si la version de la base a changé
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut  supprimer la table et de la recréer
        db.execSQL("DROP TABLE " + TABLE_Reponse + ";");
        onCreate(db);
    }

}