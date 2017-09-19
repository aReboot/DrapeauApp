package com.example.aller.drapeauapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.aller.drapeauapp.thread.TimerHandler;
import com.example.aller.drapeauapp.thread.TimerHandlerImplementation;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
