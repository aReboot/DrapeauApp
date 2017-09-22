package com.example.aller.drapeauapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aller.drapeauapp.modele.Country;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

        private ProgressBar progressBar;
        private TextView textViewBdd;
        private TextView textViewUrl;
        private TextView textViewPseudo;
        private TextView textViewDate;
        private TextView textViewScore;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

		Webservice webservice = new Webservice();
		webservice.execute("http://www.geognos.com/api/en/countries/info/all.json");
		List<Country> countryList = new ArrayList<>();
		try {
			countryList = webservice.get();
			for (Country c:
					countryList) {
				Log.i("webservice", "doInBackground: " + c.getName() + " " + c.getCode());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

        public void incrementProgressBar() {
            /*
            On utilisera ici la méthode incrementProgressBy(1) sur la progressBar
             */
        }

        public void resetProgressBar() {
            /*
            On utilisera ici la méthode setProgressBar(0) sur la progressBar
             */
        }

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
}
