
package com.example.aller.drapeauapp.modele;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Capital {

    @SerializedName("DLST")
    @Expose
    private Double dLST;
    @SerializedName("TD")
    @Expose
    private Double tD;
    @SerializedName("Flg")
    @Expose
    private Integer flg;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("GeoPt")
    @Expose
    private List<Double> geoPt = null;

    public Double getDLST() {
        return dLST;
    }

    public void setDLST(Double dLST) {
        this.dLST = dLST;
    }

    public Double getTD() {
        return tD;
    }

    public void setTD(Double tD) {
        this.tD = tD;
    }

    public Integer getFlg() {
        return flg;
    }

    public void setFlg(Integer flg) {
        this.flg = flg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGeoPt() {
        return geoPt;
    }

    public void setGeoPt(List<Double> geoPt) {
        this.geoPt = geoPt;
    }

}
