package com.example.aller.drapeauapp.thread;

import android.os.Handler;
import android.os.Message;

import com.example.aller.drapeauapp.FragmentsActivity;
import com.example.aller.drapeauapp.MainActivity;

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

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        fragmentsActivity.incrementProgressBar();
        progress++;
        if (progress >= 20) {
            stopTimer();
            fragmentsActivity.resetProgressBar();
        }
    }

    @Override
    public void startTimer() {
        timerThread.start();
    }

    @Override
    public void stopTimer() {
        timerThread.stop();
        progress = 0;
    }

}
