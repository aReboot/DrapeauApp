
package com.example.aller.drapeauapp.modele;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryCodes {

    @SerializedName("tld")
    @Expose
    private String tld;
    @SerializedName("iso3")
    @Expose
    private String iso3;
    @SerializedName("iso2")
    @Expose
    private String iso2;
    @SerializedName("fips")
    @Expose
    private String fips;
    @SerializedName("isoN")
    @Expose
    private Integer isoN;

    public String getTld() {
        return tld;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getFips() {
        return fips;
    }

    public void setFips(String fips) {
        this.fips = fips;
    }

    public Integer getIsoN() {
        return isoN;
    }

    public void setIsoN(Integer isoN) {
        this.isoN = isoN;
    }

}
