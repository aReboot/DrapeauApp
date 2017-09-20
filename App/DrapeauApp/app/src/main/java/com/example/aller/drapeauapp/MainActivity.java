package com.example.aller.drapeauapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private TextView textViewPseudo;
    private TextView textViewDate;
    private TextView textViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBConnection connectionAlaBase = new DBConnection(this, "testRemplissageBisb", null, 1);
        Drapeau france = new Drapeau("France","http://www.geognos.com/api/en/countries/flag/FR.png");

        Utilisateur utilisateur = new Utilisateur("Kid",new Date());

        Quizz numUn = new Quizz(3,utilisateur);

        try {
            DBConnection.daoDrapeau.createIfNotExists(france);
            DBConnection.daoUtilisateur.createIfNotExists(utilisateur);
            DBConnection.daoQuizz.createIfNotExists(numUn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        textViewBdd = (TextView)findViewById(R.id.textViewInfo);
        textViewUrl = (TextView)findViewById(R.id.textViewUrl);
        textViewPseudo = (TextView)findViewById(R.id.textViewPseudo);
        textViewDate = (TextView)findViewById(R.id.textViewDate);
        textViewScore = (TextView)findViewById(R.id.textViewScore);

        try {
            this.textViewBdd.setText(DBConnection.daoDrapeau.queryForId("France").getPays());
            this.textViewUrl.setText(DBConnection.daoDrapeau.queryForId("France").getImage());
            System.out.println("Pseudo "+DBConnection.daoUtilisateur.queryForId(utilisateur.getIdUtilisateur()).getPseudo());
            this.textViewPseudo.setText(DBConnection.daoUtilisateur.queryForId(utilisateur.getIdUtilisateur()).getPseudo());
            this.textViewDate.setText(DBConnection.daoUtilisateur.queryForId(utilisateur.getIdUtilisateur()).getDate().toString());
            this.textViewScore.setText(DBConnection.daoQuizz.queryForId(numUn.getNumero()).getScore());
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
