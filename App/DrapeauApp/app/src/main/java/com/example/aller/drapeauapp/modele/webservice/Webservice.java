package com.example.aller.drapeauapp.modele.webservice;

import android.util.Log;

import com.example.aller.drapeauapp.modele.Drapeau;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

    Gson gson;

    public Webservice() {
        gson = new Gson();
    }

    private InputStream sendRequest(URL url) throws Exception {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return urlConnection.getInputStream();
            }
        } catch (Exception e) {
            Log.i("webservice", "sendRequest: erreur");
            throw new Exception("Erreur Webservice");
        }
        return null;
    }

    public List<Drapeau> getDrapeaux() {
        try {
            InputStream inputStream = sendRequest(new URL(url));
            if (inputStream != null) {
                InputStreamReader reader = new InputStreamReader(inputStream);
                return gson.fromJson(reader, new TypeToken<List<Drapeau>>(){}.getType());
            }
        } catch (Exception e) {
            Log.e("webservice", "Impossible de rapatrier les données : ");
        }
        return null;
    }

}
