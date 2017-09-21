package com.example.aller.drapeauapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.aller.drapeauapp.fragments.FragmentsQuizzImage;
import com.example.aller.drapeauapp.fragments.FragmentsQuizzTexte;

import java.util.Random;

/**
 * Created by aller on 19/09/2017.
 */

public class FragmentsActivity extends AppCompatActivity implements View.OnClickListener{

    //Random
    private Random randomGenerateur;

    //Int
    private int randomInt;

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

        //Random
        randomGenerateur=new Random();

        //Fragment
        fragmentsQuizzImage=new FragmentsQuizzImage();
        fragmentsQuizzTexte=new FragmentsQuizzTexte();


        //Application du fragment choisi au hasard a cette endroit
        chargementDunFragmentEnAleatoireAuDebut();


    }


            ////////////////////////////////////////////////////////////////////////
                    //Systeme aleatoire des Fragments
    
    //Methode pour le debut de transaction pour eviter une repetition dans le code
    public void debutDeTransaction(){
        //on doit utiliser un fragment manager
        fragmentManager=getSupportFragmentManager();
        //qui va lancer la transaction
        fragmentTransaction=fragmentManager.beginTransaction();
    }



    //Methode pour charger le fragment QuizzTexte si celui est tire au hasard lord de la methode onCreate.
    public void chargementFragmentQuizzTexte(){

        //recupere les extras qui auraient ete eventuellement passés a l'activity
        fragmentsQuizzTexte.setArguments(getIntent().getExtras());
        //appel de la methode ci-dessus
        debutDeTransaction();
        //on demande une transaction au systeme Android
        fragmentTransaction.add(R.id.relativeLayoutActivityFragment,fragmentsQuizzTexte);
        //on commit la transaction
        fragmentTransaction.commit();
    }


    //Methode pour charger le fragment QuizzImage si celui est tire au hasard lord de la methode onCreate.
    public void chargementFragmentQuizzImage(){

        //recupere les extras qui auraient ete eventuellement passés a l'activity
        fragmentsQuizzImage.setArguments(getIntent().getExtras());
        //appel de la methode ci-dessus
        debutDeTransaction();
        //on demande une transaction au systeme Android
        fragmentTransaction.add(R.id.relativeLayoutActivityFragment,fragmentsQuizzImage);
        //on commit la transaction
        fragmentTransaction.commit();
    }



    //Methode pour remplacer un fragment apres avoir repondu a une qestion ou que le temps est ecoulé

    public void remplacementDuFragmentTexte(){
            fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.relativeLayoutActivityFragment,fragmentsQuizzImage);
            fragmentTransaction.addToBackStack("null");
            fragmentTransaction.commit();
        }


    public void remplacementDuFragmentImage(){
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.relativeLayoutActivityFragment,fragmentsQuizzTexte);
        fragmentTransaction.addToBackStack("null");
        fragmentTransaction.commit();
    }





    //Methode pour le choix du fragment en aleatoire au debut.

    public void chargementDunFragmentEnAleatoireAuDebut(){
        randomInt=randomGenerateur.nextInt(2);
        if(randomInt==0){
            chargementFragmentQuizzTexte();
        }else{
            chargementFragmentQuizzImage();
        }
    }


    //Methode pour remplacer un fragment une fois le quizz lance

    public void remplacementDunFragmentUneFoisLeQuizzLance(){
        randomInt=randomGenerateur.nextInt(2);
        if(randomInt==0){
            remplacementDuFragmentTexte();
        }else{
            remplacementDuFragmentImage();
        }
    }





    @Override
    public void onClick(View view) {

    }








}//end.
