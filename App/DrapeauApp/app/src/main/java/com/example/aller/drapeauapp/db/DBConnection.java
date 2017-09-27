package com.example.aller.drapeauapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.util.Pair;
import android.util.Log;

import com.example.aller.drapeauapp.modele.Associer;
import com.example.aller.drapeauapp.modele.Drapeau;
import com.example.aller.drapeauapp.modele.Quizz;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by aller on 19/09/2017.
 */

public class DBConnection extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "DeltaQuizz.db";

	private static final int DATABASE_VERSION = 1;

	public Dao<Drapeau, String> daoDrapeau;

	public Dao<Quizz, Integer> daoQuizz;

	public Dao<Associer, Pair<Drapeau, Quizz>> daoAssocierPair;


	//CONSTRUCTEUR
	public DBConnection(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

		Log.i("DATABASE", "Constructeur DBConnection invoked");

	}


	//CREATION des tables de notre bases de données
	@Override
	public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

		try {

			TableUtils.createTable(connectionSource, Drapeau.class);

			TableUtils.createTable(connectionSource, Quizz.class);

			TableUtils.createTable(connectionSource, Associer.class);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Log.i("DATABASE", "Création des tables ok");

	}


	@Override
	public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			TableUtils.dropTable(connectionSource, Associer.class, true);

			TableUtils.dropTable(connectionSource, Drapeau.class, true);

			TableUtils.dropTable(connectionSource, Quizz.class, true);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		Log.i("DATABASE", "onUpgrade invoked");
	}

	public Dao<Drapeau, String> getDaoDrapeau() throws SQLException {
		if (daoDrapeau == null) {
			daoDrapeau = getDao(Drapeau.class);
		}
		return daoDrapeau;
	}

	public Dao<Quizz, Integer> getDaoQuizz() throws SQLException {
		if (daoQuizz == null) {
			daoQuizz = getDao(Quizz.class);
		}
		return daoQuizz;
	}

	public Dao<Associer, Pair<Drapeau, Quizz>> getDaoAssocierPair() throws SQLException {
		if (daoAssocierPair == null) {
			daoAssocierPair = getDao(Associer.class);
		}
		return daoAssocierPair;
	}
}

