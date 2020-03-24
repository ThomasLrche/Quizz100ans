package com.example.quizz100ans;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AffichageBdd extends AppCompatActivity {

    protected String mois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_bdd);
        bdd();

    }

    public void bdd(){

        ListView listViewReleves = (ListView) findViewById(R.id.Affichage);
        BdAdapter ReleveBdd = new BdAdapter(AffichageBdd.this);
        //On ouvre la base de données pour écrire dedans
        ReleveBdd.open();
        Cursor c = ReleveBdd.getTableLieu();
        Toast.makeText(getApplicationContext(), "il y a " + String.valueOf(c.getCount()) + " relevés dans la BD", Toast.LENGTH_LONG).show();
        // colonnes à afficher
        String[] columns = new String[]{BdAdapter.COL_ID,BdAdapter.COL_LIEU};
        // champs dans lesquelles afficher les colonnes
        int[] to = new int[]{ R.id.Temp,R.id.Mois};
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(AffichageBdd.this, R.layout.affichage_bdd, c, columns, to, 0);
        // Assign adapter to ListView
        listViewReleves.setAdapter(dataAdapter);
        ReleveBdd.close();

    }
}