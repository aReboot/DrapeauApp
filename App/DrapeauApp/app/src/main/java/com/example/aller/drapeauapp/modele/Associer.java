package com.example.aller.drapeauapp.modele;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by aller on 19/09/2017.
 */

@DatabaseTable(tableName = "associer")

public class Associer {


    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, uniqueCombo = true)
    Drapeau drapeaux;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, uniqueCombo = true)
    Quizz quizzs;

    @DatabaseField
    private int sens;



/*
*###################################################################################################
####################################################################################################
--------------------------------------------CONSTRUCTEUR--------------------------------------------
####################################################################################################
####################################################################################################
*/



    public Associer() {
    }

    public Associer(Drapeau drapeaux, Quizz quizzs, int sens) {
        this.drapeaux = drapeaux;
        this.quizzs = quizzs;
        this.sens = sens;
    }

    /*
*###################################################################################################
####################################################################################################
--------------------------------------------GUETTERS------------------------------------------------
####################################################################################################
####################################################################################################
*/



    public int getSens() {
        return sens;
    }

    public Drapeau getDrapeaux() {
        return drapeaux;
    }

    public Quizz getQuizzs() {
        return quizzs;
    }

    /*
*###################################################################################################
####################################################################################################
--------------------------------------------METHODES------------------------------------------------
####################################################################################################
####################################################################################################
*/

    public void setDrapeaux(Drapeau drapeaux) {
        this.drapeaux = drapeaux;
    }

    public void setQuizzs(Quizz quizzs) {
        this.quizzs = quizzs;
    }

    public void setSens(int sens) {
        this.sens = sens;
    }
}
