package com.example.quizz100ans;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Questions_activity extends AppCompatActivity {


    private RadioGroup ReponseQuest;
    private RadioButton reponse1;
    private RadioButton reponse2;
    private RadioButton reponse3;
    private RadioButton reponse4;
    private String Lieu;
    private String laQuestion;
    private String Unereponse1;
    private String Unereponse2;
    private String Unereponse3;
    private String Unereponse4;
    protected ArrayList<String> listeQuestions = new ArrayList<>();
    protected ArrayList<String> listeReponses1 = new ArrayList<>();
    protected ArrayList<String> listeReponses2 = new ArrayList<>();
    protected ArrayList<String> listeReponses3 = new ArrayList<>();
    protected ArrayList<String> listeReponsesCorrect = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //création d'un écouteur pour le bouton
        Button btnValider = findViewById(R.id.buttonValiderQuestion);
        TextView textquestion = findViewById(R.id.textView2);
        TextView Question = findViewById(R.id.textView6);
        reponse1 = findViewById(R.id.quest1);
        reponse2 = findViewById(R.id.quest2);
        reponse3 = findViewById(R.id.quest3);
        reponse4 = findViewById(R.id.quest4);
        ReponseQuest = findViewById(R.id.questiongrp);

        Intent intent = getIntent();
        Lieu = intent.getStringExtra("monLieu");

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

        for(int a=0;a<listeQuestions.size();a++) {
            laQuestion = listeQuestions.get(a);
            Log.d("test",laQuestion);
        }
        test.open();
        Cursor test1 = test.getReponses(laQuestion);

        if(test1.getCount() > 0) {
            while(test1.moveToNext()) {
                listeReponses1.add(test1.getString(test1.getColumnIndex("reponse1")));
                listeReponses2.add(test1.getString(test1.getColumnIndex("reponse2")));
                listeReponses3.add(test1.getString(test1.getColumnIndex("reponse3")));
                listeReponsesCorrect.add(test1.getString(test1.getColumnIndex( "bonnereponse")));
           }
        }
        for(int a=0;a<listeReponses1.size();a++) {
            Unereponse1 = listeReponses1.get(a);
            Unereponse2 = listeReponses2.get(a);
            Unereponse3 = listeReponses3.get(a);
            Unereponse4 = listeReponsesCorrect.get(a);
            Log.d("test",Unereponse1);
        }



        QuestionsBdd.close();
        test1.close();







        textquestion.setText(laQuestion);
        reponse1.setText(Unereponse1);
        reponse2.setText(Unereponse2);
        reponse3.setText(Unereponse3);
        reponse4.setText(Unereponse4);


        //for (int i = 0;i<listeQuestions.size();i++) {
        //    textquestion.setText(listeQuestions.get(i));
        //}

        //bdd();



        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectId = ReponseQuest.getCheckedRadioButtonId();
                if(reponse4.isSelected()){

                }
                //if lieu a encore une question alors
                //startActivity(new Intent(Questions_activity.this, Questions_activity.class));
                //if lieu n'a pu de question alors
                startActivity(new Intent(Questions_activity.this, choixlieu_activity.class));
            }
        });
    }
    public void bdd(){

        BDAdapter ReleveBdd = new BDAdapter(Questions_activity.this);
        ReleveBdd.open();
        Cursor c = ReleveBdd.getQuestion(Lieu);
        ReleveBdd.close();

        //ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_question, textView6,c );

        //Question.setAdapter(adapter);

    }

}