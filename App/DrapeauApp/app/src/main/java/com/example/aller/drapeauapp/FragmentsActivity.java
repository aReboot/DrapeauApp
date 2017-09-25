package com.example.aller.drapeauapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.example.aller.drapeauapp.fragments.FragmentsQuizzImage;
import com.example.aller.drapeauapp.fragments.FragmentsQuizzTexte;
import com.example.aller.drapeauapp.thread.TimerHandler;


import java.util.Random;

/**
 * Created by aller on 19/09/2017.
 */

public class FragmentsActivity extends AppCompatActivity implements
                FragmentsQuizzImage.FragmentChanger,FragmentsQuizzTexte.FragmentChanger {

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
        setContentView(R.layout.activity_fragments);

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
                    //Systeme aleatoire des Fragments au lancement de la partie
    
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
        //on doit utiliser un fragment manager
        fragmentManager=getSupportFragmentManager();
        //qui va lancer la transaction
        fragmentTransaction=fragmentManager.beginTransaction();
        //on demande une transaction au systeme Android
        fragmentTransaction.add(R.id.relativeLayoutActivityFragment,fragmentsQuizzTexte);
        //on commit la transaction
        fragmentTransaction.commit();
    }


    //Methode pour charger le fragment QuizzImage si celui est tire au hasard lord de la methode onCreate.
    public void chargementFragmentQuizzImage(){

        //recupere les extras qui auraient ete eventuellement passés a l'activity
        fragmentsQuizzImage.setArguments(getIntent().getExtras());
        //on doit utiliser un fragment manager
        fragmentManager=getSupportFragmentManager();
        //qui va lancer la transaction
        fragmentTransaction=fragmentManager.beginTransaction();
        //on demande une transaction au systeme Android
        fragmentTransaction.add(R.id.relativeLayoutActivityFragment,fragmentsQuizzImage);
        //on commit la transaction
        fragmentTransaction.commit();
    }



    //Methode pour le choix du fragment en aleatoire au debut.

    public void chargementDunFragmentEnAleatoireAuDebut(){
        randomInt=randomGenerateur.nextInt(2);
        Log.i("info","Choix de la vue grace a la methode Random qui va tirer un numero aleatoire, numero:"+String.valueOf(randomInt));
        if(randomInt==0){
            chargementFragmentQuizzTexte();
        }else{
            chargementFragmentQuizzImage();
        }
    }

            ///////////////////////////////////////////////////////////////////////////
                //REMPLACEMENT DU FRAGMENT UNE FOIS LE QUIZZ LE LANCE


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


    //Methode pour remplacer un fragment une fois le quizz lancé
    @Override
    public void remplacementDunFragmentUneFoisLeQuizzLance() {
        randomInt=randomGenerateur.nextInt(2);
        Log.i("info","choix d'un numero aleatoire pour le remplacement du fragment"+String.valueOf(randomInt));
        if(randomInt==0){
            Log.i("info", "changement de fragment par le fragment texte");
            remplacementDuFragmentTexte();
        }else{
            Log.i("info","changement de fragment par le fragment image");
            remplacementDuFragmentImage();
        }
    }

    //Methode pour la progresse bar
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

}//end.
