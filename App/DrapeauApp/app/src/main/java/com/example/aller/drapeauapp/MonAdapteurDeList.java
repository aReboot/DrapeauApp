package com.example.aller.drapeauapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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

    private ImageView imageViewFlag;
    private TextView textViewCorrectAnswer;
    private TextView textViewUserAnswer;


    public MonAdapteurDeList(Context context, List<Resultat> resultat) {
        super(context, 0, resultat);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String urlImageForPicasso = "";

        Resultat resultat = getItem(position);
        Resources res = convertView.getResources();

        imageViewFlag = convertView.findViewById(R.id.imageViewFlag);
        textViewCorrectAnswer = convertView.findViewById(R.id.textViewCorrectAnswer);
        textViewUserAnswer = convertView.findViewById(R.id.textViewReponseUser);


        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView != null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_list_results, parent, false);

        DBConnection dbConnection = new DBConnection(getContext());
        try {
            urlImageForPicasso = dbConnection.getDaoDrapeau().queryForId(resultat.getCorrectAnswer()).getUrlImage();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Picasso.with(getContext()).load(urlImageForPicasso).into(imageViewFlag);
        textViewCorrectAnswer.setText(resultat.getCorrectAnswer());
        textViewUserAnswer.setText(resultat.getUserAnswer());


        return convertView;
    }


}
