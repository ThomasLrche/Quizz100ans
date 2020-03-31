package com.example.quizz100ans;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class choixlieu_activity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieu);

        //Récupération du Spinner
        spinner = (Spinner) findViewById(R.id.spinner);

        //Création d'une liste d'éléments à mettre dans le Spinner
        List spinnerList = new ArrayList();

        BDAdapter LieuxBdd = new BDAdapter(choixlieu_activity.this);

        //On ouvre la base de données pour écrire dedans
        LieuxBdd.open();
        Cursor cursor = LieuxBdd.getTableLieu();

        if(cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                spinnerList.add(cursor.getString(cursor.getColumnIndex("Lieu")));
            }
        }
        LieuxBdd.close();

        //Passage d'un contexte et d'un fichier de présentation dans un adapter pour le spinner
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList);

        //Présentation du spinner déroulé
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Passage de l'adapter au spinner
        spinner.setAdapter(adapter);

        //création d'un écouteur pour le bouton
        Button btnValider = findViewById(R.id.buttonValiderLieu);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choixlieu_activity.this, Questions_activity.class));
            }
        });
    }
}
