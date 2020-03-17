package com.example.quizz100ans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Questions_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //création d'un écouteur pour le bouton
        Button btnValider = findViewById(R.id.buttonValiderQuestion);

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
}