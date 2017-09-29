package com.example.aller.drapeauapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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

public class FragmentsQuizzImage extends FragmentQuizz implements View.OnClickListener {

    // View
    private TextView texteViewQuizzImage;
    private List<ImageButton> buttons;
    private ProgressBar progressBarQuizzImage;
    private TextView timer;
    private TextView question;

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

        View view = inflater.inflate(R.layout.quizz_image_fragment, container, false);
        ReplaceFont.replaceDefaultFont(getContext(), "DEFAULT", "Champagne & Limousines.ttf");

        ////////////////////////////////////////////////////////////////////////////////////
        //TexteView
        texteViewQuizzImage = view.findViewById(R.id.textViewQuizzImageFragment);

        //ImageButton
        buttons = new ArrayList<>();
        buttons.add((ImageButton) view.findViewById(R.id.imageButtonQuizzImageUne));
        buttons.add((ImageButton) view.findViewById(R.id.imageButtonQuizzImageDeux));
        buttons.add((ImageButton) view.findViewById(R.id.imageButtonQuizzImageTrois));
        buttons.add((ImageButton) view.findViewById(R.id.imageButtonQuizzImageQuatre));
        addButtonsListeners();

        // timer
        timer = view.findViewById(R.id.textViewTimer);
        timerValue = 11;

        // TextView
        question = view.findViewById(R.id.textView2);
        question.setText("Question " + FragmentsActivity.questionNumber);

        //ProgressBar
        progressBarQuizzImage = view.findViewById(R.id.progressBarQuizzImage);

        generateRandomQuizz();

        return view;
    }

    private void addButtonsListeners() {
        for (ImageButton button : buttons) {
            button.setOnClickListener(this);
        }
    }

    /*
    Gestion de la progressBar
     */
    @Override
    public void incrementProgressBar() {
        progressBarQuizzImage.incrementProgressBy(1);
        counter();
    }

    private void counter() {
        timerValue--;
        timer.setText(String.valueOf(timerValue));
    }

    @Override
    public void resetProgressBar() {
        progressBarQuizzImage.setProgress(0);
    }

    /*
    Gestion du clique utilisateur
     */
    @Override
    public void onClick(View view) {
        Log.i("info", "click sur une reponse");
        for (int i = 0; i < buttons.size(); i++) {
            if (view.getId() == buttons.get(i).getId()) {
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
        texteViewQuizzImage.setText(getFlagsForQuizzList().get(getQuestionIndex()).getPays());
    }

    @Override
    void setProposals() {
        for (int i = 0; i < getFlagsForQuizzList().size(); i++) {
            Picasso.with(getContext())
                    .load(getFlagsForQuizzList().get(i).getUrlImage())
                    .into(buttons.get(i));
        }
    }
}//end.
