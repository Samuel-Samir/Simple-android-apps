package com.example.samuel.saiga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ImageView red = (ImageView) findViewById(R.id.imageRead);
        ImageView yallow = (ImageView) findViewById(R.id.imageYallow);
        red.setTranslationY(-1000f);
        red.setImageResource(R.drawable.red);

        red.animate().translationYBy(1000f).rotation(360).setDuration(300);
        yallow.setTranslationY(-1000f);
        yallow.setImageResource(R.drawable.yellow);
        yallow.animate().translationYBy(1000f).rotation(360).setDuration(300);



    }

    public void StartPlay(View view)
    {
        Intent myIntent =  new Intent(this , MainActivity.class);
        startActivity(myIntent);

    }
}
