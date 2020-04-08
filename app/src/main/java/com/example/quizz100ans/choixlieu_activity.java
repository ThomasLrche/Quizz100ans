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
    private String recupville;
    private String recupid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieu);

        //Récupération du Spinner
        spinner = (Spinner) findViewById(R.id.spinner);

        //Création d'une liste d'éléments à mettre dans le Spinner
        List spinnerList = new ArrayList();
        final List spinnerId = new ArrayList();

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

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String monLieu = String.valueOf(spinner.getSelectedItem());
                //recupid = spinner.getSelectedItemId();
                recupville = monLieu;


            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //création d'un écouteur pour le bouton
        Button btnValider = findViewById(R.id.buttonValiderLieu);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =(new Intent(choixlieu_activity.this, Questions_activity.class));
                intent.putExtra("recup",recupville);
                startActivity(intent);
            }
        });
    }
}
