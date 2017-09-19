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

    @ForeignCollectionField(eager = false)
    ForeignCollection<Drapeau> drapeaus;

    @ForeignCollectionField(eager = false)
    ForeignCollection<Quizz> quizzs;

    @DatabaseField
    private int sens;


    //CONSTRUCTEUR
    public Associer() {
    }


    public Associer(ForeignCollection<Drapeau> drapeaus, ForeignCollection<Quizz> quizzs, int sens) {
        this.drapeaus = drapeaus;
        this.quizzs = quizzs;
        this.sens = sens;
    }


    //GET

    public ForeignCollection<Drapeau> getDrapeaus() {
        return drapeaus;
    }

    public ForeignCollection<Quizz> getQuizzs() {
        return quizzs;
    }

    public int getSens() {
        return sens;
    }


    //SET

    public void setDrapeaus(ForeignCollection<Drapeau> drapeaus) {
        this.drapeaus = drapeaus;
    }

    public void setQuizzs(ForeignCollection<Quizz> quizzs) {
        this.quizzs = quizzs;
    }

    public void setSens(int sens) {
        this.sens = sens;
    }
}
