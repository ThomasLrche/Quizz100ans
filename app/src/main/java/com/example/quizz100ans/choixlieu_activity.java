package com.example.quizz100ans;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class choixlieu_activity extends AppCompatActivity {

    Spinner spinner;
    private String monLieu;
    private static int indexQuest = 0;
    protected static List spinnerList = new ArrayList();
    private List recupnbQuestion = new ArrayList();
    private BDAdapter LieuxBdd = new BDAdapter(choixlieu_activity.this);
    private BDAdapter NbQuestionBdd = new BDAdapter(choixlieu_activity.this);
    private int Score;
    private String lieuFait;
    private static ArrayList<String> lieuxDejaFait = new ArrayList<>();
    private String User;
    private ArrayList<Integer> numfait = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieu);
        numfait.add(0);
        Intent intent = getIntent();
        Score = intent.getIntExtra("Score",0);
        User = intent.getStringExtra("User");

        //Récupération du Spinner
        spinner = (Spinner) findViewById(R.id.spinner);

        //On ouvre la base de données pour écrire dedans
        LieuxBdd.open();
        Cursor cursorLieux = LieuxBdd.getTableLieu();

        spinnerList.clear();
        if(cursorLieux.getCount() > 0) {
            while(cursorLieux.moveToNext()) {
                spinnerList.add(cursorLieux.getString(cursorLieux.getColumnIndex("Lieu")));
            }
        }
        LieuxBdd.close();

        if(getLieuxDejaFait() != null){
            for(int o=0;o<getLieuxDejaFait().size();o++){
                spinnerList.remove(getLieuxDejaFait().get(o));
            }
        }

        //Passage d'un contexte et d'un fichier de présentation dans un adapter pour le spinner
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList);
        //Présentation du spinner déroulé
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Passage de l'adapter au spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                monLieu = String.valueOf(spinner.getSelectedItem());
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //création d'un écouteur pour le bouton
        Button btnValider = findViewById(R.id.buttonValiderLieu);
        Button finLieu= findViewById(R.id.buttonterminerquizz);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = (new Intent(choixlieu_activity.this, Questions_activity.class));
                    intent.putExtra("monLieu", monLieu);
                    intent.putExtra("Score",Score);
                    intent.putExtra("User",User);
                    intent.putExtra("numfait",numfait);
                    startActivity(intent);
            }
        });

        finLieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(choixlieu_activity.this, score_activity.class));
                intent.putExtra("Score", Score);
                intent.putExtra("User", User);
                startActivity(intent);
            }
        });






    }

    public static int getIndexQuest() {
        return indexQuest;
    }

    public static void setIndexQuest(int indexQuest) {
        choixlieu_activity.indexQuest = indexQuest;
    }

    public static ArrayList<String> getLieuxDejaFait() {
        return lieuxDejaFait;
    }

    public static void setLieuxDejaFait(String lieuFait) {
        choixlieu_activity.lieuxDejaFait.add(lieuFait);
    }

}
