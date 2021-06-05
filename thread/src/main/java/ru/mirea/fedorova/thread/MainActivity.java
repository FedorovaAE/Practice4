package ru.mirea.fedorova.thread;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    float result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Текущий поток: " + mainThread.getName());
        mainThread.setName("MireaThread");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());
    }

    public void onClick(View view) {
        TextView tv = (TextView) findViewById(R.id.textView);
        EditText lessons = (EditText) findViewById(R.id.editText1);
        EditText days = (EditText) findViewById(R.id.editText2);

        Runnable runnable = new Runnable() {
            public void run() {
                /*int numberThread = counter++;
                Log.i("ThreadProject", "Запущен поток № " + numberThread);
                long endTime = System.currentTimeMillis() + 20 * 1000;
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            wait(endTime - System.currentTimeMillis());
                        } catch (Exception e) {
                        }
                    }
                }
                Log.i("ThreadProject", "Выполнен поток № " + numberThread);*/

                result = Float.parseFloat(lessons.getText().toString()) /
                       Float.parseFloat(days.getText().toString());
                tv.post (new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("Среднее количество пар в день: " + Float.toString(result));
                    }
                });
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

}