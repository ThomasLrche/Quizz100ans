package com.example.quizz100ans;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BdAdapter {


    static final int VERSION_BDD =1;
    private static final String BDDQUIZZ = "bdd.db";
    static final String TABLE_Lieu = "TABLE_Lieu";
    private TableLieu bdLieu;
    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;
    static final String COL_LIEU = "Lieu";
    static final int NUM_COL_LIEU = 1;
    private Context context;
    private SQLiteDatabase db;

    //le constructeur
    public BdAdapter  (Context context){
        this.context = context;
        bdLieu = new TableLieu(context, BDDQUIZZ, null, VERSION_BDD);
        //bdQuestion = new TableQuestion(context, NOM_Question, null, VERSION_BDD);
        //bdResponse = new TableReponse(context, NOM_Question, null, VERSION_BDD);
    }

    //les méthodes d'instance
    public BdAdapter  open(){
        db = bdLieu.getWritableDatabase();
        return this;
    }
    public BdAdapter  close (){
        db.close();
        return null;
    }
    public long insererRelever(ParamLieu unLieu){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_LIEU, unLieu.getId_lieu());
        values.put(COL_LIEU, unLieu.getLieu());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_Lieu, null, values);
    }

    public Cursor getTableLieu() {
        return db.rawQuery("SELECT *  FROM TABLE_Lieu;" ,null);
    }


}