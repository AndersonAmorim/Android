package com.markoarsenovic.timerdemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /***FIRST APPROACH***/
       /*
       //Handler ALLOWS CHUNKS OF CODE TO RUN IN THE DELAYED WAY, example every seconds, minute etc.

        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                //Insert code to be run every second or whatever...
                Log.i("Runnable has run!", "a second must have passed...");
                handler.postDelayed(this, 1000);  //this refers to run method
            }
        };

        handler.post(run);  //kick the run method to run for the first time!!!
        */

        /***SECOND APPROACH***/
        new CountDownTimer(10000, 1000){  //count from 10s, every 1s until 0

            @Override
            public void onTick(long millisUntilFinished) {
                //Counter is counting down (every second)
                Log.i("Seconds left", String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                //Counter is finished!!! (after 10s)
                Log.i("Done!!!", "Countdown timer finished");
            }
        }.start();
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
