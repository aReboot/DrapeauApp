package com.example.aller.drapeauapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aller.drapeauapp.db.DBConnection;
import com.example.aller.drapeauapp.modele.Associer;
import com.example.aller.drapeauapp.modele.Drapeau;
import com.example.aller.drapeauapp.modele.Quizz;
import com.example.aller.drapeauapp.modele.Results;
import com.example.aller.drapeauapp.modele.webservice.Webservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar progressBar;
    private TextView textViewBdd;
    private TextView textViewUrl;
    private TextView textViewPseudo;
    private TextView textViewDate;
    private TextView textViewScore;

    //Button
    private Button buttonTest;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button
        buttonTest=(Button)findViewById(R.id.buttonTest);
        buttonTest.setOnClickListener(this);


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Webservice webservice = new Webservice();
//                webservice.getResults();
//            }
//        }).start();
//
//        DBConnection dbConnection = new DBConnection(this, "newbase.db", null, 1);
//
//        Drapeau allemagne = new Drapeau("Allemagne","http://www.geognos.com/api/en/countries/flag/FR.png");
//
//        Quizz quizz2 = new Quizz();
//
//
//        try {
//            dbConnection.getDaoDrapeau().createIfNotExists(allemagne);
//
//            dbConnection.getDaoQuizz().createIfNotExists(quizz2);
//           // DBConnection.daoAssocierPair.createIfNotExists(associer);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        Associer associer = null;
//        try {
//            associer = new Associer(dbConnection.daoDrapeau.queryForId("Allemagne"),dbConnection.daoQuizz.queryForId(2), 1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            dbConnection.getDaoAssocierPair().createIfNotExists(associer);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        textViewBdd = (TextView)findViewById(R.id.textViewInfo);
//        textViewUrl = (TextView)findViewById(R.id.textViewUrl);
//        textViewScore = (TextView)findViewById(R.id.textViewScore);
//
//        try {
//            this.textViewBdd.setText(dbConnection.daoDrapeau.queryForId("France").getPays());
//            this.textViewUrl.setText(String.valueOf(dbConnection.daoQuizz.queryForId(1).getNumero()));
//            //this.textViewScore.setText(String.valueOf(dbConnection.daoAssocierPair.queryForAll().get(0).getSens()));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

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

    @Override
    public void onClick(View view) {
        Log.i("info","passage a l'activité fragmentActivity");
        Intent intent=new Intent(MainActivity.this, FragmentsActivity.class);
        startActivity(intent);
}
