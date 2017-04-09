package com.example.samuel.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Welcome_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);
    }

    public void StartPlay(View view)
    {
        Intent my_intent =  new Intent(this , MainActivity.class);
        startActivity(my_intent);
    }
}
