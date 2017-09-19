package com.example.aller.drapeauapp.thread;

/**
 * Created by Adrien on 19/09/2017.
 */

public class TimerThreadImplementation implements TimerThread {

    private Thread backgroundThread;
    private TimerHandlerImplementation timerHandler;

    public TimerThreadImplementation(TimerHandlerImplementation timerHandler) {
        this.timerHandler = timerHandler;
    }

    @Override
    public void start() {
        if (backgroundThread == null) {
            backgroundThread = new Thread(this);
            backgroundThread.start();
        }
    }

    @Override
    public void stop() {
        if (backgroundThread != null) {
            backgroundThread.interrupt();
        }
    }

    /*
    Envoie un message vide toutes les secondes au Handler, le traitement sera effectué par le Handler.
     */
    @Override
    public void run() {
        try {
            while (!backgroundThread.isInterrupted()) {
                timerHandler.sendEmptyMessage(0);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        } finally {
            backgroundThread = null;
        }
    }
}
