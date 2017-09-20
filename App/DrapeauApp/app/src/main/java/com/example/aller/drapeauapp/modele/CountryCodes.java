
package com.example.aller.drapeauapp.modele;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tld",
    "iso3",
    "iso2",
    "fips",
    "isoN"
})
public class CountryCodes {

    @JsonProperty("tld")
    private String tld;
    @JsonProperty("iso3")
    private String iso3;
    @JsonProperty("iso2")
    private String iso2;
    @JsonProperty("fips")
    private String fips;
    @JsonProperty("isoN")
    private Integer isoN;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tld")
    public String getTld() {
        return tld;
    }

    @JsonProperty("tld")
    public void setTld(String tld) {
        this.tld = tld;
    }

    @JsonProperty("iso3")
    public String getIso3() {
        return iso3;
    }

    @JsonProperty("iso3")
    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    @JsonProperty("iso2")
    public String getIso2() {
        return iso2;
    }

    @JsonProperty("iso2")
    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    @JsonProperty("fips")
    public String getFips() {
        return fips;
    }

    @JsonProperty("fips")
    public void setFips(String fips) {
        this.fips = fips;
    }

    @JsonProperty("isoN")
    public Integer getIsoN() {
        return isoN;
    }

    @JsonProperty("isoN")
    public void setIsoN(Integer isoN) {
        this.isoN = isoN;
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
