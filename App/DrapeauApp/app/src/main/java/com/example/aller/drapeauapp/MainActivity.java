package com.example.aller.drapeauapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aller.drapeauapp.db.DBConnection;
import com.example.aller.drapeauapp.modele.Drapeau;
import com.example.aller.drapeauapp.modele.Quizz;
import com.example.aller.drapeauapp.modele.Utilisateur;
import com.example.aller.drapeauapp.thread.TimerHandler;
import com.example.aller.drapeauapp.thread.TimerHandlerImplementation;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textViewBdd;
    private TextView textViewUrl;
    private TextView textViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBConnection connectionAlaBase = new DBConnection(this, "testRemplissageBisb", null, 1);

        Drapeau france = new Drapeau("France","http://www.geognos.com/api/en/countries/flag/FR.png");

        Quizz numUn = new Quizz(3);


        try {
            DBConnection.daoDrapeau.createIfNotExists(france);

            DBConnection.daoQuizz.createIfNotExists(numUn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        textViewBdd = (TextView)findViewById(R.id.textViewInfo);
        textViewUrl = (TextView)findViewById(R.id.textViewUrl);

        textViewScore = (TextView)findViewById(R.id.textViewScore);

        try {
            this.textViewBdd.setText(DBConnection.daoDrapeau.queryForId("France").getPays());
            this.textViewUrl.setText(DBConnection.daoDrapeau.queryForId("France").getImage());


            System.out.println("Score "+DBConnection.daoQuizz.queryForAll().get(0));
            //this.textViewScore.setText(DBConnection.daoQuizz.queryForId(numUn.getNumero()).getScore());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void incrementProgressBar() {
        /*
        On utilisera ici la méthode incrementProgressBy(1) sur la progressBar
         */
    }

    public void resetProgressBar() {
        /*
        On utilisera ici la méthode setProgressBar(0) sur la progressBar
         */
    }
}
