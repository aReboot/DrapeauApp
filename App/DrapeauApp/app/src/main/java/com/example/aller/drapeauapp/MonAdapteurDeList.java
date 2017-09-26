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

    private  class ResusltatViewHolder{
        public ImageView imageViewFlag;
        public TextView textViewCorrectAnswer;
        public TextView textViewUserAnswer;
    }


    public MonAdapteurDeList(Context context, List<Resultat> resultat) {
        super(context, 0, resultat);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String urlImageForPicasso = "";
        ResusltatViewHolder viewHolder = null;

        Resultat resultat = getItem(position);
        //Resources res = convertView.getResources();

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.row_list_results, parent, false);
            viewHolder = new ResusltatViewHolder();
            viewHolder.imageViewFlag = convertView.findViewById(R.id.imageViewFlag) ;
            viewHolder.textViewCorrectAnswer = convertView.findViewById(R.id.textViewCorrectAnswer);
            viewHolder.textViewUserAnswer = convertView.findViewById(R.id.textViewReponseUser);

        }else{
            viewHolder = (ResusltatViewHolder)convertView.getTag();
        }



        try {
            Log.i("MODELE"," resultat correct answer renvoie "+resultat.getCorrectAnswer());
            Log.i("DAO", " test sur le dao "+dbConnection.getDaoDrapeau().queryForId(resultat.getCorrectAnswer()).getUrlImage());
            urlImageForPicasso = dbConnection.getDaoDrapeau().queryForId(resultat.getCorrectAnswer()).getUrlImage();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Log.i("IMAGE","Tu me renvoie quoi ? "+Picasso.with(getContext()).load(urlImageForPicasso).toString());
        Picasso.with(getContext()).load(urlImageForPicasso).into(viewHolder.imageViewFlag);
        viewHolder.textViewCorrectAnswer.setText(resultat.getCorrectAnswer());
        viewHolder.textViewUserAnswer.setText(resultat.getUserAnswer());


        return convertView;
    }


}
