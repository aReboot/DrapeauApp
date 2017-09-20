
package com.example.aller.drapeauapp.modele;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pays {

    @SerializedName("StatusMsg")
    @Expose
    private String statusMsg;
    @SerializedName("Results")
    @Expose
    private Results results;
    @SerializedName("StatusCode")
    @Expose
    private Integer statusCode;

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}
