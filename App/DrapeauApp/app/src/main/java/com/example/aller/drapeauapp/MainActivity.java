package com.example.aller.drapeauapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.aller.drapeauapp.modele.Drapeau;
import com.example.aller.drapeauapp.modele.webservice.Webservice;
import com.example.aller.drapeauapp.thread.TimerHandler;
import com.example.aller.drapeauapp.thread.TimerHandlerImplementation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Webservice webservice = new Webservice();
        List<Drapeau> list = new ArrayList<>();
        list = webservice.getDrapeaux();
        Log.i("webservice", "1er élément de la liste = " + list.get(0).getPays());
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
