package com.example.quizz100ans;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TableLieu extends SQLiteOpenHelper {
    private static final String TABLE_LIEU = "LIEU";
    static final String LIEU_ID = "id";
    private static final String LIEU = "lieu";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_LIEU + " ("+LIEU_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ LIEU + " String NOT NULL);";

    //constructeur paramétré
    public TableLieu(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
        db.execSQL("DROP TABLE " + TABLE_LIEU + ";");
        onCreate(db);
    }

}