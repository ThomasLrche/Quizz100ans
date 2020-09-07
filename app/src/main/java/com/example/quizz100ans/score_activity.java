package com.example.quizz100ans;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class score_activity extends AppCompatActivity {

    private TextView UsernameView;
    private TextView ScoreView;
    private int score;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        Intent intent = getIntent();
        score = intent.getIntExtra("Score",0);
        username = intent.getStringExtra("User");



        UsernameView = findViewById(R.id.textViewUsername);
        UsernameView.setText(username);

        ScoreView = findViewById(R.id.textViewScore);
        ScoreView.setText("Votre score est de " + score + "/10 !");
    }

    // Lors du  clique sur bouton exit, fermeture de l'application
    public void clickexit (View v)

    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
