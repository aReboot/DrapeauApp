package com.example.aller.drapeauapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aller.drapeauapp.modele.Results;
import com.example.aller.drapeauapp.modele.webservice.Webservice;

import java.util.ArrayList;
import java.util.List;

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

        new Thread(new Runnable() {
            @Override
            public void run() {
                Webservice webservice = new Webservice();
                webservice.getResults();
            }
        }).start();

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
