package com.example.maqso.servicestest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    Boolean isRunning = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        isRunning = true;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20 && isRunning; i++) {
                    try {
                        Thread.sleep(1000);
                        Log.d(MainActivity.TAG, "run: " + i);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onDestroy() {
        isRunning = false;
        Log.d(MainActivity.TAG, "onDestroy: service Stop");
        super.onDestroy();
    }
}
