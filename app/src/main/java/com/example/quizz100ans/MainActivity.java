package com.example.quizz100ans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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

    //Données Question Nantes
    private String Question1 ="Quelle est la capitale de la France";
    private String Question2 ="Quel est le plus grand pays du Monde";
    private String Question3 ="Quel est le plus petit pays du Monde";
    private String Question4 ="Quel est le pays le plus peuplé du Monde";
    private String Question5 ="Quel est la capital du Japon";
    private String Question6 ="Quel est le fleuve le plus long du monde";
    private String Question7 ="Quel pays ne fait pas partie de l Amérique du Sud";
    private String Question8 ="Quel est le continent qui a la plus grande superficie";
    private String Question9 ="Quelle est la capitale du Népal";
    private String Question10 ="Quel est le plus petit Etat du monde";

    //Données Question Joliverie
    private String Question11 ="Quelle est la capitale de la France";
    private String Question12 ="Quel est le plus grand pays du Monde";
    private String Question13 ="Quel est le plus petit pays du Monde";
    private String Question14 ="Quel est le pays le plus peuplé du Monde";
    private String Question15 ="Quel est la capital du Japon";
    private String Question16 ="Quel est le fleuve le plus long du monde";
    private String Question17 ="Quel pays ne fait pas partie de l Amérique du Sud";
    private String Question18 ="Quel est le continent qui a la plus grande superficie";
    private String Question19 ="Quelle est la capitale du Népal";
    private String Question20 ="Quel est le plus petit Etat du monde";

    //Données Question St Joseph
    private String Question21 ="Quelle est la capitale de la France";
    private String Question22 ="Quel est le plus grand pays du Monde";
    private String Question23 ="Quel est le plus petit pays du Monde";
    private String Question24 ="Quel est le pays le plus peuplé du Monde";
    private String Question25 ="Quel est la capital du Japon";
    private String Question26 ="Quel est le fleuve le plus long du monde";
    private String Question27 ="Quel pays ne fait pas partie de l Amérique du Sud";
    private String Question28 ="Quel est le continent qui a la plus grande superficie";
    private String Question29 ="Quelle est la capitale du Népal";
    private String Question30 ="Quel est le plus petit Etat du monde";

    //Données Question St Pierre
    private String Question31 ="Quelle est la capitale de la France";
    private String Question32 ="Quel est le plus grand pays du Monde";
    private String Question33 ="Quel est le plus petit pays du Monde";
    private String Question34 ="Quel est le pays le plus peuplé du Monde";
    private String Question35 ="Quel est la capital du Japon";
    private String Question36 ="Quel est le fleuve le plus long du monde";
    private String Question37 ="Quel pays ne fait pas partie de l Amérique du Sud";
    private String Question38 ="Quel est le continent qui a la plus grande superficie";
    private String Question39 ="Quelle est la capitale du Népal";
    private String Question40 ="Quel est le plus petit Etat du monde";


    //Données Question St Sébastien
    private String Question41 ="Quelle est la capitale de la France";
    private String Question42 ="Quel est le plus grand pays du Monde";
    private String Question43 ="Quel est le plus petit pays du Monde";
    private String Question44 ="Quel est le pays le plus peuplé du Monde";
    private String Question45 ="Quel est la capital du Japon";
    private String Question46 ="Quel est le fleuve le plus long du monde";
    private String Question47 ="Quel pays ne fait pas partie de l Amérique du Sud";
    private String Question48 ="Quel est le continent qui a la plus grande superficie";
    private String Question49 ="Quelle est la capitale du Népal";
    private String Question50 ="Quel est le plus petit Etat du monde";


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


    private String Reponsecorrect5="Le Nil";
    private String Reponse6_1 ="L'Amazone";
    private String Reponse6_2 ="L'Euphrate";
    private String Reponse6_3 ="Le Mississippi";

    private String Reponsecorrect6="Nicaragua";
    private String Reponse7_1 ="Bolivie";
    private String Reponse7_2 ="Uruguay";
    private String Reponse7_3 ="Venezuela";

    private String Reponsecorrect7="L'Asie";
    private String Reponse8_1 ="L'Amérique du Sud";
    private String Reponse8_2 ="L'Amérique de Nord";
    private String Reponse8_3 ="L'Afrique";

    private String Reponsecorrect8="Katmandaou";
    private String Reponse9_1 ="Oulan-Bator";
    private String Reponse9_2 ="Tirana";
    private String Reponse9_3 ="Jakarta";

    private String Reponsecorrect9="Le Vatican";
    private String Reponse10_1 ="Gibraltar";
    private String Reponse10_2 ="Andorre";
    private String Reponse10_3 ="Les îles Seychelles";



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
                username = usernameLabel.getText().toString();
                if(username != null && !username.isEmpty() && !username.contains(" ")){
                    Intent intent = (new Intent(MainActivity.this, choixlieu_activity.class));
                    intent.putExtra("User", username);
                    startActivity(intent);
                } else {
                    usernameLabel.setText("");
                    usernameLabel.setHint("Veuillez entrer un pseudo valide");
                    usernameLabel.setHintTextColor(Color.RED);
                }
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

        //Création Question pour Le lieu 1 (Nantes)
        ParamQuestion quest1 = new ParamQuestion( "1", Question1,Lieu_1);
        ParamQuestion quest2 = new ParamQuestion( "2", Question2,Lieu_1);
        ParamQuestion quest3 = new ParamQuestion( "3", Question3,Lieu_1);
        ParamQuestion quest4 = new ParamQuestion( "4", Question4,Lieu_1);
        ParamQuestion quest5 = new ParamQuestion( "5", Question5,Lieu_1);
        ParamQuestion quest6 = new ParamQuestion("6", Question6,Lieu_1);
        ParamQuestion quest7 = new ParamQuestion("7", Question7,Lieu_1);
        ParamQuestion quest8 = new ParamQuestion("8", Question8,Lieu_1);
        ParamQuestion quest9 = new ParamQuestion("9", Question9,Lieu_1);
        ParamQuestion quest10 = new ParamQuestion("10", Question10,Lieu_1);

        // Création Question pour Le lieu 2 (Joliverie)

        ParamQuestion quest11 = new ParamQuestion( "11", Question1,Lieu_2);
        ParamQuestion quest12 = new ParamQuestion( "12", Question2,Lieu_2);
        ParamQuestion quest13 = new ParamQuestion( "13", Question3,Lieu_2);
        ParamQuestion quest14 = new ParamQuestion( "14", Question4,Lieu_2);
        ParamQuestion quest15 = new ParamQuestion( "15", Question5,Lieu_2);
        ParamQuestion quest16 = new ParamQuestion("16", Question6,Lieu_2);
        ParamQuestion quest17 = new ParamQuestion("17", Question7,Lieu_2);
        ParamQuestion quest18 = new ParamQuestion("18", Question8,Lieu_2);
        ParamQuestion quest19 = new ParamQuestion("19", Question9,Lieu_2);
        ParamQuestion quest20 = new ParamQuestion("20", Question10,Lieu_2);


        // Création Question pour Le Lieu 3 (StJoseph)

        ParamQuestion quest21 = new ParamQuestion( "21", Question1,Lieu_3);
        ParamQuestion quest22 = new ParamQuestion( "22", Question2,Lieu_3);
        ParamQuestion quest23 = new ParamQuestion( "23", Question3,Lieu_3);
        ParamQuestion quest24 = new ParamQuestion( "24", Question4,Lieu_3);
        ParamQuestion quest25 = new ParamQuestion( "25", Question5,Lieu_3);
        ParamQuestion quest26 = new ParamQuestion("26", Question6,Lieu_3);
        ParamQuestion quest27 = new ParamQuestion("27", Question7,Lieu_3);
        ParamQuestion quest28 = new ParamQuestion("28", Question8,Lieu_3);
        ParamQuestion quest29 = new ParamQuestion("29", Question9,Lieu_3);
        ParamQuestion quest30 = new ParamQuestion("30", Question10,Lieu_3);

        // Création Question pour Le Lieu 4 (St Pierre)

        ParamQuestion quest31 = new ParamQuestion( "31", Question1,Lieu_4);
        ParamQuestion quest32 = new ParamQuestion( "32", Question2,Lieu_4);
        ParamQuestion quest33 = new ParamQuestion( "33", Question3,Lieu_4);
        ParamQuestion quest34 = new ParamQuestion( "34", Question4,Lieu_4);
        ParamQuestion quest35 = new ParamQuestion( "35", Question5,Lieu_4);
        ParamQuestion quest36 = new ParamQuestion("36", Question6,Lieu_4);
        ParamQuestion quest37 = new ParamQuestion("37", Question7,Lieu_4);
        ParamQuestion quest38 = new ParamQuestion("38", Question8,Lieu_4);
        ParamQuestion quest39 = new ParamQuestion("39", Question9,Lieu_4);
        ParamQuestion quest40 = new ParamQuestion("40", Question10,Lieu_4);

        // Création Question pour Le Lieu 5 (St Sébastien)

        ParamQuestion quest41 = new ParamQuestion( "41", Question1,Lieu_5);
        ParamQuestion quest42 = new ParamQuestion( "42", Question2,Lieu_5);
        ParamQuestion quest43 = new ParamQuestion( "43", Question3,Lieu_5);
        ParamQuestion quest44 = new ParamQuestion( "44", Question4,Lieu_5);
        ParamQuestion quest45 = new ParamQuestion( "45", Question5,Lieu_5);
        ParamQuestion quest46 = new ParamQuestion("46", Question6,Lieu_5);
        ParamQuestion quest47 = new ParamQuestion("47", Question7,Lieu_5);
        ParamQuestion quest48 = new ParamQuestion("48", Question8,Lieu_5);
        ParamQuestion quest49 = new ParamQuestion("49", Question9,Lieu_5);
        ParamQuestion quest50 = new ParamQuestion("50", Question10,Lieu_5);




        ReleverBdd.open();
        //On insère les articles que l'on vient de créer
        ReleverBdd.inserer_Question(quest1);
        ReleverBdd.inserer_Question(quest2);
        ReleverBdd.inserer_Question(quest3);
        ReleverBdd.inserer_Question(quest4);
        ReleverBdd.inserer_Question(quest5);
        ReleverBdd.inserer_Question(quest6);
        ReleverBdd.inserer_Question(quest7);
        ReleverBdd.inserer_Question(quest8);
        ReleverBdd.inserer_Question(quest9);
        ReleverBdd.inserer_Question(quest10);
        ReleverBdd.inserer_Question(quest11);
        ReleverBdd.inserer_Question(quest12);
        ReleverBdd.inserer_Question(quest13);
        ReleverBdd.inserer_Question(quest14);
        ReleverBdd.inserer_Question(quest15);
        ReleverBdd.inserer_Question(quest16);
        ReleverBdd.inserer_Question(quest17);
        ReleverBdd.inserer_Question(quest18);
        ReleverBdd.inserer_Question(quest19);
        ReleverBdd.inserer_Question(quest20);
        ReleverBdd.inserer_Question(quest21);
        ReleverBdd.inserer_Question(quest22);
        ReleverBdd.inserer_Question(quest23);
        ReleverBdd.inserer_Question(quest24);
        ReleverBdd.inserer_Question(quest25);
        ReleverBdd.inserer_Question(quest26);
        ReleverBdd.inserer_Question(quest27);
        ReleverBdd.inserer_Question(quest28);
        ReleverBdd.inserer_Question(quest29);
        ReleverBdd.inserer_Question(quest30);
        ReleverBdd.inserer_Question(quest31);
        ReleverBdd.inserer_Question(quest32);
        ReleverBdd.inserer_Question(quest33);
        ReleverBdd.inserer_Question(quest34);
        ReleverBdd.inserer_Question(quest35);
        ReleverBdd.inserer_Question(quest36);
        ReleverBdd.inserer_Question(quest37);
        ReleverBdd.inserer_Question(quest38);
        ReleverBdd.inserer_Question(quest39);
        ReleverBdd.inserer_Question(quest40);
        ReleverBdd.inserer_Question(quest41);
        ReleverBdd.inserer_Question(quest42);
        ReleverBdd.inserer_Question(quest43);
        ReleverBdd.inserer_Question(quest44);
        ReleverBdd.inserer_Question(quest45);
        ReleverBdd.inserer_Question(quest46);
        ReleverBdd.inserer_Question(quest47);
        ReleverBdd.inserer_Question(quest48);
        ReleverBdd.inserer_Question(quest49);
        ReleverBdd.inserer_Question(quest50);



        ReleverBdd.close();
    }

    public void inserer_Reponse(){

        BDAdapter ReleverBdd = new BDAdapter(this);

        //Réponse pour Nantes
        ParamReponse Reponse1 = new ParamReponse( "1",Reponse1_1 ,Reponse1_2 ,Reponse1_3 ,Reponsecorrect ,Question1);
        ParamReponse Reponse2 = new ParamReponse( "2",Reponse2_1  ,Reponse2_2  ,Reponse2_3  ,Reponsecorrect1  ,Question2);
        ParamReponse Reponse3 = new ParamReponse( "3",Reponse3_1  ,Reponse3_2  ,Reponse3_3  ,Reponsecorrect2  ,Question3);
        ParamReponse Reponse4 = new ParamReponse( "4",Reponse4_1  ,Reponse4_2  ,Reponse4_3  ,Reponsecorrect3  ,Question4);
        ParamReponse Reponse5 = new ParamReponse( "5",Reponse5_1  ,Reponse5_2  ,Reponse5_3  ,Reponsecorrect4  ,Question5);
        ParamReponse Reponse6 = new ParamReponse( "6",Reponse6_1  ,Reponse6_2  ,Reponse6_3  ,Reponsecorrect5  ,Question6);
        ParamReponse Reponse7 = new ParamReponse( "7",Reponse7_1  ,Reponse7_2  ,Reponse7_3  ,Reponsecorrect6  ,Question7);
        ParamReponse Reponse8 = new ParamReponse( "8",Reponse8_1  ,Reponse8_2  ,Reponse8_3  ,Reponsecorrect7  ,Question8);
        ParamReponse Reponse9 = new ParamReponse( "9",Reponse9_1  ,Reponse9_2  ,Reponse9_3  ,Reponsecorrect8  ,Question9);
        ParamReponse Reponse10 = new ParamReponse( "10",Reponse10_1  ,Reponse10_2  ,Reponse10_3  ,Reponsecorrect9  ,Question10);

        //Réponse pour Joliverie
        ParamReponse Reponse11 = new ParamReponse( "11",Reponse1_1 ,Reponse1_2 ,Reponse1_3 ,Reponsecorrect ,Question11);
        ParamReponse Reponse12 = new ParamReponse( "12",Reponse2_1  ,Reponse2_2  ,Reponse2_3  ,Reponsecorrect1  ,Question12);
        ParamReponse Reponse13 = new ParamReponse( "13",Reponse3_1  ,Reponse3_2  ,Reponse3_3  ,Reponsecorrect2  ,Question13);
        ParamReponse Reponse14 = new ParamReponse( "14",Reponse4_1  ,Reponse4_2  ,Reponse4_3  ,Reponsecorrect3  ,Question14);
        ParamReponse Reponse15 = new ParamReponse( "15",Reponse5_1  ,Reponse5_2  ,Reponse5_3  ,Reponsecorrect4  ,Question15);
        ParamReponse Reponse16 = new ParamReponse( "16",Reponse6_1  ,Reponse6_2  ,Reponse6_3  ,Reponsecorrect5  ,Question16);
        ParamReponse Reponse17 = new ParamReponse( "17",Reponse7_1  ,Reponse7_2  ,Reponse7_3  ,Reponsecorrect6  ,Question17);
        ParamReponse Reponse18 = new ParamReponse( "18",Reponse8_1  ,Reponse8_2  ,Reponse8_3  ,Reponsecorrect7  ,Question18);
        ParamReponse Reponse19 = new ParamReponse( "19",Reponse9_1  ,Reponse9_2  ,Reponse9_3  ,Reponsecorrect8  ,Question19);
        ParamReponse Reponse20 = new ParamReponse( "20",Reponse10_1  ,Reponse10_2  ,Reponse10_3  ,Reponsecorrect9  ,Question20);

        //Réponse St Joseph
        ParamReponse Reponse21 = new ParamReponse( "21",Reponse1_1 ,Reponse1_2 ,Reponse1_3 ,Reponsecorrect ,Question21);
        ParamReponse Reponse22 = new ParamReponse( "22",Reponse2_1  ,Reponse2_2  ,Reponse2_3  ,Reponsecorrect1  ,Question22);
        ParamReponse Reponse23 = new ParamReponse( "23",Reponse3_1  ,Reponse3_2  ,Reponse3_3  ,Reponsecorrect2  ,Question23);
        ParamReponse Reponse24 = new ParamReponse( "24",Reponse4_1  ,Reponse4_2  ,Reponse4_3  ,Reponsecorrect3  ,Question24);
        ParamReponse Reponse25 = new ParamReponse( "25",Reponse5_1  ,Reponse5_2  ,Reponse5_3  ,Reponsecorrect4  ,Question25);
        ParamReponse Reponse26 = new ParamReponse( "26",Reponse6_1  ,Reponse6_2  ,Reponse6_3  ,Reponsecorrect5  ,Question26);
        ParamReponse Reponse27 = new ParamReponse( "27",Reponse7_1  ,Reponse7_2  ,Reponse7_3  ,Reponsecorrect6  ,Question27);
        ParamReponse Reponse28 = new ParamReponse( "28",Reponse8_1  ,Reponse8_2  ,Reponse8_3  ,Reponsecorrect7  ,Question28);
        ParamReponse Reponse29 = new ParamReponse( "29",Reponse9_1  ,Reponse9_2  ,Reponse9_3  ,Reponsecorrect8  ,Question29);
        ParamReponse Reponse30 = new ParamReponse( "30",Reponse10_1  ,Reponse10_2  ,Reponse10_3  ,Reponsecorrect9  ,Question30);

        //Réponse St Pierre
        ParamReponse Reponse31 = new ParamReponse( "31",Reponse1_1 ,Reponse1_2 ,Reponse1_3 ,Reponsecorrect ,Question31);
        ParamReponse Reponse32 = new ParamReponse( "32",Reponse2_1  ,Reponse2_2  ,Reponse2_3  ,Reponsecorrect1  ,Question32);
        ParamReponse Reponse33 = new ParamReponse( "33",Reponse3_1  ,Reponse3_2  ,Reponse3_3  ,Reponsecorrect2  ,Question33);
        ParamReponse Reponse34 = new ParamReponse( "34",Reponse4_1  ,Reponse4_2  ,Reponse4_3  ,Reponsecorrect3  ,Question34);
        ParamReponse Reponse35 = new ParamReponse( "35",Reponse5_1  ,Reponse5_2  ,Reponse5_3  ,Reponsecorrect4  ,Question35);
        ParamReponse Reponse36 = new ParamReponse( "36",Reponse6_1  ,Reponse6_2  ,Reponse6_3  ,Reponsecorrect5  ,Question36);
        ParamReponse Reponse37 = new ParamReponse( "37",Reponse7_1  ,Reponse7_2  ,Reponse7_3  ,Reponsecorrect6  ,Question37);
        ParamReponse Reponse38 = new ParamReponse( "38",Reponse8_1  ,Reponse8_2  ,Reponse8_3  ,Reponsecorrect7  ,Question38);
        ParamReponse Reponse39 = new ParamReponse( "39",Reponse9_1  ,Reponse9_2  ,Reponse9_3  ,Reponsecorrect8  ,Question39);
        ParamReponse Reponse40 = new ParamReponse( "40",Reponse10_1  ,Reponse10_2  ,Reponse10_3  ,Reponsecorrect9  ,Question40);

        //Réponse St Sébastien
        ParamReponse Reponse41 = new ParamReponse( "41",Reponse1_1 ,Reponse1_2 ,Reponse1_3 ,Reponsecorrect ,Question41);
        ParamReponse Reponse42 = new ParamReponse( "42",Reponse2_1  ,Reponse2_2  ,Reponse2_3  ,Reponsecorrect1  ,Question42);
        ParamReponse Reponse43 = new ParamReponse( "43",Reponse3_1  ,Reponse3_2  ,Reponse3_3  ,Reponsecorrect2  ,Question43);
        ParamReponse Reponse44 = new ParamReponse( "44",Reponse4_1  ,Reponse4_2  ,Reponse4_3  ,Reponsecorrect3  ,Question44);
        ParamReponse Reponse45 = new ParamReponse( "45",Reponse5_1  ,Reponse5_2  ,Reponse5_3  ,Reponsecorrect4  ,Question45);
        ParamReponse Reponse46 = new ParamReponse( "46",Reponse6_1  ,Reponse6_2  ,Reponse6_3  ,Reponsecorrect5  ,Question46);
        ParamReponse Reponse47 = new ParamReponse( "47",Reponse7_1  ,Reponse7_2  ,Reponse7_3  ,Reponsecorrect6  ,Question47);
        ParamReponse Reponse48 = new ParamReponse( "48",Reponse8_1  ,Reponse8_2  ,Reponse8_3  ,Reponsecorrect7  ,Question48);
        ParamReponse Reponse49 = new ParamReponse( "49",Reponse9_1  ,Reponse9_2  ,Reponse9_3  ,Reponsecorrect8  ,Question49);
        ParamReponse Reponse50 = new ParamReponse( "50",Reponse10_1  ,Reponse10_2  ,Reponse10_3  ,Reponsecorrect9  ,Question50);

        ReleverBdd.open();
        //On insère Réponses
        ReleverBdd.inserer_Reponse(Reponse1);
        ReleverBdd.inserer_Reponse(Reponse2);
        ReleverBdd.inserer_Reponse(Reponse3);
        ReleverBdd.inserer_Reponse(Reponse4);
        ReleverBdd.inserer_Reponse(Reponse5);
        ReleverBdd.inserer_Reponse(Reponse6);
        ReleverBdd.inserer_Reponse(Reponse7);
        ReleverBdd.inserer_Reponse(Reponse8);
        ReleverBdd.inserer_Reponse(Reponse9);
        ReleverBdd.inserer_Reponse(Reponse10);
        ReleverBdd.inserer_Reponse(Reponse11);
        ReleverBdd.inserer_Reponse(Reponse12);
        ReleverBdd.inserer_Reponse(Reponse13);
        ReleverBdd.inserer_Reponse(Reponse14);
        ReleverBdd.inserer_Reponse(Reponse15);
        ReleverBdd.inserer_Reponse(Reponse16);
        ReleverBdd.inserer_Reponse(Reponse17);
        ReleverBdd.inserer_Reponse(Reponse18);
        ReleverBdd.inserer_Reponse(Reponse19);
        ReleverBdd.inserer_Reponse(Reponse20);
        ReleverBdd.inserer_Reponse(Reponse21);
        ReleverBdd.inserer_Reponse(Reponse22);
        ReleverBdd.inserer_Reponse(Reponse23);
        ReleverBdd.inserer_Reponse(Reponse24);
        ReleverBdd.inserer_Reponse(Reponse25);
        ReleverBdd.inserer_Reponse(Reponse26);
        ReleverBdd.inserer_Reponse(Reponse27);
        ReleverBdd.inserer_Reponse(Reponse28);
        ReleverBdd.inserer_Reponse(Reponse29);
        ReleverBdd.inserer_Reponse(Reponse30);
        ReleverBdd.inserer_Reponse(Reponse31);
        ReleverBdd.inserer_Reponse(Reponse32);
        ReleverBdd.inserer_Reponse(Reponse33);
        ReleverBdd.inserer_Reponse(Reponse34);
        ReleverBdd.inserer_Reponse(Reponse35);
        ReleverBdd.inserer_Reponse(Reponse36);
        ReleverBdd.inserer_Reponse(Reponse37);
        ReleverBdd.inserer_Reponse(Reponse38);
        ReleverBdd.inserer_Reponse(Reponse39);
        ReleverBdd.inserer_Reponse(Reponse40);
        ReleverBdd.inserer_Reponse(Reponse41);
        ReleverBdd.inserer_Reponse(Reponse42);
        ReleverBdd.inserer_Reponse(Reponse43);
        ReleverBdd.inserer_Reponse(Reponse44);
        ReleverBdd.inserer_Reponse(Reponse45);
        ReleverBdd.inserer_Reponse(Reponse46);
        ReleverBdd.inserer_Reponse(Reponse47);
        ReleverBdd.inserer_Reponse(Reponse48);
        ReleverBdd.inserer_Reponse(Reponse49);
        ReleverBdd.inserer_Reponse(Reponse50);
        ReleverBdd.close();
    }
}
