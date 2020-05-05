package com.example.quizz100ans;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Questions_activity extends AppCompatActivity {


    private RadioGroup ReponseQuest;
    private RadioButton reponse1;
    private RadioButton reponse2;
    private RadioButton reponse3;
    private RadioButton reponse4;
    private String Lieu;
    private String Unereponse1;
    private String Unereponse2;
    private String Unereponse3;
    private String Unereponse4;
    protected ArrayList<String> liste4reponses = new ArrayList<>();
    protected ArrayList<String> listeQuestions = new ArrayList<>();
    protected ArrayList<String> listeReponses1 = new ArrayList<>();
    protected ArrayList<String> listeReponses2 = new ArrayList<>();
    protected ArrayList<String> listeReponses3 = new ArrayList<>();
    protected ArrayList<String> listeReponsesCorrect = new ArrayList<>();
    private int Score = 0;
    private String User;
    private static ArrayList<String> Questionsdejafaites = new ArrayList<>();
    private int value;
    private int nbQuestion= 0;
    private int idQuestion= 0;
    private boolean test;
    private int recupidQuest;
    private ArrayList<Integer> numfait = new ArrayList<Integer>();
    private ArrayList<Integer> numfaitreponse = new ArrayList<Integer>();
    private ArrayList<Integer> IndexReponse = new ArrayList<Integer>();
    private String reponseselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        //RadioButton  reponse1,reponse2, reponse3,reponse4;
        //création d'un écouteur pour le bouton
        Button btnValider = findViewById(R.id.buttonValiderQuestion);
        TextView textquestion = findViewById(R.id.textView2);
        reponse1 = findViewById(R.id.quest1);
        reponse2 = findViewById(R.id.quest2);
        reponse3 = findViewById(R.id.quest3);
        reponse4 = findViewById(R.id.quest4);
        ReponseQuest = findViewById(R.id.questiongrp);

        final Intent intent = getIntent();
        Lieu = intent.getStringExtra("monLieu");
        Score = intent.getIntExtra("Score",0);
        User = intent.getStringExtra("User");
        nbQuestion = intent.getIntExtra("nbQuestion",0);
        recupidQuest = intent.getIntExtra("idQuest",0);
        numfait.add(recupidQuest);
        numfait=intent.getIntegerArrayListExtra("numfait");

        BDAdapter QuestionsBdd = new BDAdapter(Questions_activity.this);
        BDAdapter test = new BDAdapter(Questions_activity.this);

        //On ouvre la base de données pour écrire dedans
        QuestionsBdd.open();
        Cursor cursorQuest = QuestionsBdd.getQuestion(Lieu);
        if(cursorQuest.getCount() > 0) {
            while(cursorQuest.moveToNext()) {
                listeQuestions.add(cursorQuest.getString(cursorQuest.getColumnIndex("Question")));
            }
        }
        test.open();
        Cursor test1 = test.getReponses(getLaQuestion(choixlieu_activity.getIndexQuest()));
        if(test1.getCount() > 0) {
            while(test1.moveToNext()) {
                listeReponses1.add(test1.getString(test1.getColumnIndex("reponse1")));
                listeReponses2.add(test1.getString(test1.getColumnIndex("reponse2")));
                listeReponses3.add(test1.getString(test1.getColumnIndex("reponse3")));
                listeReponsesCorrect.add(test1.getString(test1.getColumnIndex( "bonnereponse")));
           }
        }
        int abc = 0 ;
        for(int a=0;a<listeReponses1.size();a++) {
            Unereponse1 = listeReponses1.get(a);
            Unereponse2 = listeReponses2.get(a);
            Unereponse3 = listeReponses3.get(a);
            Unereponse4 = listeReponsesCorrect.get(a);
            if(abc ==0){
                liste4reponses.add( listeReponses1.get(a));
                liste4reponses.add( listeReponses2.get(a));
                liste4reponses.add( listeReponses3.get(a));
                liste4reponses.add( listeReponsesCorrect.get(a));
                 abc = 1;
            }
        }
        QuestionsBdd.close();
        test1.close();
        textquestion.setText(getLaQuestion(choixlieu_activity.getIndexQuest()));

        while(AffichagequestionAleatoire().size()<4){
            AffichagequestionAleatoire();
        }

        reponse1.setText(liste4reponses.get(AffichagequestionAleatoire().get(0)));
        reponse2.setText(liste4reponses.get(AffichagequestionAleatoire().get(1)));
        reponse3.setText(liste4reponses.get(AffichagequestionAleatoire().get(2)));
        reponse4.setText(liste4reponses.get(AffichagequestionAleatoire().get(3)));


        reponse1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reponse1.setChecked(true);
                reponse2.setChecked(false);
                reponse3.setChecked(false);
                reponse4.setChecked(false);
                reponseselect= String.valueOf(reponse1.getText());
            }
        });
        reponse2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reponse1.setChecked(false);
                reponse2.setChecked(true);
                reponse3.setChecked(false);
                reponse4.setChecked(false);
                reponseselect= String.valueOf(reponse2.getText());
            }
        });
        reponse3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reponse1.setChecked(false);
                reponse2.setChecked(false);
                reponse3.setChecked(true);
                reponse4.setChecked(false);
                reponseselect= String.valueOf(reponse3.getText());
            }
        });
        reponse4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reponse1.setChecked(false);
                reponse2.setChecked(false);
                reponse3.setChecked(false);
                reponse4.setChecked(true);
                reponseselect=  String.valueOf(reponse4.getText());
            }
        });

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectId = ReponseQuest.getCheckedRadioButtonId();
                if ( !reponse1.isChecked()  &&  !reponse2.isChecked() && !reponse3.isChecked() && !reponse4.isChecked()){
                    Toast.makeText(Questions_activity.this,"Veuillez Sélectionner au moin une réponse",Toast.LENGTH_LONG).show();
                } else {
                    if(reponseselect.equals(Unereponse4) ){
                        Toast.makeText(Questions_activity.this,"Bonne Réponse",Toast.LENGTH_SHORT).show();
                        Score = Score + 1;
                }else {
                        Toast.makeText(Questions_activity.this,"Mauvaise Réponse",Toast.LENGTH_SHORT).show();
                    }
                choixlieu_activity.setIndexQuest(0);
                idQuestion=questionAleatoire();

                choixlieu_activity.setIndexQuest(choixlieu_activity.getIndexQuest() + idQuestion);
                    if (nbQuestion < 4) {
                        reload();
                } else {
                    choixlieu_activity.setIndexQuest(0);
                    choixlieu_activity.setLieuxDejaFait(Lieu);

                    if (choixlieu_activity.spinnerList.size() == 1) {
                        Intent intent = (new Intent(Questions_activity.this, score_activity.class));
                        intent.putExtra("Score", Score);
                        intent.putExtra("User", User);
                        startActivity(intent);
                    } else {
                        Intent intent = (new Intent(Questions_activity.this, choixlieu_activity.class));
                        intent.putExtra("Score", Score);
                        intent.putExtra("User", User);
                        startActivity(intent);
                    }
                }
             }
            }
        });

    }

    public String getLaQuestion(int indexQuestion){
        String laQuestion = null;
        if(indexQuestion<listeQuestions.size()){
            laQuestion = listeQuestions.get(choixlieu_activity.getIndexQuest());
        }
        return laQuestion;
    }


    public ArrayList<Integer> AffichagequestionAleatoire(){
        Random random = new Random();
        for (int r=0; r<4; r++) {
            int valeur = random.nextInt(4-0);
            if (!numfaitreponse.contains((valeur))){
                IndexReponse.add(valeur);
                numfaitreponse.add(valeur);
            }
        }
        return IndexReponse;
    }

    public int questionAleatoire () {
        Random random = new Random();
        test= false;

        while (test == false) {
            int valeur = random.nextInt(10-0);
            if (numfait.contains((valeur))){
                test = false;
            }else{
                    idQuestion = valeur;
                    numfait.add(valeur);
                    test= true;
            }
        }
        return idQuestion;
    }

    public void reload() {
        nbQuestion=nbQuestion+1;
        Intent intent = getIntent();
        intent.putExtra("Score", Score);
        intent.putExtra("User",User);
        intent.putExtra("nbQuestion",nbQuestion);
        intent.putExtra("idQuest",idQuestion);
        intent.putExtra("numfait",numfait);
        finish();
        startActivity(intent);
    }
}