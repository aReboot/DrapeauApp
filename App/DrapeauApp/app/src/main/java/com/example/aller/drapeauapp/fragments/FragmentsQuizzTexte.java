package com.example.aller.drapeauapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.aller.drapeauapp.R;
import com.example.aller.drapeauapp.thread.TimerHandler;
import com.example.aller.drapeauapp.thread.TimerHandlerImplementation;

/**
 * Created by aller on 19/09/2017.
 */

public class FragmentsQuizzTexte extends Fragment implements View.OnClickListener, ProgressBarProgression{


    //FramgmentActivity
    private FragmentActivity fragmentActivity;

    //ImageView
    private ImageView imageViewQuizzTexte;

    //Button
    private Button buttonQuizzTexteUn;
    private Button buttonQuizzTexteDeux;
    private Button buttonQuizzTexteTrois;
    private Button buttonQuizzTexteQuatre;

    //ProgressBar
    private ProgressBar progressBarQuizzTexte;


    //Interface
    private FragmentChanger mFragmentChanger;




/*
*###################################################################################################
####################################################################################################
--------------------------------------------METHODES------------------------------------------------
####################################################################################################
####################################################################################################
*/



    //redefinition de la methode onCreate View
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.quizz_texte_fragment, container, false);


        ////////////////////////////////////////////////////////////////////////////////////////
        //Button
        buttonQuizzTexteUn=view.findViewById(R.id.buttonQuizzTexteUn);
        buttonQuizzTexteUn.setOnClickListener(this);

        buttonQuizzTexteDeux=view.findViewById(R.id.buttonQuizzTexteDeux);
        buttonQuizzTexteDeux.setOnClickListener(this);

        buttonQuizzTexteTrois=view.findViewById(R.id.buttonQuizzTexteTrois);
        buttonQuizzTexteTrois.setOnClickListener(this);

        buttonQuizzTexteQuatre=view.findViewById(R.id.buttonQuizzTexteQuatre);
        buttonQuizzTexteQuatre.setOnClickListener(this);

        //imageView
        imageViewQuizzTexte=view.findViewById(R.id.imageViewQuizzTexteFragment);

        //ProgressBar
        progressBarQuizzTexte=view.findViewById(R.id.progressBarQuizzTexte);


        /////////////////////////////////////////////////////////////////////////////////////////





        //On retourne la vue
        return view;
    }

    @Override
    public void incrementProgressBar() {
        progressBarQuizzTexte.incrementProgressBy(1);
    }

    @Override
    public void resetProgressBar() {
        progressBarQuizzTexte.setProgress(0);
    }


    /////////////////////////////////////////////////////////////////////////////////



    //Interface pour le changement de fragment
    public interface FragmentChanger {
        public void remplacementDunFragmentUneFoisLeQuizzLance();
    }



    //redefintion de la methode onAttach pour le changement de fragment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mFragmentChanger = (FragmentChanger) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString() + " Erreur onAttach");
        }
    }




    //Redefintion de la methode onClick pour les actions des boutons
    @Override
    public void onClick(View view) {
        Log.i("info","click sur un Button");
        mFragmentChanger.remplacementDunFragmentUneFoisLeQuizzLance();
    }


}//end.
