package com.example.aller.drapeauapp.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aller.drapeauapp.R;
import com.example.aller.drapeauapp.ResultatActivity;
import com.example.aller.drapeauapp.db.DBConnection;
import com.example.aller.drapeauapp.modele.Drapeau;
import com.example.aller.drapeauapp.modele.RandomFlag;
import com.example.aller.drapeauapp.modele.Resultat;
import com.squareup.picasso.Picasso;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by aller on 19/09/2017.
 */

public class FragmentsQuizzImage extends Fragment implements View.OnClickListener,
		ProgressBarProgression, generateQuizz {


	//TextView
	private TextView texteViewQuizzImage;

	//ImageButton
	private ImageButton imageButtonQuizzImageUn;
	private ImageButton imageButtonQuizzImageDeux;
	private ImageButton imageButtonQuizzImageTrois;
	private ImageButton imageButtonQuizzImageQuatre;


	//ProgressBar
	private ProgressBar progressBarQuizzImage;

	//Interface
	private FragmentChanger mFragmentChanger;

	// database
	private DBConnection dbConnection = null;

	// resultat
	private Resultat resultat;

	// Drapeaux quizz
	private List<Drapeau> drapeauList = null;



/*
*###################################################################################################
####################################################################################################
--------------------------------------------METHODES------------------------------------------------
####################################################################################################
####################################################################################################
*/


	//redefinition de la methode onCreate View
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.quizz_image_fragment, container, false);

		////////////////////////////////////////////////////////////////////////////////////
		//TexteView
		texteViewQuizzImage = view.findViewById(R.id.textViewQuizzImageFragment);

		//ImageButton
		imageButtonQuizzImageUn = view.findViewById(R.id.imageButtonQuizzImageUne);
		imageButtonQuizzImageUn.setOnClickListener(this);

		imageButtonQuizzImageDeux = view.findViewById(R.id.imageButtonQuizzImageDeux);
		imageButtonQuizzImageDeux.setOnClickListener(this);

		imageButtonQuizzImageTrois = view.findViewById(R.id.imageButtonQuizzImageTrois);
		imageButtonQuizzImageTrois.setOnClickListener(this);

		imageButtonQuizzImageQuatre = view.findViewById(R.id.imageButtonQuizzImageQuatre);
		imageButtonQuizzImageQuatre.setOnClickListener(this);


		//ProgressBar
		progressBarQuizzImage = view.findViewById(R.id.progressBarQuizzImage);
		//Definition de la couleur de la ProgressBar
		Drawable drawable = progressBarQuizzImage.getProgressDrawable();
		drawable.setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);
		progressBarQuizzImage.setProgressDrawable(drawable);


		//////////////////////////////////////////////////////////////////////////////////////

		//On retourne la vue
		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
		generateRandomQuizz();
	}


	/*
		Progress Bar
		*/
	@Override
	public void incrementProgressBar() {
		progressBarQuizzImage.incrementProgressBy(1);
	}

	@Override
	public void resetProgressBar() {
		progressBarQuizzImage.setProgress(0);
	}

	/*
	GenerateQuizz
	 */
	@Override
	public void generateRandomQuizz() {
		try {
			dbConnection = new DBConnection(getContext());
			RandomFlag randomFlag = new RandomFlag();
			List<Integer> integers = new ArrayList<>();
			int min = 1;
			int max = dbConnection.getDaoDrapeau().queryForAll().size();
			integers = randomFlag.generateRandomIntList(min, max, 4);
			drapeauList = new ArrayList<>();
			for (Integer i:
			     integers) {
				drapeauList.add(dbConnection.getDaoDrapeau().queryForAll().get(i));
			}
			Picasso.with(getContext()).load(drapeauList.get(0).getUrlImage()).into(imageButtonQuizzImageUn);
			Picasso.with(getContext()).load(drapeauList.get(1).getUrlImage()).into(imageButtonQuizzImageDeux);
			Picasso.with(getContext()).load(drapeauList.get(2).getUrlImage()).into(imageButtonQuizzImageTrois);
			Picasso.with(getContext()).load(drapeauList.get(3).getUrlImage()).into(imageButtonQuizzImageQuatre);
			texteViewQuizzImage.setText(drapeauList.get(randomFlag.generateRandomInt(0,3)).getPays());
			resultat = new Resultat("", "");
			resultat.setCorrectAnswer(texteViewQuizzImage.getText().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	//////////////////////////////////////////////////////////////////////////////////////

	//Interface pour le changement de fragment
	public interface FragmentChanger {
		public void remplacementDunFragmentUneFoisLeQuizzLance();
	}


	//redefintion de la methode onAttach pour le changement de fragment
	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		try {
			mFragmentChanger = (FragmentChanger) context;
		} catch (ClassCastException e) {
			throw new ClassCastException(context.toString() + " erreur On Attach");
		}
	}


	//redefinition de la methode onClick pour les actions des buttonImages
	@Override
	public void onClick(View view) {
		Log.i("info", "click sur une reponse");
		if (view.getId() == imageButtonQuizzImageUn.getId()) {
			resultat.setUserAnswer(drapeauList.get(0).getPays());
		} else if (view.getId() == imageButtonQuizzImageDeux.getId()) {
			resultat.setUserAnswer(drapeauList.get(1).getPays());
		} else if (view.getId() == imageButtonQuizzImageTrois.getId()) {
			resultat.setUserAnswer(drapeauList.get(2).getPays());
		} else if (view.getId() == imageButtonQuizzImageQuatre.getId()) {
			resultat.setUserAnswer(drapeauList.get(3).getPays());
		}
		ResultatActivity.resultatList.add(resultat);

		mFragmentChanger.remplacementDunFragmentUneFoisLeQuizzLance();
	}

}//end.
