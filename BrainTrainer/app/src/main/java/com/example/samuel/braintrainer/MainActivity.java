package com.example.samuel.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startButon ;
    TextView equitionText ;
    Button button0 ;
    Button button1 ;
    Button button2 ;
    Button button3 ;
    TextView resultTextView ;
    TextView pointsTextView ;
    TextView timerTextView ;
    Button playAgainButton ;
    RelativeLayout gameRelativeLayout ;
    ArrayList<Integer> resultsList =  new ArrayList<Integer>() ;
    int correctLocationAsuer ;
    int score =0 ;
    int totalQuestians = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equitionText = (TextView) findViewById(R.id.sumTextView);
        button0 = (Button) findViewById(R.id.button0) ;
        button1 = (Button) findViewById(R.id.button1) ;
        button2 = (Button) findViewById(R.id.button2) ;
        button3 = (Button) findViewById(R.id.button3) ;
        resultTextView = (TextView) findViewById(R.id.resultTextView) ;
        pointsTextView =  (TextView) findViewById(R.id.pointsTextView);
        timerTextView =  (TextView) findViewById(R.id.timerTextView);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        gameRelativeLayout =  (RelativeLayout) findViewById(R.id.gameRelativeLayout) ;
        playAgain ( findViewById(R.id.playAgainButton));





    }

    public void generateQuestions ()
    {
        resultsList.clear();
        Random rand = new Random() ;
        int a =rand.nextInt(21);
        int b =rand.nextInt(21);
        equitionText.setText(Integer.toString(a) + " + " +Integer.toString(b));
        correctLocationAsuer =rand.nextInt(4);
        for(int  i=0 ;i<4 ;i++)
        {
            if  (i==correctLocationAsuer)
                resultsList.add(a+b);
            else
            {
                int  incorrectAnser = rand.nextInt(42);
                while (incorrectAnser==(a+b))
                    incorrectAnser = rand.nextInt(42);
                resultsList.add(incorrectAnser);

            }
        }

        button0.setText(Integer.toString(resultsList.get(0)));
        button1.setText(Integer.toString(resultsList.get(1)));
        button2.setText(Integer.toString(resultsList.get(2)));
        button3.setText(Integer.toString(resultsList.get(3)));
    }





    public void chooseAnswer(View view)
    {

        String state = resultTextView.getText().toString();
        if (state.contains("Result")) {}
        else
        {

            if (view.getTag().toString().equals(Integer.toString(correctLocationAsuer))) {
                score++;
                resultTextView.setText("Correct !");
            } else {
                resultTextView.setText("Wrong !");

            }
            totalQuestians++;
            pointsTextView.setText(Integer.toString(score) + " / " + Integer.toString(totalQuestians));
            generateQuestions();

        }
    }


    public void playAgain(final View view)
    {
        score =0 ;
        totalQuestians =0 ;
        pointsTextView.setText("0 / 0");
        timerTextView.setText("30S");
        resultTextView.setText("");
        playAgainButton.setVisibility(view.INVISIBLE) ;
        generateQuestions () ;

        new CountDownTimer(30100 ,1000)
        {

            @Override
            public void onTick(long millisUntilFinished)
            {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000)+"S" );

            }

            @Override
            public void onFinish()
            {
                resultTextView.setText("Result : "+ Integer.toString(score)+" / " + Integer.toString(totalQuestians));
                timerTextView.setText("0S" );
                playAgainButton.setVisibility(view.VISIBLE);


            }
        }.start() ;

    }
}
