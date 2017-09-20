package com.example.aller.drapeauapp.modele.webservice;

import android.util.Log;

import com.example.aller.drapeauapp.modele.Results;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Adrien on 20/09/2017.
 */

public class Webservice {

    private final String url = "http://www.geognos.com/api/en/countries/info/all.json";

    ObjectMapper objectMapper;

    public Webservice() {
        objectMapper = new ObjectMapper();
    }

    private InputStream sendRequest(URL url) throws Exception {
        Log.i("webservice", "sendRequest: url = " + url.toString());
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            Log.i("webservice", "sendRequest: ouverture connexion");
            urlConnection.connect();
            Log.i("webservice", "sendRequest: connexion");
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Log.i("webservice", "sendRequest: reponse du serveur = ok !");
                return urlConnection.getInputStream();
            }
        } catch (Exception e) {
            Log.i("webservice", "sendRequest: erreur ! " + url.toString());
            throw new Exception("Erreur Webservice");
        }
        return null;
    }

    public List<Results> getResults() {
        try {
            InputStream inputStream = sendRequest(new URL(this.url));
            Log.i("webservice", "getResults: requête envoyé");
            if (inputStream != null) {
                Log.i("webservice", "getResults: inputStream non null");
                InputStreamReader reader = new InputStreamReader(inputStream);
                Log.i("webservice", "getResults: reader ok !");
                Log.i("webservice", "getResults: " + objectMapper.readValue(inputStream, new TypeReference<List<Results>>(){}).toString());
            }
        } catch (Exception e) {
            Log.e("webservice", "Impossible de rapatrier les données : ");
        }
        return null;
    }

}
