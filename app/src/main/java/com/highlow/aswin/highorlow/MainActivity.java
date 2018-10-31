package com.highlow.aswin.highorlow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    void generateRandomNumber()
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
    }

    public void buttonClick(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        String guessedNumber = editText.getText().toString();
        int guessedNumberInt = Integer.parseInt(guessedNumber);

        String message;

        if(guessedNumberInt==randomNumber)
        {
            message = "Wow!! You hav guessed it right. Now try again.";
            generateRandomNumber();
        }
        else if(guessedNumberInt>randomNumber)
            message = "I guessed a number lesser than "+guessedNumberInt;
        else
            message = "I guessed a number greater than "+guessedNumberInt;

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
