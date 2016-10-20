package com.markoarsenovic.higherorlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    //TODO: Reset the random number when user gets it right
    //TODO: Validation when user does not enter the any number
    public void checkGuess(View view) {

        System.out.println("RANDOM NUMBER " + randomNumber);

        EditText guessNumber = (EditText) findViewById(R.id.guessText);

        String guessedNumberString = guessNumber.getText().toString();

        int guessedNumberInt = Integer.parseInt(guessedNumberString);

        System.out.println("GUESSED NUMBER " + guessedNumberInt);

        String message = "";

        if (guessedNumberInt > randomNumber) {
            message = "Too high!";
        }else if(guessedNumberInt < randomNumber){
            message = "To low!";
        }
        else{
            message = "Correct!";
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randomGenerator = new Random();

        randomNumber = randomGenerator.nextInt(21);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
