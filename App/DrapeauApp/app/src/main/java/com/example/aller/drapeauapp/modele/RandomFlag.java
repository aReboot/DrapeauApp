package com.example.aller.drapeauapp.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Adrien on 25/09/2017.
 */

public class RandomFlag {

	Random random;
	List<Integer> randomList;

	public RandomFlag() {
		random = new Random();
		randomList = new ArrayList<>();
	}

	public List<Integer> generateRandomIntList(int min, int max, int size) {
		for (int i = 0; i < size; i++) {
			int randomInt = generateRandomInt(min, max);
			while (randomList.contains(randomInt)) {
				randomInt = generateRandomInt(min, max);
			}
			randomList.add(randomInt);
		}
		return randomList;
	}

	public int generateRandomInt(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
}
