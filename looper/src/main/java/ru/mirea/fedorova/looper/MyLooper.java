package ru.mirea.fedorova.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.Date;

public class MyLooper extends Thread {
    private int number = 0;
    Handler handler;
    @SuppressLint("HandlerLeak")
    @Override
    public void run(){
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                Log.d("MyLooper", number + ":"+ msg.getData().getString("KEY"));
                number++;
                Date d = new Date();
                int seconds = d.getSeconds();
                Log.d("MyLooper", "Возраст: " + seconds + " и " +
                        msg.getData().getString("KEY1"));
            }
        };
        Looper.loop();
    }
}
