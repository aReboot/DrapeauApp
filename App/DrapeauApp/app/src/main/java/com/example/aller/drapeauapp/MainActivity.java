package com.example.aller.drapeauapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aller.drapeauapp.db.DBConnection;
import com.example.aller.drapeauapp.modele.Drapeau;
import com.example.aller.drapeauapp.modele.Quizz;
import com.example.aller.drapeauapp.thread.TimerHandler;
import com.example.aller.drapeauapp.thread.TimerHandlerImplementation;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textViewBdd;
    private TextView textViewUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBConnection connectionAlaBase = new DBConnection(this, "testRemplissageBis", null, 1);
        Drapeau france = new Drapeau("France","https://cdn.pixabay.com/photo/2015/11/20/18/55/french-flag-1053711_960_720.png");
        //Quizz numUn = new Quizz();

        try {
            DBConnection.daoDrapeau.createIfNotExists(france);
            //daoQuizz.createIfNotExists(numUn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        textViewBdd = (TextView)findViewById(R.id.textViewInfo);
        textViewUrl = (TextView)findViewById(R.id.textViewUrl);

        try {
            this.textViewBdd.setText(DBConnection.daoDrapeau.queryForId("France").getPays());
            textViewUrl.setText(DBConnection.daoDrapeau.queryForId("France").getImage());
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
