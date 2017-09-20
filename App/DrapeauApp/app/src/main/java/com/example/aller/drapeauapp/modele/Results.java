
package com.example.aller.drapeauapp.modele;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Capital")
    @Expose
    private Capital capital;
    @SerializedName("GeoRectangle")
    @Expose
    private GeoRectangle geoRectangle;
    @SerializedName("SeqID")
    @Expose
    private Integer seqID;
    @SerializedName("GeoPt")
    @Expose
    private List<Double> geoPt = null;
    @SerializedName("TelPref")
    @Expose
    private String telPref;
    @SerializedName("CountryCodes")
    @Expose
    private CountryCodes countryCodes;
    @SerializedName("CountryInfo")
    @Expose
    private String countryInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    public GeoRectangle getGeoRectangle() {
        return geoRectangle;
    }

    public void setGeoRectangle(GeoRectangle geoRectangle) {
        this.geoRectangle = geoRectangle;
    }

    public Integer getSeqID() {
        return seqID;
    }

    public void setSeqID(Integer seqID) {
        this.seqID = seqID;
    }

    public List<Double> getGeoPt() {
        return geoPt;
    }

    public void setGeoPt(List<Double> geoPt) {
        this.geoPt = geoPt;
    }

    public String getTelPref() {
        return telPref;
    }

    public void setTelPref(String telPref) {
        this.telPref = telPref;
    }

    public CountryCodes getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(CountryCodes countryCodes) {
        this.countryCodes = countryCodes;
    }

    public String getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(String countryInfo) {
        this.countryInfo = countryInfo;
    }

}
