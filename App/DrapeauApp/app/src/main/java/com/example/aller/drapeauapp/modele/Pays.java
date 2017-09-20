
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
    "StatusMsg",
    "Results",
    "StatusCode"
})

public class Pays {

    @JsonProperty("StatusMsg")
    private String statusMsg;
    @JsonProperty("Results")
    private Results results;
    @JsonProperty("StatusCode")
    private Integer statusCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("StatusMsg")
    public String getStatusMsg() {
        return statusMsg;
    }

    @JsonProperty("StatusMsg")
    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    @JsonProperty("Results")
    public Results getResults() {
        return results;
    }

    @JsonProperty("Results")
    public void setResults(Results results) {
        this.results = results;
    }

    @JsonProperty("StatusCode")
    public Integer getStatusCode() {
        return statusCode;
    }

    @JsonProperty("StatusCode")
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
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
