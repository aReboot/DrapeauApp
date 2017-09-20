
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
    "DLST",
    "TD",
    "Flg",
    "Name",
    "GeoPt"
})
public class Capital {

    @JsonProperty("DLST")
    private Double dLST;
    @JsonProperty("TD")
    private Double tD;
    @JsonProperty("Flg")
    private Integer flg;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("GeoPt")
    private List<Double> geoPt = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("DLST")
    public Double getDLST() {
        return dLST;
    }

    @JsonProperty("DLST")
    public void setDLST(Double dLST) {
        this.dLST = dLST;
    }

    @JsonProperty("TD")
    public Double getTD() {
        return tD;
    }

    @JsonProperty("TD")
    public void setTD(Double tD) {
        this.tD = tD;
    }

    @JsonProperty("Flg")
    public Integer getFlg() {
        return flg;
    }

    @JsonProperty("Flg")
    public void setFlg(Integer flg) {
        this.flg = flg;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("GeoPt")
    public List<Double> getGeoPt() {
        return geoPt;
    }

    @JsonProperty("GeoPt")
    public void setGeoPt(List<Double> geoPt) {
        this.geoPt = geoPt;
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
