package com.example.quizz100ans;

import android.os.Bundle;
import android.widget.Toast;

public class InsertionLieu extends MainActivity{

    private String Lieu_1="Nantes";
    private String Lieu_2="Joliverie";
    private String Lieu_3="StJoseph";
    private String Lieu_4="StPierre";
    private String Lieu_5="StSébastien";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        insertRelever();
    }
    // Insertion du relever
    public void insertRelever(){


        BdAdapter ReleverBdd = new BdAdapter(this);

        //Création de Relever Temps
        ParamLieu Lieu1 = new ParamLieu("1", Lieu_1);
        ParamLieu Lieu2 = new ParamLieu("2", Lieu_2);
        ParamLieu Lieu3 = new ParamLieu("3", Lieu_3);
        ParamLieu Lieu4 = new ParamLieu("4", Lieu_4);
        ParamLieu Lieu5 = new ParamLieu("5", Lieu_5);
        ReleverBdd.open();
        //On insère les articles que l'on vient de créer
        ReleverBdd.insererRelever(Lieu1);
        ReleverBdd.insererRelever(Lieu2);
        ReleverBdd.insererRelever(Lieu3);
        ReleverBdd.insererRelever(Lieu4);
        ReleverBdd.insererRelever(Lieu5);
        ReleverBdd.close();
    }

}
