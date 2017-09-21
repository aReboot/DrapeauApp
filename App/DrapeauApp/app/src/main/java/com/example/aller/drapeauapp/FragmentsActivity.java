package com.example.aller.drapeauapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.aller.drapeauapp.fragments.FragmentsQuizzImage;
import com.example.aller.drapeauapp.fragments.FragmentsQuizzTexte;

/**
 * Created by aller on 19/09/2017.
 */

public class FragmentsActivity extends AppCompatActivity{



    //Fragment
    private FragmentsQuizzImage fragmentsQuizzImage;
    private FragmentsQuizzTexte fragmentsQuizzTexte;

    //Fragment Manager
    private FragmentManager fragmentManager;

    //FragmentTransaction
    private FragmentTransaction fragmentTransaction;







/*
*###################################################################################################
####################################################################################################
--------------------------------------------METHODES------------------------------------------------
####################################################################################################
####################################################################################################
*/



    //Redefintion de la methode OnCreate.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///////////////////////////////////////////////////////////////////////


        //Fragment
        fragmentsQuizzImage=new FragmentsQuizzImage();
        fragmentsQuizzTexte=new FragmentsQuizzTexte();


        



    }






}//end.
