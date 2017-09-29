package com.example.aller.drapeauapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.aller.drapeauapp.ReplaceFont;
import com.example.aller.drapeauapp.ResultatActivity;
import com.example.aller.drapeauapp.db.DBConnection;
import com.example.aller.drapeauapp.modele.Drapeau;
import com.example.aller.drapeauapp.modele.RandomFlag;
import com.example.aller.drapeauapp.modele.Resultat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrien on 29/09/2017.
 */

public abstract class FragmentQuizz extends Fragment {

    private final int SIZEOFQUIZZ = 4;
    private final int FIRSTELEMENTINDB = 1;

    private DBConnection dbConnection;
    private List<Drapeau> allFlagsList;
    private communicationWithActivity callBack;
    private Resultat resultat;
    private List<Drapeau> flagsForQuizzList;
    private int questionIndex;

    /*
    Interface permettant de changer de fragment
     */
    public interface communicationWithActivity {
        public void changeFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBack = (communicationWithActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ReplaceFont.replaceDefaultFont(getContext(),"DEFAULT","Champagne & Limousines.ttf");

        dbConnection = new DBConnection(getContext());
        flagsForQuizzList = new ArrayList<>(SIZEOFQUIZZ);
        resultat = new Resultat("", "");

        try {
            allFlagsList = dbConnection.getDaoDrapeau().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    Méthodes pour générer un quizz aléatoirement
     */
    public void generateRandomQuizz() {
        RandomFlag randomFlag = new RandomFlag();
        int flagsListSize = allFlagsList.size();
        List<Integer> integers = randomFlag
                .generateRandomIntList(FIRSTELEMENTINDB, flagsListSize - 1, SIZEOFQUIZZ);
        questionIndex = randomFlag.generateRandomInt(0, SIZEOFQUIZZ - 1);
        try {
            buildFlagList(integers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setQuestion();
        setProposals();
        setCorrectResult();
    }

    private void buildFlagList(List<Integer> randomIntList) throws SQLException {
       for (int i = 0; i < SIZEOFQUIZZ; i++) {
           flagsForQuizzList.add(allFlagsList.get(randomIntList.get(i)));
       }
    }

    private void setCorrectResult() {
        resultat.setCorrectAnswer(flagsForQuizzList.get(questionIndex).getPays());
    }

    /*
    Ces méthodes ont un comportement différent selon le fragment dans lequel elles seront
    implémentées.
     */
    abstract void setQuestion();

    abstract void setProposals();

    /*
    Gestion des progressBar
     */
    public abstract void incrementProgressBar();

    public abstract void resetProgressBar();

    /*
    Ajout d'un objet Resultat à la destruction du fragment, permet d'avoir toujours un résultat.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (resultat.getUserAnswer().equals("")) {
            ResultatActivity.resultatList.add(resultat);
        }
    }

    /*
    Getters sur les différents attributs qui sont réutiliser par les classes filles
     */
    public Resultat getResultat() {
        return resultat;
    }

    public List<Drapeau> getFlagsForQuizzList() {
        return flagsForQuizzList;
    }

    public communicationWithActivity getCallBack() {
        return callBack;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }
}
