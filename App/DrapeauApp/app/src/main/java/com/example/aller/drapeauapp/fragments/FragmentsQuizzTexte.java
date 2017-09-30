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
import android.widget.TextView;

import com.example.aller.drapeauapp.FragmentsActivity;
import com.example.aller.drapeauapp.ReplaceFont;
import com.example.aller.drapeauapp.R;
import com.example.aller.drapeauapp.ResultatActivity;
import com.example.aller.drapeauapp.db.DBConnection;
import com.example.aller.drapeauapp.modele.Drapeau;
import com.example.aller.drapeauapp.modele.RandomFlag;
import com.example.aller.drapeauapp.modele.Resultat;
import com.squareup.picasso.Picasso;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by aller on 19/09/2017.
 */

public class
FragmentsQuizzTexte extends FragmentQuizz implements View.OnClickListener {

    //View
    private ImageView imageViewQuizzTexte;
    private List<Button> buttonList;
    private TextView timer;
    private TextView question;
    private ProgressBar progressBarQuizzTexte;

    private FragmentActivity fragmentActivity;

    private int timerValue;

/*
*###################################################################################################
####################################################################################################
--------------------------------------------METHODES------------------------------------------------
####################################################################################################
####################################################################################################
*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.quizz_texte_fragment, container, false);

        //Button
        buttonList = new ArrayList<>();
        buttonList.add((Button) view.findViewById(R.id.buttonQuizzTexteUn));
        buttonList.add((Button) view.findViewById(R.id.buttonQuizzTexteDeux));
        buttonList.add((Button) view.findViewById(R.id.buttonQuizzTexteTrois));
        buttonList.add((Button) view.findViewById(R.id.buttonQuizzTexteQuatre));
        addButtonListener();

        //imageView
        imageViewQuizzTexte = view.findViewById(R.id.imageViewQuizzTexteFragment);

        // timer
        timer = view.findViewById(R.id.textView3);
        timerValue = 11;

        // textView
        question = view.findViewById(R.id.textView);
        question.setText("Question " + FragmentsActivity.questionNumber);

        //ProgressBar
        progressBarQuizzTexte = view.findViewById(R.id.progressBarQuizzTexte);

        generateRandomQuizz();

        return view;
    }

    private void addButtonListener() {
        for (Button button : buttonList)
            button.setOnClickListener(this);
    }

    /*
    Gestion de la ProgressBar
     */
    @Override
    public void incrementProgressBar() {
        progressBarQuizzTexte.incrementProgressBy(1);
        setCounter();
    }

    private void setCounter() {
        timerValue--;
        timer.setText(String.valueOf(timerValue));
    }

    @Override
    public void resetProgressBar() {
        progressBarQuizzTexte.setProgress(0);
    }


    /*
    Gestion du clique utilisateur
     */
    @Override
    public void onClick(View view) {
        Log.i("info", "click sur un Button");
        for (int i = 0; i < buttonList.size(); i++) {
            if (view.getId() == buttonList.get(i).getId()) {
                getResultat().setUserAnswer(getFlagsForQuizzList().get(i).getPays());
            }
        }
        ResultatActivity.resultatList.add(getResultat());
        getCallBack().changeFragment();
    }

    /*
    Méthodes héritées de FragmentQuizz, ces deux méthodes changent selon le type de fragment
     */
    @Override
    void setQuestion() {
        Picasso.with(getContext())
                .load(getFlagsForQuizzList().get(getQuestionIndex()).getUrlImage())
                .into(imageViewQuizzTexte);
    }

    @Override
    void setProposals() {
        for (int i = 0; i < getFlagsForQuizzList().size(); i++) {
            buttonList.get(i).setText(getFlagsForQuizzList().get(i).getPays());
        }
    }

}//end.
