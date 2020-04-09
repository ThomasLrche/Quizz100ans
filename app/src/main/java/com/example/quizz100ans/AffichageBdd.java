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
        BDAdapter ReleveBdd = new BDAdapter(AffichageBdd.this);
        //On ouvre la base de données pour écrire dedans
        ReleveBdd.open();
        Cursor c = ReleveBdd.getTableReponse();
        Toast.makeText(getApplicationContext(), "il y a " + String.valueOf(c.getCount()) + " relevés dans la BD", Toast.LENGTH_LONG).show();
        // colonnes à afficher
        String[] columns = new String[]{BDAdapter.REP_ID, BDAdapter.REPONSE1, BDAdapter.REPONSE2, BDAdapter.REPONSE3, BDAdapter.BONNEREPONSE, BDAdapter.NOMQuestion};
        // champs dans lesquelles afficher les colonnes
        int[] to = new int[]{ R.id.Id,R.id.rep1,R.id.rep2,R.id.rep3,R.id.reponse,R.id.idQuestion};
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(AffichageBdd.this, R.layout.affichage_bdd, c, columns, to, 0);
        // Assign adapter to ListView
        listViewReleves.setAdapter(dataAdapter);
        ReleveBdd.close();

    }
}