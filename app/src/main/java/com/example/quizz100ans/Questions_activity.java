package com.example.quizz100ans;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Questions_activity extends AppCompatActivity {

    private String Lieu;
    protected ArrayList<String> listeQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        Lieu = intent.getStringExtra("monLieu");

        BDAdapter QuestionsBdd = new BDAdapter(Questions_activity.this);

        //On ouvre la base de données pour écrire dedans
        QuestionsBdd.open();
        Cursor cursor = QuestionsBdd.getQuestion(Lieu);

        if(cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                listeQuestions.add(cursor.getString(cursor.getColumnIndex("Question")));
            }
        }
        QuestionsBdd.close();

        //création d'un écouteur pour le bouton
        Button btnValider = findViewById(R.id.buttonValiderQuestion);
        TextView textquestion = findViewById(R.id.textView2);
        TextView Question = findViewById(R.id.textView6);

        textquestion.setText(listeQuestions.toString());

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