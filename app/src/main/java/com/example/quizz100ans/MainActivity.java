package com.example.quizz100ans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText usernameLabel;
    private static String username;

    //Données Lieu
    private String Lieu_1="Nantes";
    private String Lieu_2="Joliverie";
    private String Lieu_3="StJoseph";
    private String Lieu_4="StPierre";
    private String Lieu_5="StSébastien";

    //Données Question
    private String Question1 ="Quelle est la capitale de la France";
    private String Question2 ="Quel est le plus grand pays du Monde";
    private String Question3 ="Quel est le plus petit pays du Monde";
    private String Question4 ="Quel est le pays le plus peuplé du Monde";
    private String Question5 ="Quel est la capital du Japon";

    //Données Reponse
    private String Reponsecorrect ="Paris";
    private String Reponse1_1 ="Tokyo";
    private String Reponse1_2 ="Nantes";
    private String Reponse1_3 ="Londres";

    private String Reponsecorrect1 ="Russie";
    private String Reponse2_1 ="Australie";
    private String Reponse2_2 ="Etats-Unis";
    private String Reponse2_3 ="France";

    private String Reponsecorrect2 ="Vatican";
    private String Reponse3_1 ="Luxembourg";
    private String Reponse3_2 ="Suisse";
    private String Reponse3_3 ="Chili";

    private String Reponsecorrect3 ="Chine";
    private String Reponse4_1 ="Espagne";
    private String Reponse4_2 ="Russie";
    private String Reponse4_3 ="Inde";

    private String Reponsecorrect4 ="Tokyo";
    private String Reponse5_1 ="Pekin";
    private String Reponse5_2 ="Madrid";
    private String Reponse5_3 ="Marseille";

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

        usernameLabel = findViewById(R.id.editTextPseudo);


        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(MainActivity.this, choixlieu_activity.class));
                username = usernameLabel.getText().toString();
                intent.putExtra("User", username);
                startActivity(intent);
            }
        });
    }

    // Lors du  clique sur bouton exit, fermeture de l'application
    public void clickexit (View v)

    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
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
        ParamReponse Reponse = new ParamReponse( "1",Reponse1_1 ,Reponse1_2 ,Reponse1_3 ,Reponsecorrect ,"Quelle est la capitale de la France");
        ParamReponse Reponse1 = new ParamReponse( "2",Reponse2_1  ,Reponse2_2  ,Reponse2_3  ,Reponsecorrect1  ,Question2);
        ParamReponse Reponse2 = new ParamReponse( "3",Reponse3_1  ,Reponse3_2  ,Reponse3_3  ,Reponsecorrect2  ,Question3);
        ParamReponse Reponse3 = new ParamReponse( "4",Reponse4_1  ,Reponse4_2  ,Reponse4_3  ,Reponsecorrect3  ,Question4);
        ParamReponse Reponse4 = new ParamReponse( "5",Reponse5_1  ,Reponse5_2  ,Reponse5_3  ,Reponsecorrect4  ,Question5);

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
