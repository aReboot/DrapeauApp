
package com.example.aller.drapeauapp.modele;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Name",
    "Capital",
    "GeoRectangle",
    "SeqID",
    "GeoPt",
    "TelPref",
    "CountryCodes",
    "CountryInfo"
})
public class Results {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Capital")
    private Capital capital;
    @JsonProperty("GeoRectangle")
    private GeoRectangle geoRectangle;
    @JsonProperty("SeqID")
    private Integer seqID;
    @JsonProperty("GeoPt")
    private List<Double> geoPt = null;
    @JsonProperty("TelPref")
    private String telPref;
    @JsonProperty("CountryCodes")
    private CountryCodes countryCodes;
    @JsonProperty("CountryInfo")
    private String countryInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Capital")
    public Capital getCapital() {
        return capital;
    }

    @JsonProperty("Capital")
    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    @JsonProperty("GeoRectangle")
    public GeoRectangle getGeoRectangle() {
        return geoRectangle;
    }

    @JsonProperty("GeoRectangle")
    public void setGeoRectangle(GeoRectangle geoRectangle) {
        this.geoRectangle = geoRectangle;
    }

    @JsonProperty("SeqID")
    public Integer getSeqID() {
        return seqID;
    }

    @JsonProperty("SeqID")
    public void setSeqID(Integer seqID) {
        this.seqID = seqID;
    }

    @JsonProperty("GeoPt")
    public List<Double> getGeoPt() {
        return geoPt;
    }

    @JsonProperty("GeoPt")
    public void setGeoPt(List<Double> geoPt) {
        this.geoPt = geoPt;
    }

    @JsonProperty("TelPref")
    public String getTelPref() {
        return telPref;
    }

    @JsonProperty("TelPref")
    public void setTelPref(String telPref) {
        this.telPref = telPref;
    }

    @JsonProperty("CountryCodes")
    public CountryCodes getCountryCodes() {
        return countryCodes;
    }

    @JsonProperty("CountryCodes")
    public void setCountryCodes(CountryCodes countryCodes) {
        this.countryCodes = countryCodes;
    }

    @JsonProperty("CountryInfo")
    public String getCountryInfo() {
        return countryInfo;
    }

    @JsonProperty("CountryInfo")
    public void setCountryInfo(String countryInfo) {
        this.countryInfo = countryInfo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
