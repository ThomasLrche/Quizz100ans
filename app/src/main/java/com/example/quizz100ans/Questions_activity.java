package com.example.quizz100ans;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Questions_activity extends AppCompatActivity {

    private String Lieu;
    private int IndexQ;
    private String laQuestion;
    protected ArrayList<String> listeQuestions = new ArrayList<>();
    protected ArrayList<String> listeReponses1 = new ArrayList<>();
    protected ArrayList<String> listeReponses2 = new ArrayList<>();
    protected ArrayList<String> listeReponses3 = new ArrayList<>();
    protected ArrayList<String> listeReponsesCorrect = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        Lieu = intent.getStringExtra("monLieu");
        IndexQ = Integer.parseInt(intent.getStringExtra("IndexQuest"));

        BDAdapter QuestionsBdd = new BDAdapter(Questions_activity.this);

        //On ouvre la base de données pour écrire dedans
        QuestionsBdd.open();
        Cursor cursorQuest = QuestionsBdd.getQuestion(Lieu);

        if(cursorQuest.getCount() > 0) {
            while(cursorQuest.moveToNext()) {
                listeQuestions.add(cursorQuest.getString(cursorQuest.getColumnIndex("Question")));
            }
        }

        while(listeQuestions.size()>IndexQ){
            laQuestion = listeQuestions.get(IndexQ);
        }

        Cursor cursorReponses = QuestionsBdd.getReponses(laQuestion);

        if(cursorReponses.getCount() > 0) {
            while(cursorReponses.moveToNext()) {
                listeReponses1.add(cursorReponses.getString(cursorReponses.getColumnIndex("reponse1")));
                listeReponses2.add(cursorReponses.getString(cursorReponses.getColumnIndex("reponse2")));
                listeReponses3.add(cursorReponses.getString(cursorReponses.getColumnIndex("reponse3")));
                listeReponsesCorrect.add(cursorReponses.getString(cursorReponses.getColumnIndex( "bonnereponse")));
            }
        }

        QuestionsBdd.close();



        //création d'un écouteur pour le bouton
        Button btnValider = findViewById(R.id.buttonValiderQuestion);
        TextView textquestion = findViewById(R.id.textView2);
        TextView Question = findViewById(R.id.textView6);
        RadioButton reponse1 = findViewById(R.id.quest1);
        RadioButton reponse2 = findViewById(R.id.quest2);
        RadioButton reponse3 = findViewById(R.id.quest3);
        RadioButton reponse4 = findViewById(R.id.quest4);


        textquestion.setText(listeQuestions.toString());
        reponse1.setText(listeReponses1.toString());
        reponse2.setText(listeReponses2.toString());
        reponse3.setText(listeReponses3.toString());
        reponse4.setText(listeReponsesCorrect.toString());


        //for (int i = 0;i<listeQuestions.size();i++) {
        //    textquestion.setText(listeQuestions.get(i));
        //}

        //bdd();



        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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