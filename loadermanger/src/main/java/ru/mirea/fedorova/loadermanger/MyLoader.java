package ru.mirea.fedorova.loadermanger;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

public class MyLoader extends AsyncTaskLoader<String> {
    //private String firstName;
    //public static final String ARG_WORD = "word";
    private String message;
    public static final String ARG_WORD_1 = "m";
    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            //firstName = args.getString(ARG_WORD);
            message = args.getString(ARG_WORD_1);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Override
    public String loadInBackground() {
        List<Character> letters = new ArrayList();
        for(char c:message.toCharArray()){
            letters.add(c);
        }
        StringBuilder output = new StringBuilder(message.length());
        while(letters.size() != 0){
            int randPicker = (int)(Math.random() * letters.size());
            output.append(letters.remove(randPicker));
        }
        return output.toString();

        //SystemClock.sleep(5000);
        //return firstName;
    }


}
