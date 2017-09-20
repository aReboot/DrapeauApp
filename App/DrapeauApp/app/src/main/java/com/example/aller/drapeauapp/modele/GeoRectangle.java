
package com.example.aller.drapeauapp.modele;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeoRectangle {

    @SerializedName("West")
    @Expose
    private Double west;
    @SerializedName("East")
    @Expose
    private Double east;
    @SerializedName("North")
    @Expose
    private Double north;
    @SerializedName("South")
    @Expose
    private Double south;

    public Double getWest() {
        return west;
    }

    public void setWest(Double west) {
        this.west = west;
    }

    public Double getEast() {
        return east;
    }

    public void setEast(Double east) {
        this.east = east;
    }

    public Double getNorth() {
        return north;
    }

    public void setNorth(Double north) {
        this.north = north;
    }

    public Double getSouth() {
        return south;
    }

    public void setSouth(Double south) {
        this.south = south;
    }

}
