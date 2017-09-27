package com.example.aller.drapeauapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aller.drapeauapp.db.DBConnection;
import com.example.aller.drapeauapp.modele.Resultat;
import com.squareup.picasso.Picasso;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 22/09/2017.
 */


public class MonAdapteurDeList extends ArrayAdapter<Resultat> {


	DBConnection dbConnection = new DBConnection(getContext());


	/*
	ViewHolder va nous permettre de ne pas devoir rechercher
	les vues à chaque appel de getView, nous gagnons ainsi en performance
	*/
	private class ResusltatViewHolder {
		public ImageView imageViewFlag;
		public TextView textViewCorrectAnswer;
		public TextView textViewUserAnswer;
	}

	/*
	*###################################################################################################
	####################################################################################################
	--------------------------------------------CONSTRUCTEUR--------------------------------------------
	####################################################################################################
	####################################################################################################
	*/

	public MonAdapteurDeList(Context context, List<Resultat> resultat) {
		super(context, 0, resultat);
	}

	/*
    *###################################################################################################
    ####################################################################################################
    --------------------------------------------METHODES------------------------------------------------
    ####################################################################################################
    ####################################################################################################
    */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		String urlImageForPicasso = "";
		ResusltatViewHolder viewHolder = null;

		// nous récupérons l'item de la liste demandé par getView
		Resultat resultat = getItem(position);


		// au premier appel ConvertView est null, on inflate notre layout
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

			convertView = mInflater.inflate(R.layout.row_list_results, parent, false);

			// nous plaçons dans notre ViewHolder les vues de notre layout
			viewHolder = new ResusltatViewHolder();
			viewHolder.imageViewFlag = convertView.findViewById(R.id.imageViewFlag);
			viewHolder.textViewCorrectAnswer = convertView.findViewById(R.id.textViewCorrectAnswer);
			viewHolder.textViewUserAnswer = convertView.findViewById(R.id.textViewReponseUser);
			convertView.setTag(viewHolder);

		} else {
		    /*
		    convertView n'est pas null, nous récupérons notre objet ViewHolder
		    et évitons ainsi de devoir retrouver les vues à chaque appel de getView
		    */
			viewHolder = (ResusltatViewHolder) convertView.getTag();
		}


		try {
			Log.i("MODELE", " resultat correct answer renvoie " + resultat.getCorrectAnswer());
			Log.i("DAO", " test sur le dao " + dbConnection.getDaoDrapeau().queryForId(resultat.getCorrectAnswer()).getUrlImage());

			//on récupère l'url correspondant aux pays de la bonne réponse
			urlImageForPicasso = dbConnection.getDaoDrapeau().queryForId(resultat.getCorrectAnswer()).getUrlImage();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Log.i("IMAGE", "Tu me renvoie quoi ? " + Picasso.with(getContext()).load(urlImageForPicasso).toString());

		//la librairie picasso nous met la bonne image correspondant à la bonne réponse
		Picasso.with(getContext()).load(urlImageForPicasso).into(viewHolder.imageViewFlag);

		//on écrit la bonne réponse dans le champs textViewCorrectAnswer
		viewHolder.textViewCorrectAnswer.setText("Correct answer " + resultat.getCorrectAnswer());

		//on écrit la réponse de l'utilisateur dans textViewUserAnswer
		viewHolder.textViewUserAnswer.setText("your answer " + resultat.getUserAnswer());


		return convertView;
	}


}
