package com.example.quizz100ans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Données Lieu
    private String Lieu_1="Nantes";
    private String Lieu_2="Joliverie";
    private String Lieu_3="StJoseph";
    private String Lieu_4="StPierre";
    private String Lieu_5="StSébastien";

    //Données Question
    private String Question1 ="Question1";
    private String Question2 ="Question2";
    private String Question3 ="Question3";
    private String Question4 ="Question4";
    private String Question5 ="Question5";

    //Données Reponse
    private String Reponsecorrect ="Reponsecorrect";
    private String Reponse1_1 ="reponse1";
    private String Reponse1_2 ="reponse2";
    private String Reponse1_3 ="reponse3";

    private String Reponsecorrect1 ="2";
    private String Reponse2_1 ="test";
    private String Reponse2_2 ="test2";
    private String Reponse2_3 ="test3";

    private String Reponsecorrect2 ="2";
    private String Reponse3_1 ="test";
    private String Reponse3_2 ="test2";
    private String Reponse3_3 ="test3";

    private String Reponsecorrect3 ="2";
    private String Reponse4_1 ="test";
    private String Reponse4_2 ="test2";
    private String Reponse4_3 ="test3";

    private String Reponsecorrect4 ="2";
    private String Reponse5_1 ="test";
    private String Reponse5_2 ="test2";
    private String Reponse5_3 ="test3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertRelever();
        inserer_Question();
        inserer_Reponse();

        //création d'un écouteur pour le bouton
        Button btnValider = findViewById(R.id.buttonValiderMenu);
        Button btnTestBdd = findViewById(R.id.buttonQuitter);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, choixlieu_activity.class));
            }
        });


        btnTestBdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AffichageBdd.class));
            }
        });
    }

    // Insertion du relever
    public void insertRelever(){


        BDAdapter ReleverBdd = new BDAdapter(this);

        //Création de Relever Temps
        ParamLieu Lieu1 = new ParamLieu( "1", Lieu_1);
        ParamLieu Lieu2 = new ParamLieu( "2", Lieu_2);
        ParamLieu Lieu3 = new ParamLieu( "3", Lieu_3);
        ParamLieu Lieu4 = new ParamLieu( "4", Lieu_4);
        ParamLieu Lieu5 = new ParamLieu( "5", Lieu_5);
        ReleverBdd.open();
        //On insère les articles que l'on vient de créer
        ReleverBdd.inserer_Lieu(Lieu1);
        ReleverBdd.inserer_Lieu(Lieu2);
        ReleverBdd.inserer_Lieu(Lieu3);
        ReleverBdd.inserer_Lieu(Lieu4);
        ReleverBdd.inserer_Lieu(Lieu5);
        ReleverBdd.close();
    }

    public void inserer_Question(){

        BDAdapter ReleverBdd = new BDAdapter(this);

        //Création de Relever Temps
        ParamQuestion quest1 = new ParamQuestion( "1", Question1,"Nantes");
        ParamQuestion quest2 = new ParamQuestion( "2", Question2,"Nantes");
        ParamQuestion quest3 = new ParamQuestion( "3", Question3,"Joliverie");
        ParamQuestion quest4 = new ParamQuestion( "4", Question4,"StJoseph");
        ParamQuestion quest5 = new ParamQuestion( "5", Question5,"StPierre");

        ReleverBdd.open();
        //On insère les articles que l'on vient de créer
        ReleverBdd.inserer_Question(quest1);
        ReleverBdd.inserer_Question(quest2);
        ReleverBdd.inserer_Question(quest3);
        ReleverBdd.inserer_Question(quest4);
        ReleverBdd.inserer_Question(quest5);

        ReleverBdd.close();
    }

    public void inserer_Reponse(){

        BDAdapter ReleverBdd = new BDAdapter(this);

        //Création de Relever Temps
        ParamReponse Reponse = new ParamReponse( "1",Reponse1_1 ,Reponse1_2 ,Reponse1_3 ,Reponsecorrect ,"1");
        ParamReponse Reponse1 = new ParamReponse( "2",Reponse2_1  ,Reponse2_2  ,Reponse2_3  ,Reponsecorrect1  ,"1");
        ParamReponse Reponse2 = new ParamReponse( "3",Reponse3_1  ,Reponse3_2  ,Reponse3_3  ,Reponsecorrect2  ,"2");
        ParamReponse Reponse3 = new ParamReponse( "4",Reponse4_1  ,Reponse4_2  ,Reponse4_3  ,Reponsecorrect3  ,"3");
        ParamReponse Reponse4 = new ParamReponse( "5",Reponse5_1  ,Reponse5_2  ,Reponse5_3  ,Reponsecorrect4  ,"4");

        ReleverBdd.open();
        //On insère les articles que l'on vient de créer
        ReleverBdd.inserer_Reponse(Reponse);
        ReleverBdd.inserer_Reponse(Reponse1);
        ReleverBdd.inserer_Reponse(Reponse2);
        ReleverBdd.inserer_Reponse(Reponse3);
        ReleverBdd.inserer_Reponse(Reponse4);


        ReleverBdd.close();
    }
}
