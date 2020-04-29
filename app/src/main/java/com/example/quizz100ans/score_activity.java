package com.example.quizz100ans;

import android.content.Intent;
import android.os.Bundle;
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
        username = intent.getStringExtra("Username");

        UsernameView = findViewById(R.id.textViewUsername);
        UsernameView.setText(username);

        ScoreView = findViewById(R.id.textViewScore);
        ScoreView.setText("Vous avez réussi à obtenir " + score + " points !");
    }
}
