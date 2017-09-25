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
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aller.drapeauapp.R;
import com.example.aller.drapeauapp.thread.TimerHandler;
import com.example.aller.drapeauapp.thread.TimerHandlerImplementation;


/**
 * Created by aller on 19/09/2017.
 */

public class FragmentsQuizzImage extends Fragment implements View.OnClickListener {


    //TextView
    private TextView texteViewQuizzImage;

    //ImageButton
    private ImageButton imageButtonQuizzImageUn;
    private ImageButton imageButtonQuizzImageDeux;
    private ImageButton imageButtonQuizzImageTrois;
    private ImageButton imageButtonQuizzImageQuatre;


    //ProgressBar
    private ProgressBar progressBarQuizzImage;

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

        View view = inflater.inflate(R.layout.quizz_image_fragment, container, false);

        ////////////////////////////////////////////////////////////////////////////////////
        //TexteView
        texteViewQuizzImage=view.findViewById(R.id.textViewQuizzImageFragment);

        //ImageButton
        imageButtonQuizzImageUn=view.findViewById(R.id.imageButtonQuizzImageUne);
        imageButtonQuizzImageUn.setOnClickListener(this);

        imageButtonQuizzImageDeux=view.findViewById(R.id.imageButtonQuizzImageDeux);
        imageButtonQuizzImageDeux.setOnClickListener(this);

        imageButtonQuizzImageTrois=view.findViewById(R.id.imageButtonQuizzImageTrois);
        imageButtonQuizzImageTrois.setOnClickListener(this);

        imageButtonQuizzImageQuatre=view.findViewById(R.id.imageButtonQuizzImageQuatre);
        imageButtonQuizzImageQuatre.setOnClickListener(this);


        //ProgressBar
        progressBarQuizzImage=view.findViewById(R.id.progressBarQuizzImage);



        //////////////////////////////////////////////////////////////////////////////////////


        //On retourne la vue
        return view;
    }

        //////////////////////////////////////////////////////////////////////////////////////

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
            throw new ClassCastException(context.toString() + " erreur On Attach");
        }
    }




    //redefinition de la methode onClick pour les actions des buttonImages
    @Override
    public void onClick(View view) {
        Log.i("info","click sur une reponse");
        mFragmentChanger.remplacementDunFragmentUneFoisLeQuizzLance();
    }








}//end.
