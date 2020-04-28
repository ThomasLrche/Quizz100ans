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
import java.util.List;

public class choixlieu_activity extends AppCompatActivity {

    Spinner spinner;
    private String monLieu;
    private static int indexQuest = 0;
    private int NbQuest =0;
    private String NbQuest1;
    private List spinnerList = new ArrayList();
    private List recupnbQuestion = new ArrayList();
    private BDAdapter LieuxBdd = new BDAdapter(choixlieu_activity.this);
    private BDAdapter NbQuestionBdd = new BDAdapter(choixlieu_activity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieu);

        //Récupération du Spinner
        spinner = (Spinner) findViewById(R.id.spinner);

        //On ouvre la base de données pour écrire dedans
        LieuxBdd.open();
        Cursor cursorLieux = LieuxBdd.getTableLieu();

        if(cursorLieux.getCount() > 0) {
            while(cursorLieux.moveToNext()) {
                spinnerList.add(cursorLieux.getString(cursorLieux.getColumnIndex("Lieu")));
            }
        }
        LieuxBdd.close();

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

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = (new Intent(choixlieu_activity.this, Questions_activity.class));
                    intent.putExtra("monLieu", monLieu);
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

}
