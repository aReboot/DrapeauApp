package com.example.aller.drapeauapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.aller.drapeauapp.db.DBConnection;
import com.example.aller.drapeauapp.modele.Country;
import com.example.aller.drapeauapp.modele.Drapeau;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.picasso.Picasso;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Button
    private Button buttonCommencer;
    private Button buttonQuitter;


/*
*###################################################################################################
####################################################################################################
--------------------------------------------METHODES------------------------------------------------
####################################################################################################
####################################################################################################
*/

    //Redefinition de la methode onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        buttonCommencer = (Button) findViewById(R.id.buttonCommencerMainActivity);
        buttonCommencer.setOnClickListener(this);

        buttonQuitter = (Button) findViewById(R.id.buttonQuitterMainActivity);
        buttonQuitter.setOnClickListener(this);


        DBConnection connection = new DBConnection(this);

        //WebService
        Webservice webservice = new Webservice();
        webservice.execute("http://www.geognos.com/api/en/countries/info/all.json");
        List<Country> countryList = new ArrayList<>();
        int count = 0;
        try {
            countryList = webservice.get();
            for (Country c :
                    countryList) {
                count++;
                Log.i("webservice", "doInBackground: " + count + " " + c.getName() + " " + c.getCode());
                // put country into db
                Drapeau drapeau = new Drapeau(c.getName(), c.getCode(), c.getFlagURL());
                connection.getDaoDrapeau().createIfNotExists(drapeau);
                // load image into cache
                Log.i("picasso", "onCreate: " + count + " " + Picasso.with(getBaseContext()).load(c.getFlagURL()).toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Redefinition de la methode onClick pour les action des buttons.
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.buttonCommencerMainActivity) {
            Intent intent = new Intent(MainActivity.this, FragmentsActivity.class);
            startActivity(intent);
        }

        if(view.getId()==R.id.buttonQuitterMainActivity){
            System.exit(0);
        }

    }


    /*
    *###################################################################################################
    ####################################################################################################
    ----------------------------------PRIVATE CLASS WEB SERVICE-----------------------------------------
    ####################################################################################################
    ####################################################################################################
    */
    private class Webservice extends AsyncTask<String, String, List<Country>> {

        @Override
        protected List<Country> doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                // Getting URL from parametres
                URL url = new URL(params[0]);
                // Estblish a connection
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                // Get a stream from connection
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                // Convert stream into a String
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJson = buffer.toString();

                // Construct Object from JSON
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode actualObj = objectMapper.readTree(finalJson);
                // Get countries codes from JSON
                List<String> codeList = actualObj.findValuesAsText("iso2");
                List<Country> countryList = new ArrayList<>();

                // Building the country List
                for (int i = 0; i < codeList.size(); i++) {
                    Country country = new Country();
                    String code = codeList.get(i);
                    String flagURLprefix = "http://www.geognos.com/api/en/countries/flag/";
                    String flagTypeExtension = ".png";

                    // Get name of a country with the code
                    JsonNode nameNode = actualObj.path("Results").path(code);
                    country.setName(nameNode.path("Name").asText());
                    country.setCode(code);
                    // Build the flag URL
                    country.setFlagURL(flagURLprefix + code + flagTypeExtension);

                    countryList.add(country);
                }


                return countryList;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<Country> s) {
            super.onPostExecute(s);
        }
    }


}//end.
