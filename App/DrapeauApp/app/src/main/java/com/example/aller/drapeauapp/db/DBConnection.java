package com.example.aller.drapeauapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.aller.drapeauapp.modele.Associer;
import com.example.aller.drapeauapp.modele.Drapeau;
import com.example.aller.drapeauapp.modele.Quizz;
import com.example.aller.drapeauapp.modele.Utilisateur;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by aller on 19/09/2017.
 */

public class DBConnection extends OrmLiteSqliteOpenHelper{

    public static Dao<Drapeau, String> daoDrapeau;

    public static Dao<Quizz, Integer> daoQuizz;

    public static Dao<Utilisateur, Integer> daoUtilisateur;


    //CONSTRUCTEUR qui initialise nos Dao
    public DBConnection(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
        try {
            DBConnection.daoDrapeau = DaoManager.createDao(connectionSource, Drapeau.class);
            DBConnection.daoQuizz = DaoManager.createDao(connectionSource, Quizz.class);
            DBConnection.daoUtilisateur = DaoManager.createDao(connectionSource, Utilisateur.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //CREATION des tables de notre bases de données
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {

            TableUtils.createTable(connectionSource, Drapeau.class);

            TableUtils.createTable(connectionSource, Associer.class);

            TableUtils.createTable(connectionSource, Quizz.class);

            TableUtils.createTable(connectionSource, Utilisateur.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {

            TableUtils.dropTable(connectionSource, Drapeau.class, true);

            TableUtils.dropTable(connectionSource, Associer.class, true);

            TableUtils.dropTable(connectionSource, Quizz.class, true);

            TableUtils.dropTable(connectionSource, Utilisateur.class, true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
