package com.example.aller.drapeauapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aller.drapeauapp.modele.Drapeau;
import com.example.aller.drapeauapp.modele.Resultat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aller on 19/09/2017.
 */

public class ResultatActivity extends AppCompatActivity implements View.OnClickListener {


	//Button
	private Button buttonRecommencer;
	private Button buttonRetourAuMenu;

	//List
	private ListView listViewResultat;

	// score
	private int score;
	private TextView scoreTextView;

	//modele resultat
	public static List<Resultat> resultatList = new ArrayList<>();



/*
*###################################################################################################
####################################################################################################
--------------------------------------------METHODES------------------------------------------------
####################################################################################################
####################################################################################################
*/


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultat);
		ReplaceFont.replaceDefaultFont(this,"SERIF","Champagne & Limousines.ttf");

		//Button
		buttonRecommencer = (Button) findViewById(R.id.buttonRecommencer);
		buttonRecommencer.setOnClickListener(this);

		buttonRetourAuMenu = (Button) findViewById(R.id.buttonRetourAuMenu);
		buttonRetourAuMenu.setOnClickListener(this);

		// textView
		scoreTextView = (TextView) findViewById(R.id.textViewScoreActivityResultat);

		//List de resultat avec adapteur personnaliser
		MonAdapteurDeList monAdapteurDeList = new MonAdapteurDeList(this, resultatList);
		listViewResultat = (ListView) findViewById(R.id.listViewActivityResultat);
		listViewResultat.setAdapter(monAdapteurDeList);

		// score
		score = 0;
		computeScore();
	}

	//Redefinition de la methode onClick pour les actions des buttons
	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.buttonRecommencer) {
			resultatList.clear();
			FragmentsActivity.questionNumber = 1;
			Intent intent = new Intent(ResultatActivity.this, FragmentsActivity.class);
			startActivity(intent);
		} else {
			resultatList.clear();
			FragmentsActivity.questionNumber = 1;
			Intent intent = new Intent(ResultatActivity.this, MainActivity.class);
			startActivity(intent);
		}
	}


	private void computeScore() {
		for (Resultat r : resultatList) {
			if (r.getCorrectAnswer().equals(r.getUserAnswer())) {
				score++;
			}
		}
		scoreTextView.setText("Votre score : " + score + " / 10");
	}


}
