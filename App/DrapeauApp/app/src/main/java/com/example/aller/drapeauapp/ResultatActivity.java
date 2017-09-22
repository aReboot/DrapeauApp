package com.example.aller.drapeauapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by aller on 19/09/2017.
 */

public class ResultatActivity extends AppCompatActivity implements View.OnClickListener{


    //Button
    private Button buttonRecommencer;
    private Button buttonRetourAuMenu;



/*
*###################################################################################################
####################################################################################################
--------------------------------------------METHODES------------------------------------------------
####################################################################################################
####################################################################################################
*/





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);


        //Button
        buttonRecommencer=(Button)findViewById(R.id.buttonRecommencer);
        buttonRecommencer.setOnClickListener(this);

        buttonRetourAuMenu=(Button)findViewById(R.id.buttonRetourAuMenu);
        buttonRetourAuMenu.setOnClickListener(this);
    }






    //Redefinition de la methode onClick pour les actions des buttons
    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.buttonRecommencer){

        }else{
            Intent intent= new Intent(ResultatActivity.this, MainActivity.class);
            startActivity(intent);

    }


    }






}//end.
