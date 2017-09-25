package com.example.aller.drapeauapp.modele;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by aller on 19/09/2017.
 */
@DatabaseTable(tableName = "drapeau")
public class Drapeau {

    @DatabaseField(id = true)
    private String pays;

    @DatabaseField
    private String codePays;

    @DatabaseField//(dataType = DataType.BYTE_ARRAY)
    private String repImage;


/*
*###################################################################################################
####################################################################################################
--------------------------------------------CONSTRUCTEUR--------------------------------------------
####################################################################################################
####################################################################################################
*/

    public Drapeau() {
    }



    public Drapeau(String pays, String codePays, String repImage) {
       this.pays = pays;
        this.codePays = codePays;
        this.repImage = repImage;
    }




    /*
*###################################################################################################
####################################################################################################
--------------------------------------------GUETTERS------------------------------------------------
####################################################################################################
####################################################################################################
*/



    public String getPays() {
        return pays;
    }

   public String getRepImage() {
        return repImage;
   }


    public String getCodePays() {
        return codePays;
    }

    /*
*###################################################################################################
####################################################################################################
--------------------------------------------SETTERS------------------------------------------------
####################################################################################################
####################################################################################################
*/


    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setRepImage(String repImage) {
       this.repImage = repImage;
    }

    public void setCodePays(String codePays) {
        this.codePays = codePays;
    }
}
