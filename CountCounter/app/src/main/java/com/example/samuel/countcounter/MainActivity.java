package com.example.samuel.countcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoure =0 ;
    int scoureB =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void plas_3Points (View view)
    {
        scoure+=3 ;
        displayForTeamA(scoure);

    }
    public void plas_2Points (View view)
    {
        scoure+=2 ;
        displayForTeamA(scoure);

    }
    public void plas_1Points (View view)
    {
        scoure+=1 ;
        displayForTeamA(scoure);

    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void plas_3PointsB (View view)
    {
        scoureB+=3 ;
        displayForTeamB(scoureB);

    }
    public void plas_2PointsB (View view)
    {
        scoureB+=2 ;
        displayForTeamB(scoureB);

    }
    public void plas_1PointsB (View view)
    {
        scoureB+=1 ;
        displayForTeamB(scoureB);

    }

    public void displayForTeamB(int score) {
        TextView T = (TextView) findViewById(R.id.team_a_scoreB) ;
        T.setText(String.valueOf(score));
    }


    public void initialize (View view)
    {
        scoure=0;
        scoureB=0;
        displayForTeamB(scoureB);
        displayForTeamA(scoureB);


    }

    }
