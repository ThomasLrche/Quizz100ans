package com.example.quizz100ans;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BdAdapter {


    static final int VERSION_BDD =1;
    private static final String NOM_BBD = "bdd.db";
    static final String TABLE_RELEVE = "TABLE_Lieu";
    private TableLieu bdLieu;
    private TableQuestion bdQuestion;
    private TableReponse bdResponse;
    //private TableReleve bdRelever;
    private Context context;
    private SQLiteDatabase db;

    //le constructeur
    public BdAdapter  (Context context){
        this.context = context;
        bdLieu = new TableLieu(context, NOM_BDDLIEU, null, VERSION_BDD);
        bdQuestion = new TableQuestion(context, NOM_Question, null, VERSION_BDD);
        bdResponse = new TableReponse(context, NOM_Question, null, VERSION_BDD);
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
    public long insererRelever(TableLieu unLieu){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(NOM_BDDLIEU, unLieu.getId_lac());
        values.put(NOM_BDDLIEU, unLieu.getJour());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_RELEVE, null, values);
    }




}