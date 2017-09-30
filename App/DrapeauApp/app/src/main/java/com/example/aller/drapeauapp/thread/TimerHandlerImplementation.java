package com.example.aller.drapeauapp.thread;

import android.os.Handler;
import android.os.Message;

import com.example.aller.drapeauapp.FragmentsActivity;
import com.example.aller.drapeauapp.modele.Resultat;

/**
 * Created by Adrien on 19/09/2017.
 */

public class TimerHandlerImplementation extends Handler implements TimerHandler {

	private FragmentsActivity fragmentsActivity;
	private TimerThread timerThread;
	private int progress;


	public TimerHandlerImplementation(FragmentsActivity fragmentsActivity) {
		this.fragmentsActivity = fragmentsActivity;
		timerThread = new TimerThreadImplementation(this);
		progress = 0;
	}

	/*
	Le thread renvoie toutes les secondes un message vide au handler ; le traitement se fait donc ici.
	Au bout de 10 secondes on change le fragment et on remet la progressBar à zéro
	 */
	@Override
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		fragmentsActivity.incrementProgressBar();
		progress++;
		if (progress >= 11) {
			resetTimer();
			fragmentsActivity.resetProgressBar();
			fragmentsActivity.changeFragment();
		}
	}

	@Override
	public void startTimer() {
		progress = 0;
		fragmentsActivity.resetProgressBar();
		timerThread.start();
	}

	@Override
	public void resetTimer() {
		progress = 0;
	}

	@Override
	public void stopTimer() {
		timerThread.stop();
	}

}
