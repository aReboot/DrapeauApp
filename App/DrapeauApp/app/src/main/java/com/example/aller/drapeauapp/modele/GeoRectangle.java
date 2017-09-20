
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
    "West",
    "East",
    "North",
    "South"
})

public class GeoRectangle {

    @JsonProperty("West")
    private Double west;
    @JsonProperty("East")
    private Double east;
    @JsonProperty("North")
    private Double north;
    @JsonProperty("South")
    private Double south;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("West")
    public Double getWest() {
        return west;
    }

    @JsonProperty("West")
    public void setWest(Double west) {
        this.west = west;
    }

    @JsonProperty("East")
    public Double getEast() {
        return east;
    }

    @JsonProperty("East")
    public void setEast(Double east) {
        this.east = east;
    }

    @JsonProperty("North")
    public Double getNorth() {
        return north;
    }

    @JsonProperty("North")
    public void setNorth(Double north) {
        this.north = north;
    }

    @JsonProperty("South")
    public Double getSouth() {
        return south;
    }

    @JsonProperty("South")
    public void setSouth(Double south) {
        this.south = south;
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
