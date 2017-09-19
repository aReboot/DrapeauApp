package com.example.aller.drapeauapp.thread;

import android.os.Handler;
import android.os.Message;

import com.example.aller.drapeauapp.MainActivity;

/**
 * Created by Adrien on 19/09/2017.
 */

public class TimerHandlerImplementation extends Handler implements TimerHandler {

    private MainActivity mainActivity;
    private TimerThread timerThread;
    private int progress;

    public TimerHandlerImplementation(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        timerThread = new TimerThreadImplementation(this);
        progress = 0;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        mainActivity.incrementProgressBar();
        progress++;
        if (progress >= 20) {
            stopTimer();
            mainActivity.resetProgressBar();
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
