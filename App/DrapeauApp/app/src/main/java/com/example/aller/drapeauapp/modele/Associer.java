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

    @DatabaseField(id = true)
    private String id_drapeau_quizz;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, uniqueCombo = true)
    private Drapeau drapeaux;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, uniqueCombo = true)
    private Quizz quizzs;

    @DatabaseField
    private int sens;



/*
*###################################################################################################
####################################################################################################
--------------------------------------------CONSTRUCTEUR--------------------------------------------
####################################################################################################
####################################################################################################
*/



    public Associer() {}

    public Associer(Drapeau drapeau, Quizz quizz, int sens){
        this.id_drapeau_quizz = drapeau.getPays()+String.valueOf(quizz.getNumero())+String.valueOf(sens);
        this.drapeaux = drapeau;
        this.quizzs = quizz;
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

    public String getId_drapeau_quizz() {
        return id_drapeau_quizz;
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

    public void setId_drapeau_quizz(String id_drapeau_quizz) {
        this.id_drapeau_quizz = id_drapeau_quizz;
    }
}
