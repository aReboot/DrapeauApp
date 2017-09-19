package com.example.aller.drapeauapp.modele;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by aller on 19/09/2017.
 */

    @DatabaseTable(tableName="quizz")

public class Quizz {


    @DatabaseField (generatedId = true)
    private int numero;


    @DatabaseField (canBeNull = false, foreign = true,foreignAutoRefresh=true)
    private int idUtilisateur;



/*
*###################################################################################################
####################################################################################################
--------------------------------------------CONSTRUCTEUR--------------------------------------------
####################################################################################################
####################################################################################################
*/


    //Constructeur sans arguments obligatoire
    public Quizz(){

    }




/*
*###################################################################################################
####################################################################################################
--------------------------------------------GUETTERS------------------------------------------------
####################################################################################################
####################################################################################################
*/

    //Getter pour le numero du quizz
    public int getNumero() {
        return numero;
    }





}//end.