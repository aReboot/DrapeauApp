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

import com.example.aller.drapeauapp.R;

/**
 * Created by aller on 19/09/2017.
 */

public class FragmentsQuizzTexte extends Fragment implements View.OnClickListener{

    //FramgmentActivity
    private FragmentActivity fragmentActivity;

    //ImageView
    private ImageView imageViewQuizzTexte;

    //Button
    private Button buttonQuizzTexteUn;
    private Button buttonQuizzTexteDeux;
    private Button buttonQuizzTexteTrois;
    private Button buttonQuizzTexteQuatre;




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

        /////////////////////////////////////////////////////////////////////////////////////////





        //On retourne la vue
        return view;
    }




    //redefintion de la methode onAttach
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mFragmentChanger = (FragmentChanger) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString() + " Erreur onAttach");
        }
    }


    public interface FragmentChanger {
        public void remplacementDunFragmentUneFoisLeQuizzLance();
    }


    @Override
    public void onClick(View view) {
        Log.i("info","click sur un Button");
        mFragmentChanger.remplacementDunFragmentUneFoisLeQuizzLance();
    }


}//end.
