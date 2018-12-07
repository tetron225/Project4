package com.example.android.quizapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActualQuiz extends AppCompatActivity {

    boolean played1 = false;
    boolean played2 = false;
    boolean played3 = false;
    boolean played4 = false;
    boolean played5 = false;
    boolean played6 = false;
    boolean played7 = false;

    boolean bonus = false;

    int amount;
    int numWrong;

    boolean answer1;
    boolean answer2;
    boolean answer3;
    //boolean answer4;
    boolean answer5;
    boolean answer6;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);

        initializeUI();

        final RadioButton rbutton1 = (RadioButton) findViewById(R.id.soundA);
        final RadioButton rbutton2 = (RadioButton) findViewById(R.id.soundB);
        final RadioButton rbutton3 = (RadioButton) findViewById(R.id.soundC);
        final RadioButton rbutton4 = (RadioButton) findViewById(R.id.soundD);

        rbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                rbutton1.setChecked(true);
                rbutton2.setChecked(false);
                rbutton3.setChecked(false);
                rbutton4.setChecked(false);
                if(rbutton1.isChecked())
                    answer6 = false;
            }
        });

        rbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                rbutton1.setChecked(false);
                rbutton2.setChecked(true);
                rbutton3.setChecked(false);
                rbutton4.setChecked(false);
                if(rbutton2.isChecked())
                    answer6 = false;
            }
        });

        rbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                rbutton1.setChecked(false);
                rbutton2.setChecked(false);
                rbutton3.setChecked(true);
                rbutton4.setChecked(false);
                if(rbutton3.isChecked())
                    answer6 = false;
            }
        });

        rbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                rbutton1.setChecked(false);
                rbutton2.setChecked(false);
                rbutton3.setChecked(false);
                rbutton4.setChecked(true);
                if(rbutton4.isChecked())
                    answer6 = true;

            }
        });




    }

    //Button click for Question 1
    public void radioClick1(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch(view.getId()) {
            case R.id.coffee:
                if (checked)
                    answer1 = false;
                break;
            case R.id.cappucino:
                if (checked)
                    answer1 = false;
                break;
            case R.id.mocha:
                if (checked)
                    answer1 = false;
                break;
            case R.id.java:
                if(checked)
                    answer1 = checked;
                break;
        }

    }

    //Button click for Question 2
    public void radioClick2(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.matt:
                if(checked)
                    answer2 = false;
                break;
            case R.id.ben:
                if(checked)
                    answer2 = checked;
                break;
            case R.id.rob:
                if(checked)
                    answer2 = false;
                break;
            case R.id.bale:
                if(checked)
                    answer2 = false;
                break;
        }
    }

    //Button click for Question 3
    public void radioClick3(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.humor:
                if(checked)
                    answer3 = false;
                break;
            case R.id.hello:
                if(checked)
                    answer3 = checked;
                break;
            case R.id.just:
                if(checked)
                    answer3 = false;
                break;
            case R.id.jub:
                if(checked)
                    answer3 = false;
                break;
        }
    }
    //Button click for Question 5
    public void radioClick5(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.A:
                if(checked)
                    answer5 = checked;
                break;
            case R.id.B:
                if(checked)
                    answer5 = false;
                break;
            case R.id.C:
                if(checked)
                    answer5 = false;
                break;
            case R.id.D:
                if(checked)
                    answer5 = false;
                break;
        }
    }

    /*   public void radioClick6(View view) {
           boolean checked = ((RadioButton) view).isChecked();

           switch(view.getId()) {
               case R.id.soundA:
                   if(checked)
                       answer6 = false;
                   break;
               case R.id.soundB:
                   if(checked)
                       answer6 = false;
                   break;
               case R.id.soundC:
                   if(checked)
                       answer6 = false;
                   break;
               case R.id.soundD:
                   if(checked)
                       answer6 = checked;
                   break;
                   }

       }
   */
    //The "ENTER" button for question 1
    public void enterButton1(View view){
        if(played1)
        {
            Toast.makeText(this, "You've already answered this question", Toast.LENGTH_LONG).show();
            return;
        }

        if(answer1) {
            score += calculateScore(bonus);
            Toast.makeText(this, "The answer is correct. You have" + score + " points", Toast.LENGTH_LONG).show();
            played1 = true;
        }
        else
            Toast.makeText(this, "The answer is wrong. Try again", Toast.LENGTH_LONG).show();
    }

    //The "ENTER" button for question 2
    public void enterButton2(View view){
        if(played2)
        {
            Toast.makeText(this, "You've already answered this question", Toast.LENGTH_LONG).show();
            return;
        }

        if(answer2){
            score += calculateScore(bonus);
            Toast.makeText(this, "The answer is correct. You have" + score + " points", Toast.LENGTH_LONG).show();
            played2 = true;
        }
        else
            Toast.makeText(this, "The answer is wrong. Try again", Toast.LENGTH_LONG).show();
    }

    public void enterButton3(View view){
        bonus = true;
        if(played3)
        {
            Toast.makeText(this, "You've already answered this question", Toast.LENGTH_LONG).show();
            return;
        }

        if(answer3){
            score += calculateScore(bonus);
            String s = "You got the bonus question correct. This was worth 2 points You have ";
            Toast.makeText(this, s + score + " points", Toast.LENGTH_LONG).show();
            played3 = true;
        }
        else
            Toast.makeText(this, "The answer is wrong. Try again", Toast.LENGTH_LONG).show();
    }

    public void enterButton4(View view){
        if(played4)
        {
            Toast.makeText(this, "You've already answered this question", Toast.LENGTH_LONG).show();
            return;
        }

        int wrongAmount = amountOfWrong();
        if(wrongAmount == 0){
            score += calculateScore(bonus);
            Toast.makeText(this, "The answer is correct. You have " + score + " points", Toast.LENGTH_LONG).show();
            played4 = true;
        }
        else {
            Toast.makeText(this, "The answer is wrong. There are " + wrongAmount + " wrong", Toast.LENGTH_LONG).show();
        }


    }

    public void enterButton5(View view){
        if(played5)
        {
            Toast.makeText(this, "You've already answered this question", Toast.LENGTH_LONG).show();
            return;
        }

        if(answer5){
            score += calculateScore(bonus);
            Toast.makeText(this, "The answer is correct. You have" + score + " points", Toast.LENGTH_LONG).show();
            played5 = true;
        }
        else
            Toast.makeText(this, "The answer is wrong. Try again", Toast.LENGTH_LONG).show();
    }

    public void enterButton6(View view) {
        if(played6){
            Toast.makeText(this, "You've already answered this question", Toast.LENGTH_LONG).show();
            return;
        }

        if(answer6){
            bonus = true;
            score+= calculateScore(bonus);
            String s = "You got the bonus question correct. This was worth 2 points You have ";
            Toast.makeText(this, s + score + " points", Toast.LENGTH_LONG).show();
            played6 = true;
        }
        else
            Toast.makeText(this, "The answer is wrong. Try again", Toast.LENGTH_LONG).show();



    }

    public void enterButton7(View view) {


        if(played7) {
            Toast.makeText(this, "You've already answered this question", Toast.LENGTH_LONG).show();
            return;
        }

        EditText et = (EditText) findViewById(R.id.input);
        String theanswer = et.getText().toString();
        String answe = "remember that you will die";

        boolean truth = isItTrue(theanswer, answe);

        Log.v(theanswer, "remember that you will die");
        Log.v(answe, "Is it the same?");

        if(truth) {
            score += calculateScore(bonus);
            String s = "You got the bonus question correct. This was worth 2 points You have ";
            Toast.makeText(this, s + score + " points", Toast.LENGTH_LONG).show();
            played7 = true;
        }
        else if(numWrong > 2) {

            Toast.makeText(this, "The answer is wrong. Hint: remember that you will _ _ _", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "The answer is wrong. Try again", Toast.LENGTH_LONG).show();
            numWrong+=1;
        }

    }

    //Calculates the total number of scores.
    private int calculateScore(boolean ans)
    {
        int updateScore = 0;
        if(ans){
            updateScore+=2;
            bonus = false;
            return updateScore;
        }
        else {
            updateScore += 1;
            return updateScore;
        }
    }

    private boolean isItTrue(String s1, String s2)
    {
        if(s1.equals(s2))
        {
            return true;
        }
        else
            return false;
    }

    private int amountOfWrong(){
        CheckBox checkedBox1 = findViewById(R.id.banana);
        boolean check1 = checkedBox1.isChecked();
        CheckBox checkedBox2 = findViewById(R.id.apple);
        boolean check2 = checkedBox2.isChecked();
        CheckBox checkedBox3 = findViewById(R.id.arg);
        boolean check3 = checkedBox3.isChecked();
        CheckBox checkedBox4 = findViewById(R.id.rapids);
        boolean check4 = checkedBox4.isChecked();
        CheckBox checkedBox5 = findViewById(R.id.dragon);
        boolean check5 = checkedBox5.isChecked();
        CheckBox checkedBox6 = findViewById(R.id.lychee);
        boolean check6 = checkedBox6.isChecked();
        CheckBox checkedBox7 = findViewById(R.id.ligen);
        boolean check7 = checkedBox7.isChecked();
        CheckBox checkedBox8 = findViewById(R.id.atro);
        boolean check8 = checkedBox8.isChecked();
        CheckBox checkedBox9 = findViewById(R.id.stone);
        boolean check9 = checkedBox9.isChecked();

        //to reset 'amount' if the person got it wrong before
        amount = 0;

            if(!check1) {
                amount += 1;
            }
            if(!check2) {
                amount += 1;
            }
            if(check3) {
                amount += 1;
            }
            if(check4) {
                amount += 1;
            }
            if(!check5) {
                amount += 1;
            }
            if(!check6) {
                amount += 1;
            }
            if(!check7) {
                amount += 1;
            }
            if(check8) {
                amount += 1;
            }
            if(check9) {
                amount += 1;
            }


        /*switch(9) {
            case 1:
                if (!check1) {
                    amount += 1;
                    break;
                }
            case 2:
                if (!check2) {
                    amount += 1;
                }
            case 3:
                if (check3)
                    amount += 1;
            case 4:
                if (check4)
                    amount += 1;
            case 5:
                if (!check5){
                    amount += 1;
                }
            case 6:
                if(!check6){
                    amount += 1;
                }
            case 7:
                if(!check7){
                    amount += 1;
                }
            case 8:
                if(check8)
                    amount += 1;
            case 9:
                if(check9)
                    amount += 1;
                break;
        }*/

        return amount;
    }

    public void initializeUI() {
        Button b1 = (Button) findViewById(R.id.play1);
        Button p1 = (Button) findViewById(R.id.pause1);

        Button b2 = (Button) findViewById(R.id.play2);
        Button p2 = (Button) findViewById(R.id.pause2);

        Button b3 = (Button) findViewById(R.id.play3);
        Button p3 = (Button) findViewById(R.id.pause3);

        Button b4 = (Button) findViewById(R.id.play4);
        Button p4 = (Button) findViewById(R.id.pause4);

        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.songalpha);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.songbeta);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.songceta);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.songdelta);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1.start();
            }
        });
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp1.pause();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp2.start();
            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.pause();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3.pause();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp4.start();
            }
        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp4.pause();
            }
        });

    }
}
