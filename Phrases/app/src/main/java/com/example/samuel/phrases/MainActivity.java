package com.example.samuel.phrases;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonTapped(View view)
    {
        int id = view.getId();
        String  ourId ="";
        ourId = view.getResources().getResourceEntryName(id);
        int resoursesId = getResources().getIdentifier(ourId , "raw" ,"com.example.samuel.phrases");
        MediaPlayer mediaPlayer =  MediaPlayer.create(this ,resoursesId );
        mediaPlayer.start();


    }
}



