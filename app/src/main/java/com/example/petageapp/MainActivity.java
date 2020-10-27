package com.example.petageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView petImg = findViewById(R.id.myPetImg);

        final int[] petImages = {R.drawable.samoyed,
                R.drawable.corgi,
                R.drawable.chewie,
                R.drawable.catloaf,
                R.drawable.kitty};

        Random rndObj = new Random();
        int myRandomPet = rndObj.nextInt(5); //0...4 indices

        //Random rndObj = new Random();
        final int myRandomPetAge = rndObj.nextInt(21); //0....20

        petImg.setImageResource(petImages[myRandomPet]);

        //Button btnPress = findViewById(R.id.calcBtn);

    }

    Random rndObj = new Random();
    public int myRandomPetAge = rndObj.nextInt(21); //0....20

//        btnPress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View) {

//                Log.i("CalcPetAgeApp","calcBtn is tapped");

//            }


    public void calcBtnPressed(View calcBtn){


        final MediaPlayer correctMP3 = MediaPlayer.create(this, R.raw.applause);
        final MediaPlayer wrongMP3 = MediaPlayer.create(this, R.raw.dog_wimper);

        Log.i("CalcPetAgeApp","The random generated num is : " + myRandomPetAge);
        Log.i("CalcPetAgeApp","calcBtn is tapped");

        EditText petGuessTextField = findViewById(R.id.userInput);
        Log.i("age", petGuessTextField.getText().toString());

        TextView petAgeTextView = findViewById(R.id.result);

        if (myRandomPetAge==Integer.parseInt(petGuessTextField.getText().toString())) {
            petAgeTextView.setText("Your guess is correct! My pet is " + myRandomPetAge + "! \uD83E\uDD17");
            correctMP3.start();
        }
        else if(Math.abs(myRandomPetAge-Integer.parseInt(petGuessTextField.getText().toString()))<3){
            petAgeTextView.setText("Very close! Guess Again...\uD83E\uDDD0");
        }
        else{
            petAgeTextView.setText("Incorrect! Guess Again...\uD83D\uDE3F");

            wrongMP3.start();
        }

    }




}