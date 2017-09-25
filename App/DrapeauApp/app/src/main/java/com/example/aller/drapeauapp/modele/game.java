package com.example.aller.drapeauapp.modele;

import com.j256.ormlite.stmt.query.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Adrien on 25/09/2017.
 */

public class game {

	Random random;
	List<Integer> randomList;

	public game() {
		random = new Random();
		randomList = new ArrayList<>();
	}

	public List<Integer> generateQuizz(int min, int max) {
		for (int i = 0; i < 4; i++) {
			randomList.add(generateRandomInt(min, max));
		}
		return randomList;
	}

	public int generateRandomInt(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
}
