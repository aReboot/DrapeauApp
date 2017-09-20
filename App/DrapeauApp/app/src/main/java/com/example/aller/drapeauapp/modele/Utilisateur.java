package com.example.aller.drapeauapp.modele;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by aller on 19/09/2017.
 */


@DatabaseTable(tableName="utilisateur")

public class Utilisateur {


    @DatabaseField(generatedId = true)
    private int idUtilisateur;

    @DatabaseField
    private String pseudo;

    @DatabaseField
    private Date date;



/*
*###################################################################################################
####################################################################################################
--------------------------------------------CONSTRUCTEUR--------------------------------------------
####################################################################################################
####################################################################################################
*/

    //Constructeur sans arguments obligatoire
    public Utilisateur(){

    }


    //Constructeur avec arguments
    public Utilisateur(String pseudoUtilisateur, Date dateJeu ){
        this.pseudo=pseudoUtilisateur;
        this.date=dateJeu;
    }



/*
*###################################################################################################
####################################################################################################
--------------------------------------------METHODES------------------------------------------------
####################################################################################################
####################################################################################################
*/



    //Setter du pseudo
    public void setPseudo(String pseudo){
        this.pseudo=pseudo;
    }

    //Setter de la date
    public void setDate(Date date){
        this.date=date;
    }



/*
*###################################################################################################
####################################################################################################
--------------------------------------------GUETTERS------------------------------------------------
####################################################################################################
####################################################################################################
*/


    //getter pour l'id
    public int getIdUtilisateur(){
        return idUtilisateur;
    }


    //getter pour le pseudo
    public String getPseudo(){
        return pseudo;
    }


    //getter pour la date
    public Date getDate(){
        return date;
    }








}//end.
